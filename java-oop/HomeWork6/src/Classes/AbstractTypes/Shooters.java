package Classes.AbstractTypes;

public abstract class Shooters extends BasicCharacter {

    public Shooters(Coordinates position, char characterSymbol, int attack, int defence, int[] damage, double maxHealth, int speed, Squad allies, Squad enemies, int amount) {
        super(position, characterSymbol, attack, defence, damage, maxHealth, speed, allies, enemies, amount);
    }

    @Override
    public void step() {

        BasicCharacter farmer = allies.getReadyFarmer();

        if (farmer != null) {
            shots++;
            farmer.status = "отработанный";
        }
        if (shots > 0) {

            BasicCharacter target = enemies.getClosest(this.position);

            if (target != null) {

                double damage = BasicCharacter.calculateDamage(this, target);

                if (this.speed < Coordinates.getDistance(this.position, target.position)) damage /= 2;
                shots--;
                target.harm(damage, this);
            }
        }
    }
}
