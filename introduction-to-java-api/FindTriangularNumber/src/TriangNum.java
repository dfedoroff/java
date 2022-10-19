public class TriangNum {
	public static int calculate(int n) {
		int result = 0;

		for (int i = 0; i <= n; i++) {
			result += i;
		}
		return result;
	}
}
