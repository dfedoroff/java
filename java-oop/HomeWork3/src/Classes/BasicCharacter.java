package Classes;

import Interfaces.Informable;
import Interfaces.Stepable;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class BasicCharacter implements Informable, Stepable {

	public static int count;

	private int id;
	protected String character;
	protected int attack;
	protected int defence;
	protected int shots;
	protected int[] damage;
	protected double maxHealth;
	protected double health;
	protected int speed;
	protected Boolean isDelivery;
	protected Boolean isMagic;
	protected String squad;
	protected Coordinates position;

	public BasicCharacter(String character, int attack, int defence, int shots, int[] damage, double maxHealth, int speed, Boolean isDelivery, Boolean isMagic, String squad) {
		id = ++count;
		this.character = character;
		this.attack = attack;
		this.defence = defence;
		this.shots = shots;
		this.damage = damage;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.speed = speed;
		this.isDelivery = isDelivery;
		this.isMagic = isMagic;
		this.squad = squad;
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
				+ ", максимум здоровья=" + maxHealth
				+ ", скорость=" + speed
				+ ", доставка=" + isDelivery
				+ ", магия=" + isMagic
				+ ", squad = " + squad;
	}

	@Override
	public String getInfo(){
		return  "идентификатор=" + id
				+ ", персонаж=" + character
				+ ", здоровье=" + health
				+ ", squad = " + squad;
	}
	@Override
	public void step(ArrayList<BasicCharacter> squad) {
	}

	public int getId() {
		return id;
	}

	public String getCharacter() {
		return character;
	}

	public void setAttack(int attack) {
		if (attack > 0 && attack < 18) {
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
		if (defence > 0 && defence <= 12) {
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
		if (shots >= 0 && shots <= 32) {
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

	public void setMaxHealth(double maxHealth) {
		if (maxHealth > 0 && maxHealth <= 30) {
			this.maxHealth = maxHealth;
		} else {
			System.out.println("Вы пытаетесь установить неверное значение здоровья.");
			System.out.println("Введите целое число в диапазоне от 1 до 30 включительно.");
		}
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public void setHealth(double health) {
		if (health > 0 && health <= 30) {
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
		if (speed >= 3 && speed <= 9) {
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

	public String getSquad() {
		return squad;
	}

	public Coordinates getPosition() {
		return position;
	}
}
