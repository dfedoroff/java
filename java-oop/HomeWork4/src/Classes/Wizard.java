package Classes;

public class Wizard extends BasicCharacter {

    public Wizard(int line, int column, Squad allies, Squad enemies) {

        super(new Coordinates(line, column), 'W', 17, 12, new int[]{-5, -5}, 30, 9, allies, enemies);
    }

    @Override
    public void step() {

        BasicCharacter characterDamaged = super.allies.getCharacterLeastHP();

        characterDamaged.setHealth(characterDamaged.getHealth() - this.getDamage()[1]);

        if (characterDamaged.getHealth() > characterDamaged.getMaxHealth()) {
            characterDamaged.setHealth(characterDamaged.getMaxHealth());
        }
    }
}
