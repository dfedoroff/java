public class SinglyLinkedList {

    private SinglyLinkedNode head;

    public void add(int data) {
        SinglyLinkedNode newNode = new SinglyLinkedNode(data);

        if (head == null) {
            head = newNode;
        } else {
            SinglyLinkedNode currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
    }

    public String toString() {
        SinglyLinkedNode currentNode = head;
        StringBuilder result = new StringBuilder();

        while (currentNode != null) {
            result.append(currentNode.getData()).append(" ");
            currentNode = currentNode.getNext();
        }
        return result.toString();
    }

    public void reverse() {
        SinglyLinkedNode prev = null;
        SinglyLinkedNode current = head;
        SinglyLinkedNode next;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }
}