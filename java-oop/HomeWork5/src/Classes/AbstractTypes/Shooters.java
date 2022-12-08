package Classes.AbstractTypes;

public abstract class Shooters extends BasicCharacter {

    public Shooters(Coordinates position, char characterSymbol, int attack, int defence, int[] damage, double maxHealth, int speed, Squad allies, Squad enemies) {
        super(position, characterSymbol, attack, defence, damage, maxHealth, speed, allies, enemies);
    }

    @Override
    public void step() {
        BasicCharacter farmer = allies.getReadyFarmer();

        if (farmer != null) {
            shots++;
            farmer.status = "used";
        }

        if (shots > 0) {

            BasicCharacter target = enemies.getClosest(this.position);
            double damage = BasicCharacter.calculateDamage(this, target);

            if (this.speed < Coordinates.getDistance(this.position, target.position)) damage /= 2;
            shots--;
            target.takeDamage(damage);
        }
    }
}
