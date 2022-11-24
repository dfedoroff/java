import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		ArrayList<BasicCharacter> characters = new ArrayList<>(Arrays.asList(
				new Farmer(), new Outlaw(), new Sniper(), new Wizard(), new Spearman(), new Archer(), new Monk()));

		int charactersLimit = 50;
		int charactersUnique = characters.size();
		String characterSelected = "Monk";
	}
}
