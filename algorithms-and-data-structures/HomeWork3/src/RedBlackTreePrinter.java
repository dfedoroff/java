public class RedBlackTreePrinter {

    public void printTree(RedBlackNode node) {
        printTree(node, "", true);
    }

    private void printTree(RedBlackNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.print(prefix);
            System.out.print(isLeft ? "├──" : "└──");
            System.out.print(node.isRed() ? "(R) " : "(B) ");
            System.out.println(node.getValue());
            printTree(node.getLeftChild(), prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.getRightChild(), prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}