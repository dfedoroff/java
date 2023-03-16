public class SinglyLinkedNode {

    private int data;
    private SinglyLinkedNode next;

    public SinglyLinkedNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public SinglyLinkedNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedNode next) {
        this.next = next;
    }
}