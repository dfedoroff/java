package Classes;

import Interfaces.Stepable;

import java.util.ArrayList;

public class Sniper extends BasicCharacter implements Stepable {

    public Sniper(ArrayList<BasicCharacter> squad) {
        super(4, 5, 0, new int[]{1,3}, 10, 4, false, false);
        super.squad = squad;
    }

    @Override
    public void step() {
    }
}
