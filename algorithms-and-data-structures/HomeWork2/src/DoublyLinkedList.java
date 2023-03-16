public class DoublyLinkedList {

    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void reverse() {
        DoublyLinkedNode temp, tempNext;

        temp = head;

        while (temp != null) {
            tempNext = temp.getNext();
            temp.setNext(temp.getPrev());
            temp.setPrev(tempNext);
            temp = tempNext;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    public void add(int data) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);

        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
    }

    public String toString() {
        DoublyLinkedNode currentNode = head;
        StringBuilder result = new StringBuilder();

        while (currentNode != null) {
            result.append(currentNode.getData()).append(" ");
            currentNode = currentNode.getNext();
        }
        return result.toString();
    }
}