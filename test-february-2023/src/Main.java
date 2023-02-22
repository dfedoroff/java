public class Main {

    public static void main(String[] args) {
        System.out.print("Введите максимальное количество игрушек в базе данных: ");
        int n = InputValidation.validateIntInput();

        System.out.print("Введите количество игрушек участвующих в разыгрыше: ");
        int m = InputValidation.validateIntInput();
    }
}
