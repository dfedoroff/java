package Classes.AbstractTypes;

import GameBoard.Board;
import GameBoard.DirectionSeeker;

public abstract class Warriors extends BasicCharacter {

    public Warriors(Coordinates position, char characterSymbol, int attack, int defence, int[] damage, double maxHealth, int speed, Squad allies, Squad enemies, int amount) {
        super(position, characterSymbol, attack, defence, damage, maxHealth, speed, allies, enemies, amount);
    }

    @Override
    public void step() {

        BasicCharacter target = enemies.getClosest(this.position);

        if (target != null) {
            if (target.position.isClose(this.position)) {
                target.harm(calculateDamage(this, target), this);
            } else {
                DirectionSeeker direction = new DirectionSeeker(this.position, target.position);
                if (direction.calcDistance() != -1) {
                    Board.moveCharacter(this, direction.getFreeCellCloserToEnemy());
                }
            }
        }
    }
}
