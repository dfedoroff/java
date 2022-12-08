package Classes.AbstractTypes;

public abstract class Healers extends BasicCharacter {

    public Healers(Coordinates position, char characterSymbol, int attack, int defence, int[] damage, double maxHealth, int speed, Squad allies, Squad enemies) {
        super(position, characterSymbol, attack, defence, damage, maxHealth, speed, allies, enemies);
    }

    @Override
    public void step() {

        BasicCharacter characterDamaged = allies.getCharacterLeastHP();

        characterDamaged.setHealth(characterDamaged.getHealth() - this.getDamage()[1]);

        if (characterDamaged.getHealth() > characterDamaged.getMaxHealth()) {
            characterDamaged.setHealth(characterDamaged.getMaxHealth());
        }
    }
}
