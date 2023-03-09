public class Main {

    public static void main(String[] args) {
        try {
            processUserInput();
        } catch (WrongParsingDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}