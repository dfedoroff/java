package Classes.AbstractTypes;

import GameBoard.Board;

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
                if (target.position.y - this.position.y != 0) {
                    if (target.position.y > this.position.y && Board.isFree(this.position.x, this.position.y + 1)) {
                        Board.move(this, "вправо");
                        return;
                    } else if (target.position.y < this.position.y && Board.isFree(this.position.x, this.position.y - 1)) {
                        Board.move(this, "влево");
                        return;
                    }
                }

                if (target.position.x - this.position.x != 0) {
                    if (target.position.x > this.position.x && Board.isFree(this.position.x + 1, this.position.y))
                        Board.move(this, "вниз");
                    else if (target.position.y < this.position.y && Board.isFree(this.position.x - 1, this.position.y))
                        Board.move(this, "вверх");
                }
            }
        }
    }
}
