package Classes;

import java.util.ArrayList;

public class Monk extends BasicCharacter {

    public Monk(String squad, int x, int y) {
        super("Monk", 12, 7, 0, new int[]{-4, -4}, 30, 5, false, true, squad);
        super.position = new Coordinates(x, y);
    }

    public int findDamagedCharacter(ArrayList<BasicCharacter> squad) {

        double hpLeftDamagedCharacter = squad.get(0).getHealth() / squad.get(0).getMaxHealth();
        int damageIndex = 0;

        for (int i = 1; i < squad.size(); i++) {
            double hpLeft = squad.get(i).getHealth() / squad.get(i).getMaxHealth();
            if (hpLeft < hpLeftDamagedCharacter) {
                hpLeftDamagedCharacter = hpLeft;
                damageIndex = i;
            }
        }
        return damageIndex;
    }
    @Override
    public void step(ArrayList<BasicCharacter> squad) {

        int damageIndex = findDamagedCharacter(squad);
        double hpNow = squad.get(damageIndex).getHealth();
        double hpMax = squad.get(damageIndex).getMaxHealth();

        for (int i = 0; i < Math.abs(getDamage()[0]); i++) {
            if (hpNow + 1 < hpMax) {
                hpNow += 1;
            }
        }
        squad.get(damageIndex).setHealth(hpNow);
    }
}
