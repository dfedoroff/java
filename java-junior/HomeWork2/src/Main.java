public class Main {

    public static void main(String[] args) {
        TestProcessor.runTest(MyTest.class);
    }

    /**
     * Внутренний класс, содержащий тестовые методы.
     */
    static class MyTest {

        /**
         * Метод, выполняемый перед каждым тестом.
         */
        @BeforeEach
        void beforeTest() {
            System.out.println("Подготовка к тесту");
        }

        /**
         * Тестовый метод с порядковым номером -2.
         */
        @Test(order = -2)
        void firstTest() {
            System.out.println("firstTest запущен");
        }

        /**
         * Тестовый метод без указания порядкового номера (по умолчанию 0).
         */
        @Test
        void secondTest() {
            System.out.println("secondTest запущен");
        }

        /**
         * Тестовый метод с порядковым номером 5.
         */
        @Test(order = 5)
        void thirdTest() {
            System.out.println("thirdTest запущен");
        }

        /**
         * Метод, выполняемый после каждого теста.
         */
        @AfterEach
        void afterTest() {
            System.out.println("Завершение теста");
        }
    }
}
