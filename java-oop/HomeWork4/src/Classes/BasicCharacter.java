package Classes;

import java.util.Arrays;

public abstract class BasicCharacter implements BaseBehaviour {

    private static int count;
    private char characterSymbol;
    protected Squad allies;
    protected Squad enemies;

    protected Coordinates position;
    protected int order;
    protected int id;
    protected int attack;
    protected int defence;
    protected int shots;
    protected int[] damage;
    protected double maxHealth;
    protected double health;
    protected int speed;
    protected String status;

    public BasicCharacter(Coordinates position, char characterSymbol, int attack, int defence,
                          int[] damage, double maxHealth, int speed, Squad allies, Squad enemies) {
        this.id = ++count;
        this.characterSymbol = characterSymbol;
        this.position = position;
        this.attack = attack;
        this.defence = defence;
        this.shots = 0;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.speed = speed;
        this.status = "готов";

        this.allies = allies;
        allies.add(this);
        this.enemies = enemies;

        switch (characterSymbol) {
            case 'O', 'L' -> order = 1;
            case 'S', 'A' -> order = 2;
            case 'M', 'W' -> order = 3;
            case 'F' -> order = 4;
        }
    }

    public String getInfo() {
        return "идентификатор=" + id
                + ", персонаж=" + this.getClass().getSimpleName()
                + ", атака=" + attack
                + ", защита=" + defence
                + ", выстрелы=" + shots
                + ", урон=" + Arrays.toString(damage)
                + ", здоровье=" + health
                + ", максимум здоровья=" + maxHealth
                + ", скорость=" + speed;
    }

    @Override
    public String toString() {
        return this.getInfo();
    }

    public static double calculateDamage(BasicCharacter attacker, BasicCharacter defender) {
        int x = attacker.attack - defender.defence;
        if (x > 0) return attacker.damage[1];
        else if (x < 0) return attacker.damage[0];
        else return (double) (attacker.damage[0] + attacker.damage[1]) / 2;
    }

    public void harm(double damage) {

        health -= damage;

        if (health <= 0) {
            health = 0;
            status = "убит";
            characterSymbol = '_';
            allies.remove(this);
            allies = Squad.THE_KILLED;
        }
    }

    public int getOrder() {
        return order;
    }

    public String getColor() {
        return allies.squadColor;
    }

    public char getCharacterSymbol() {
        return characterSymbol;
    }

    public Coordinates getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getShots() {
        return shots;
    }

    public void setDamage(int[] damage) {
        this.damage = damage;
    }

    public int[] getDamage() {
        return damage;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public String getStatus() {
        return status;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
