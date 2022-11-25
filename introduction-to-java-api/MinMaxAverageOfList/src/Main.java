import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();

		int size = 10;
		int range = 10;

		ListManip.fillListRandomNums(list, size, range);
		System.out.println("Оригинальный список: " + list);
		ListManip.findMinMaxElem(list);
		ListManip.findAvg(list);
	}
}
