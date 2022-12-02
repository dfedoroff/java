package Classes;

import Interfaces.Stepable;

import java.util.ArrayList;

public class Farmer extends BasicCharacter implements Stepable {

    public Farmer(ArrayList<BasicCharacter> squad) {
        super(1, 1, 0, new int[]{1,1}, 1, 3, true, false);
        super.squad = squad;
    }

    @Override
    public void step() {
    }
}