public class Task3 {

    public static void main(String[] args) {

        int[] abc = { 1, 2 };
        abc[3] = 9;
        int a = 90;
        int b = 3;

        try {
            System.out.println(a / b);
            printSum(23, 234);
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}
