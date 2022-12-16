package Classes.AbstractTypes;

import GameBoard.Logger;

import java.util.Arrays;

public abstract class BasicCharacter implements BaseBehaviour {

    private static int count;

    protected char characterSymbol;
    protected Squad allies;
    protected Squad enemies;
    protected Coordinates position;
    protected int order;
    protected int id;
    protected String status;
    protected int amount;
    protected int attack;
    protected int defence;
    protected int shots;
    protected int[] damage;
    protected double maxHealth;
    protected double health;
    protected int speed;

    public BasicCharacter(Coordinates position, char characterSymbol, int attack, int defence,
                          int[] damage, double maxHealth, int speed, Squad allies, Squad enemies, int amount) {
        this.id = ++count;
        this.characterSymbol = characterSymbol;
        this.position = position;
        this.amount = amount;
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

        double res = 0.0;
        int x = attacker.attack - defender.defence;
        if (x > 0) {
            res = attacker.damage[1] * attacker.amount;
        } else if (x < 0) {
            res = attacker.damage[0] * attacker.amount;
        } else {
            res = ((double) (attacker.damage[0] + attacker.damage[1]) / 2) * attacker.amount;
        }
        return res;
    }

    public void harm(double damage, BasicCharacter attacker) {

        double squadHP = (amount - 1) * maxHealth + health;
        squadHP -= damage;

        if (squadHP <= 0) {
            Logger.logDead(this);
            health = 0;
            amount = 0;
            status = "dead";
            characterSymbol = '_';
            allies.remove(this);
            allies = Squad.CHARACTER_KILLED;
            Squad.CHARACTER_KILLED.add(this);
        } else {
            amount = (int) (squadHP / maxHealth);
            if (squadHP % maxHealth != 0) {
                health = squadHP - amount * maxHealth;
                amount += 1;
            } else {
                health = maxHealth;
            }
            Logger.logHit(attacker, this, damage);
        }
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getOrder() {
        return order;
    }

    public String getSquadColor() {
        return allies.squadColor;
    }

    public char getCharacterSymbol() {
        return characterSymbol;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
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

    public int[] getDamage() {
        return damage;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCoordinates(int x, int y) {
        this.position = new Coordinates(x, y);
    }
}
