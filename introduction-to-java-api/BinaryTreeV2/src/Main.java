public class Main {
    static int[] leftPart = new int[10];
    
    static int leftIndex=0;
    static String result="";
    static String result2="";

    public static void main(String[] params) {
        Node root =
                new Node(1,
                    new Node(2,
                        new Node(4,
                            new Node(7),
                                new Node(9)), null),
                    new Node(3,
                        new Node(5),
                            new Node(6,
                                new Node(11), new Node(20))));
        
        System.out.println("Сумма дерева: " + root.sum());
        System.out.println(root.value+result);
        System.out.println(result2);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }

        public int sum() {
            int sum = value;

            if (left != null) {

                System.out.println(left.value);
                leftPart[leftIndex]=left.value;
                leftIndex+=1;
                result2+="("+left.value+",";
                if (right==null){
                    System.out.println("null)");
                    leftIndex-=1;
                    result+="("+leftPart[leftIndex]+","+"null)";
                    result2+="null)";
                    
                }
                sum += left.sum();

            }

            if (right != null) {

                System.out.println(right.value);
                leftIndex-=1;
                result2+=right.value+")";
                if (leftIndex>=0) {
                    result+= "("+leftPart[leftIndex]+","+right.value+")";   
                }
                sum += right.sum();
            }
            return sum;
        }
    }
}
