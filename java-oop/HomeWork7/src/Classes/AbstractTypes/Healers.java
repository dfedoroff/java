package Classes.AbstractTypes;

import GameBoard.Logger;

public abstract class Healers extends BasicCharacter {

    public Healers(Coordinates position, char characterSymbol, int attack, int defence, int[] damage, double maxHealth, int speed, Squad allies, Squad enemies, int amount) {
        super(position, characterSymbol, attack, defence, damage, maxHealth, speed, allies, enemies, amount);
    }

    @Override
    public void step() {

        BasicCharacter characterDamaged = allies.getCharacterLeastHP();

        if (characterDamaged != null && characterDamaged.health / characterDamaged.maxHealth <= 0.75) {
            characterDamaged.setHealth(characterDamaged.getHealth() - this.getDamage()[1]);

            if (characterDamaged.getHealth() > characterDamaged.getMaxHealth()) {
                characterDamaged.setHealth(characterDamaged.getMaxHealth());
            }
            Logger.logHeal(this, characterDamaged);
        } else {
            for (BasicCharacter target : enemies) {
                if (Math.abs(damage[0]) > target.health + target.maxHealth * target.amount) {
                    target.harm(-Math.abs(damage[0]), this);
                    return;
                }
            }

            for (BasicCharacter target : Squad.CHARACTER_KILLED) {

                char character = target.getClass().getSimpleName().charAt(0);

                if (character == 'O' || character == 'S' || character == 'L' || character == 'A') {
                    target.amount = 1;
                    target.health = 1;
                    target.characterSymbol = character;

                    allies.add(target);
                    target.allies = this.allies;
                    target.enemies = this.enemies;
                    Logger.logResurrect(this, target);

                    Squad.CHARACTER_KILLED.remove(target);
                    return;
                }
            }

            BasicCharacter target = enemies.getCharacterLeastHP();
            target.harm(Math.abs(damage[0]), this);
        }
    }
}
