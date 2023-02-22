import java.util.PriorityQueue;

public class Queue {
    PriorityQueue<Toy> queue = new PriorityQueue<>();
    boolean removeAfterGetting = false;

    public Queue(ToyManager manager, int quantity) {
        Toy toy = manager.nextToy(false);

        for (int i = 0; i < quantity && toy != null; i++) {
            queue.offer(toy);
            toy = manager.nextToy(false);
        }
    }

    public Queue(ToyManager manager, int quantity, boolean removeAfterQueueing) {
        this.removeAfterGetting = removeAfterQueueing;
        Toy toy = manager.nextToy(removeAfterQueueing);

        for (int i = 1; i < quantity && toy != null; i++) {
            queue.offer(toy);
            toy = manager.nextToy(removeAfterQueueing);
        }
    }
}
