import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BasicCharacter {

	private static int count;

	private int id;
	private String character;
	private int attack;
	private int defence;
	private int shots;
	private int[] damage;
	private double health;
	private int speed;
	private boolean isDelivery;
	private boolean isMagic;

	public BasicCharacter(int attack, int defence, int shots, int[] damage, double health, int speed, boolean isDelivery, boolean isMagic) {
		this.id = ++count;
		this.character = getClass().getName();
		this.attack = attack;
		this.defence = defence;
		this.shots = shots;
		this.damage = damage;
		this.health = health;
		this.speed = speed;
		this.isDelivery = isDelivery;
		this.isMagic = isMagic;
	}

	@Override
	public String toString() {
		return "идентификатор=" + id
				+ ", персонаж=" + character
				+ ", атака=" + attack
				+ ", защита=" + defence
				+ ", выстрелы=" + shots
				+ ", урон=" + Arrays.toString(damage)
				+ ", здоровье=" + health
				+ ", скорость=" + speed
				+ ", доставка=" + isDelivery
				+ ", магия=" + isMagic;
	}

	public static ArrayList<BasicCharacter> createRandomCharacters(int lim, int size) {

		ArrayList<BasicCharacter> list = new ArrayList<>();

		Random rand = new Random();

		for (int i = 0; i < lim; i++) {
			switch (rand.nextInt(size)) {
				case 1 -> list.add(new Archer());
				case 2 -> list.add(new Farmer());
				case 3 -> list.add(new Outlaw());
				case 4 -> list.add(new Sniper());
				case 5 -> list.add(new Monk());
				case 6 -> list.add(new Wizard());
				case 7 -> list.add(new Spearman());
			}
		}
		return list;
	}

	public static void printRandomCharacterDetails(ArrayList<BasicCharacter> list, String character) {
		for (BasicCharacter characterType : list) {
			if (characterType.getClass().getName().equalsIgnoreCase(character)) {
				System.out.println(characterType);
			}
		}
	}

	public static void printCharacterDetails(ArrayList<BasicCharacter> list) {
		for (BasicCharacter characterType : list) {
			System.out.println(characterType);
		}
		System.out.println();
	}

	public int getCharacterID() {
		return id;
	}

	public void setAttack(int attack) {
		if (attack > 0) {
			this.attack = attack;
		} else {
			System.out.println("Вы пытаетесь установить неверное значение атаки.");
			System.out.println("Введите целое число в диапазоне от 1 до 17 включительно.");
		}
	}

	public int getAttack() {
		return attack;
	}

	public void setDefense(int defence) {
		if (defence > 0) {
			this.defence = defence;
		} else {
			System.out.println("Вы пытаетесь установить неверное значение защиты.");
			System.out.println("Введите целое число в диапазоне от 1 до 12 включительно.");
		}
	}

	public int getDefense() {
		return defence;
	}

	public void setShots(int shots) {
		if (shots >= 0) {
			this.shots = shots;
		} else {
			System.out.println("Вы пытаетесь установить неверное значение выстрелов.");
			System.out.println("Введите целое число в диапазоне от 0 до 32 включительно.");
		}
	}

	public int getShots() {
		return shots;
	}

	public void setDamage(int[] damage) {
		if (damage.length == 2 && damage[0] >= -5 && damage[1] <= 10) {
			this.damage = damage;
		} else {
			System.out.println("Вы пытаетесь установить неверное значение урона.");
			System.out.println("Введите два целых числа в диапазоне от -5 до 10 включительно.");
		}
	}

	public int[] getDamage() {
		return damage;
	}

	public void setHealth(double health) {
		if (health > 0) {
			this.health = health;
		} else {
			System.out.println("Вы пытаетесь установить неверное значение здоровья.");
			System.out.println("Введите целое число в диапазоне от 1 до 30 включительно.");
		}
	}

	public double getHealth() {
		return health;
	}

	public void setSpeed(int speed) {
		if (speed > 2) {
			this.speed = speed;
		} else {
			System.out.println("Вы пытаетесь установить неверное значение скорости.");
			System.out.println("Введите целое число в диапазоне от 3 до 9 включительно.");
		}
	}

	public int getSpeed() {
		return speed;
	}

	public void setDelivery(boolean isDelivery) {
		this.isDelivery = isDelivery;
	}

	public boolean isDelivery() {
		return isDelivery;
	}

	public void setMagic(boolean isMagic) {
		this.isMagic = isMagic;
	}

	public boolean isMagic() {
		return isMagic;
	}
}
