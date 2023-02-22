import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        System.out.print("Введите максимальное количество игрушек в базе данных: ");
        int n = InputValidation.validateIntInput();

        ToyDatabase.createToyDatabase(n);

        System.out.print("Введите количество игрушек участвующих в разыгрыше: ");
        int m = InputValidation.validateIntInput();

        ToyManager manager = new ToyManager();
        PriorityQueue<Toy> firstQueue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            firstQueue.offer(manager.nextToy(false));
        }
        for (int i = 0; i < m; i++) {
            manager.appendResults(firstQueue.poll());
        }
    }
}
