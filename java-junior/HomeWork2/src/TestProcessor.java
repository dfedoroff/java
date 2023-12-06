import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс, отвечающий за обработку и выполнение тестов, определенных в
 * пользовательском классе.
 */
public class TestProcessor {

    /**
     * Запускает тесты в указанном классе.
     *
     * @param testClass Класс, содержащий тестовые методы.
     */
    public static void runTest(Class<?> testClass) {
        // Создание экземпляра тестового класса.
        Object testObj = createTestInstance(testClass);

        // Получение методов, аннотированных как BeforeEach и AfterEach.
        List<Method> beforeEachMethods = getMethodsAnnotatedWith(testClass, BeforeEach.class);
        List<Method> afterEachMethods = getMethodsAnnotatedWith(testClass, AfterEach.class);

        // Получение и сортировка тестовых методов по порядку, заданному в аннотации
        // Test.
        List<Method> testMethods = getMethodsAnnotatedWith(testClass, Test.class, Skip.class);
        testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).order()));

        // Выполнение тестовых методов.
        for (Method testMethod : testMethods) {
            invokeMethods(testObj, beforeEachMethods); // Вызов методов перед каждым тестом.
            invokeTestMethod(testMethod, testObj); // Выполнение теста.
            invokeMethods(testObj, afterEachMethods); // Вызов методов после каждого теста.
        }
    }

    /**
     * Создает экземпляр тестового класса.
     *
     * @param testClass Класс для создания экземпляра.
     * @return Экземпляр тестового класса.
     */
    private static Object createTestInstance(Class<?> testClass) {
        try {
            return testClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Не удалось создать объект класса \"" + testClass.getName() + "\"", e);
        }
    }

    /**
     * Возвращает список методов, аннотированных указанной аннотацией, исключая
     * методы с другими аннотациями.
     *
     * @param testClass       Класс, в котором искать методы.
     * @param annotationClass Аннотация для поиска методов.
     * @param excluding       Аннотации, исключающие метод из выборки.
     * @return Список методов, соответствующих критериям.
     */
    private static List<Method> getMethodsAnnotatedWith(Class<?> testClass, Class<? extends Annotation> annotationClass,
            Class<? extends Annotation>... excluding) {
        List<Method> methods = new ArrayList<>();
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotationClass)) {
                checkTestMethod(method);
                boolean excluded = false;
                for (Class<? extends Annotation> exclude : excluding) {
                    if (method.isAnnotationPresent(exclude)) {
                        excluded = true;
                        break;
                    }
                }
                if (!excluded) {
                    methods.add(method);
                }
            }
        }
        return methods;
    }

    /**
     * Проверяет, что метод является void и не принимает аргументов.
     *
     * @param method Метод для проверки.
     */
    private static void checkTestMethod(Method method) {
        if (!method.getReturnType().equals(void.class) || method.getParameterCount() != 0) {
            throw new IllegalArgumentException(
                    "Метод \"" + method.getName() + "\" должен быть void и не иметь аргументов");
        }
    }

    /**
     * Вызывает методы на указанном объекте.
     *
     * @param obj     Объект, на котором вызывать методы.
     * @param methods Список методов для вызова.
     */
    private static void invokeMethods(Object obj, List<Method> methods) {
        for (Method method : methods) {
            try {
                method.invoke(obj);
            } catch (Exception e) {
                throw new RuntimeException("Не удалось запустить метод \"" + method.getName() + "\"", e);
            }
        }
    }

    /**
     * Вызывает тестовый метод на указанном объекте.
     *
     * @param method Тестовый метод для вызова.
     * @param obj    Объект, на котором вызывается тестовый метод.
     */
    private static void invokeTestMethod(Method method, Object obj) {
        try {
            method.invoke(obj);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось запустить тестовый метод \"" + method.getName() + "\"", e);
        }
    }
}
