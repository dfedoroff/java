package Classes;

import Interfaces.Stepable;

import java.util.ArrayList;

public class Monk extends BasicCharacter implements Stepable {

    public Monk(ArrayList<BasicCharacter> squad) {
        super(17, 12, 0, new int[]{-5, -5}, 30, 9, false, true);
        super.squad = squad;
    }

    @Override
    public void step() {
        BasicCharacter characterDamaged = squad.get(0);
        for (BasicCharacter character : squad) {
            if (character.getHealth() / character.getMaxHealth() < characterDamaged.getHealth() / characterDamaged.getMaxHealth()) {
                characterDamaged = character;
            }
        }

        characterDamaged.setHealth(characterDamaged.getHealth() - getDamage()[1]);

        if (characterDamaged.getHealth() > characterDamaged.getMaxHealth()) {
            characterDamaged.setHealth(characterDamaged.getMaxHealth());
        }
    }
}
