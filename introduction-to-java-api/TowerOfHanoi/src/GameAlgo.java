public class GameAlgo {

	public static void moveDisk(char src, char dest, char buff, int count) {

		if (count == 0) {
			System.out.println("Для игры кол-во дисков не может быть нулевым.");
			System.out.println("Повторите ввод!");
		} else if (count == 1) {
			System.out.println(String.format("из %s в %s", src, dest));
		} else {
			moveDisk(src, buff, dest, count - 1);
			System.out.println(String.format("из %s в %s", src, dest));
			moveDisk(buff, dest, src, count - 1);
		}
	}
}
