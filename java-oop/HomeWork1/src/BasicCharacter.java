import java.util.Arrays;

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
}
