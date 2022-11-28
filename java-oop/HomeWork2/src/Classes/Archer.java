package Classes;

import Interfaces.Stepable;

import java.util.ArrayList;

public class Archer extends BasicCharacter implements Stepable {

    public Archer(ArrayList<BasicCharacter> squad) {
        super(6, 3, 16, new int[]{2, 3}, 10, 4, false, false);
        super.squad = squad;
    }

    @Override
    public void step() {
    }
}