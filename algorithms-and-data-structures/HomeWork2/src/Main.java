import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        for (int i = 0; i < 10; i++) {
            singlyLinkedList.add(i);
            doublyLinkedList.add(i);
        }

        Logger logger = Logger.getLogger(Main.class.getName());

        logger.info("Односвязный список: " + singlyLinkedList);
        singlyLinkedList.reverse();
        logger.info("Развернутый односвязный список: " + singlyLinkedList);

        logger.info("Двухсвязный список: " + doublyLinkedList);
        doublyLinkedList.reverse();
        logger.info("Развернутый двусвязный список: " + doublyLinkedList);
    }
}