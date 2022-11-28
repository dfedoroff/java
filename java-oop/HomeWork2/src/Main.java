import Classes.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {

		int charactersLimit = 10;
		int charactersBrightSide = 5;
		int charactersDarkSide = 4;

		ArrayList<BasicCharacter> squadBrightSide = createSquads(charactersLimit, charactersBrightSide);
		ArrayList<BasicCharacter> squadDarkSide = createSquads(charactersLimit, charactersDarkSide);
	}

	public static ArrayList<BasicCharacter> createSquads(int charactersLimit, int charactersUnique) {

		ArrayList<BasicCharacter> list = new ArrayList<>();

		Random rand = new Random();

		for (int i = 0; i < charactersLimit; i++) {
			if (charactersUnique == 5) {
				switch (rand.nextInt(1, charactersUnique)) {
					case 1 -> list.add(new Archer(list));
					case 2 -> list.add(new Farmer(list));
					case 3 -> list.add(new Outlaw(list));
					case 4 -> list.add(new Monk(list));
					case 5 -> list.add(new Spearman(list));
				}
			} else if (charactersUnique == 4) {
				switch (rand.nextInt(1, charactersUnique)) {
					case 1 -> list.add(new Farmer(list));
					case 2 -> list.add(new Outlaw(list));
					case 3 -> list.add(new Sniper(list));
					case 4 -> list.add(new Wizard(list));
				}
			}
		}
		return list;
	}
}
