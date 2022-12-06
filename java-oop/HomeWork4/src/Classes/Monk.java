package Classes;

public class Monk extends BasicCharacter {

    public Monk(int line, int column, Squad allies, Squad enemies) {

        super(new Coordinates(line, column), 'M', 12, 7, new int[]{-4, -4}, 30, 5, allies, enemies);
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
