package Classes;

import Interfaces.Stepable;

import java.util.ArrayList;

public class Spearman extends BasicCharacter implements Stepable {

    public Spearman(ArrayList<BasicCharacter> squad) {
        super(4, 5, 0, new int[]{1,3}, 10, 4, false, false);
        super.squad = squad;
    }

    @Override
    public void step() {
    }
}
