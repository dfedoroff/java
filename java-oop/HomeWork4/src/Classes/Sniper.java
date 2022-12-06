package Classes;

public class Sniper extends BasicCharacter {

    public Sniper(int line, int column, Squad allies, Squad enemies) {

        super(new Coordinates(line, column), 'S', 4, 5, new int[]{1, 3}, 10, 4, allies, enemies);
        this.shots = 16;
    }

    @Override
    public void step() {

        BasicCharacter peasant = allies.getReadyFarmer();

        if (peasant != null) {
            shots++;
            peasant.status = "used";
        }

        if (shots > 0) {

            BasicCharacter target = enemies.getClosest(this.position);
            double damage = BasicCharacter.calculateDamage(this, target);

            if (this.speed < Coordinates.getDistance(this.position, target.position)) damage /= 2;
            target.harm(damage);
        }
    }
}
