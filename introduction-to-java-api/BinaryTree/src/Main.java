public class Main {
	public static void main(String[] params) {

		Node root =
				new Node(15,
						new Node(62,
								new Node(4, null, new Node(1)), new Node(7)),
						new Node(99,
								new Node(11, new Node(88), null),
								new Node(80, new Node(2), new Node(9))));

		System.out.println("Сумма дерева: " + root.sum());
		System.out.println(root.value);
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
				sum += left.sum();
				System.out.println(left.value);
			}

			if (right != null) {
				sum += right.sum();
				System.out.println(right.value);
			}
			return sum;
		}
	}
}
