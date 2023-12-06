import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для определения метода как тестового.
 * Включает параметр order для определения порядка выполнения тестов.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    int order() default 0;
}

/**
 * Аннотация для метода, который должен выполняться перед каждым тестовым
 * методом.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface BeforeEach {
}

/**
 * Аннотация для метода, который должен выполняться после каждого тестового
 * метода.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface AfterEach {
}

/**
 * Аннотация для пропуска тестового метода при выполнении тестирования.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Skip {
}
