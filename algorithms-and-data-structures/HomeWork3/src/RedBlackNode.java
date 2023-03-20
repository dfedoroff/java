public class RedBlackNode {

    private int value;
    private boolean isRed;
    private RedBlackNode leftChild;
    private RedBlackNode rightChild;
    private RedBlackNode parent;

    public RedBlackNode(int value) {
        this.value = value;
        this.isRed = true;
    }

    public int getValue() {
        return value;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean isRed) {
        this.isRed = isRed;
    }

    public RedBlackNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RedBlackNode leftChild) {
        this.leftChild = leftChild;
    }

    public RedBlackNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(RedBlackNode rightChild) {
        this.rightChild = rightChild;
    }

    public RedBlackNode getParent() {
        return parent;
    }

    public void setParent(RedBlackNode parent) {
        this.parent = parent;
    }
}