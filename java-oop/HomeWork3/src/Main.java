import Classes.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static final int SQUAD_SIZE = 10;
	public static ArrayList<BasicCharacter> darkSide;
	public static ArrayList<BasicCharacter> brightSide;

	public static void main(String[] args) {

		init();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			ConsoleView.view();
			System.out.println("Нажмите Enter");
			scanner.nextLine();
		}
	}

	public static void init() {

		darkSide = new ArrayList<>();
		brightSide = new ArrayList<>();

		int x = 1;
		int y = 1;

		for (int i = 0; i < SQUAD_SIZE; i++) {
			switch (new Random().nextInt(4)) {
				case 0 -> brightSide.add(new Archer("Войны света", x++, y));
				case 1 -> brightSide.add(new Farmer("Войны света", x++, y));
				case 2 -> brightSide.add(new Outlaw("Войны света", x++, y));
				default -> brightSide.add(new Monk("Войны света", x++, y));
			}
		}

		x = 1;
		y = 10;

		for (int i = 0; i < SQUAD_SIZE; i++) {
			switch (new Random().nextInt(4)) {
				case 0 -> darkSide.add(new Farmer("Войны тьмы", x++, y));
				case 1 -> darkSide.add(new Outlaw("Войны тьмы", x++, y));
				case 2 -> darkSide.add(new Spearman("Войны тьмы", x++, y));
				default -> darkSide.add(new Wizard("Войны тьмы", x++, y));
			}
		}
	}
}
