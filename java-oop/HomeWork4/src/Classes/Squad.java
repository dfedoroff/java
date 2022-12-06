package Classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Squad implements Iterable<BasicCharacter> {

    public static final Squad THE_KILLED = new Squad(GameBoard.AnsiColors.ANSI_RED);
    public final ArrayList<BasicCharacter> squad = new ArrayList<>();
    public final String squadColor;

    public Squad(String squadColor) {
        this.squadColor = squadColor;
    }

    public void add(BasicCharacter character) {
        squad.add(character);
    }

    public void remove(BasicCharacter character) {
        squad.remove(character);
    }

    public BasicCharacter getCharacterLeastHP() {

        BasicCharacter characterDamaged = squad.get(0);

        for (BasicCharacter squadCharacter : squad) {
            if (squadCharacter.getHealth() / squadCharacter.getMaxHealth() < characterDamaged.getHealth() / characterDamaged.getMaxHealth()) {
                characterDamaged = squadCharacter;
            }
        }
        return characterDamaged;
    }

    public BasicCharacter getReadyFarmer() {

        for (BasicCharacter squadCharacter : squad) {
            if (squadCharacter.getClass().getSimpleName().equals("Farmer") && squadCharacter.status.equals("ready"))
                return squadCharacter;
        }
        return null;
    }

    public BasicCharacter getClosest(Coordinates characterPosition) {

        double distanceMin = Integer.MAX_VALUE;
        double distance = 0.0;
        BasicCharacter res = null;

        for (BasicCharacter squadCharacter : squad) {
            distance = Coordinates.getDistance(characterPosition, squadCharacter.position);
            if (distance < distanceMin) {
                distanceMin = distance;
                res = squadCharacter;
            }
        }
        return res;
    }

    public static ArrayList<BasicCharacter> createTurnsOrder(Squad squad1, Squad squad2) {

        ArrayList<BasicCharacter> order = new ArrayList<>(squad1.squad);
        order.addAll(squad2.squad);
        order.sort(Comparator.comparing(BasicCharacter::getOrder).thenComparing(BasicCharacter::getSpeed));
        return order;
    }

    public void printAll() {
        squad.forEach(System.out::println);
    }

    @Override
    public Iterator<BasicCharacter> iterator() {
        return squad.iterator();
    }
}
