package Classes;

import Interfaces.Stepable;

import java.util.ArrayList;

public class Outlaw extends BasicCharacter implements Stepable {

    public Outlaw(ArrayList<BasicCharacter> squad) {
        super(8, 3, 0, new int[]{2,4}, 10, 6, false, false);
        super.squad = squad;
    }

    @Override
    public void step() {
    }
}
