package Classes.AbstractTypes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Squad implements Iterable<BasicCharacter> {

    public static final Squad CHARACTER_KILLED = new Squad(GameBoard.AnsiColors.ANSI_RED);
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

    public BasicCharacter get(int x) { return squad.get(x); }

    public BasicCharacter getCharacterLeastHP() {

        BasicCharacter characterDamaged = squad.get(0);

        for (BasicCharacter character : squad) {
            if (character.getHealth() / character.getMaxHealth() < characterDamaged.getHealth() / characterDamaged.getMaxHealth()) {
                characterDamaged = character;
            }
        }
        return characterDamaged;
    }

    public BasicCharacter getReadyFarmer() {

        for (BasicCharacter character : squad) {
            if (character.getClass().getSimpleName().equals("Крестьянин") && character.status.equals("готов"))
                return character;
        }
        return null;
    }

    public BasicCharacter getClosest(Coordinates coordsOfTheOneLooking) {

        double minDist = Integer.MAX_VALUE;
        double currentDist = 0.0;
        BasicCharacter res = null;

        for (BasicCharacter character : squad) {
            currentDist = Coordinates.getDistance(coordsOfTheOneLooking, character.position);
            if (currentDist < minDist) {
                minDist = currentDist;
                res = character;
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
