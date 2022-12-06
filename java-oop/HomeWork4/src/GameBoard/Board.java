package GameBoard;

import Classes.BasicCharacter;
import Classes.Squad;

import java.util.*;

public class Board {

    public static int step = 0;
    BasicCharacter[][] character = new BasicCharacter[10][10];

    public void placeSquad(Squad squad) {

        for (BasicCharacter squadCharacter : squad) {
            character[squadCharacter.getPosition().x][squadCharacter.getPosition().y] = squadCharacter;
        }
    }

    public void view() {

        System.out.println(AnsiColors.ANSI_RED + "Ход: " + step++ + AnsiColors.ANSI_RESET);
        System.out.println(Constants.top10);

        ArrayDeque<BasicCharacter> charactersFound = new ArrayDeque<>();
        for (int i = 0; i < Constants.GANG_SIZE; i++) {
            for (int j = 0; j < Constants.GANG_SIZE; j++) {
                BasicCharacter squadCharacter = character[i][j];
                if (squadCharacter == null) System.out.print("|   ");
                else {
                    charactersFound.add(squadCharacter);
                    System.out.print("| " + squadCharacter.getColor() + squadCharacter.getCharacterSymbol() + " " + AnsiColors.ANSI_RESET);
                }
            }
            System.out.print("|  ");

            while (!charactersFound.isEmpty()) {

                BasicCharacter squadCharacter = charactersFound.pop();
                String squadCharacterName = squadCharacter.getClass().getSimpleName();
                System.out.print(squadCharacter.getColor() + String.format("%-9s", squadCharacterName));
                System.out.print("номер=" + String.format("%-3d", squadCharacter.getId()));
                System.out.print("здоровье=" + String.format("%4.1f/%-4.1f    ", squadCharacter.getHealth(), squadCharacter.getMaxHealth()) + AnsiColors.ANSI_RESET);
            }
            System.out.println();

            if (i != Constants.GANG_SIZE - 1)
                System.out.println(Constants.mid10);
            else System.out.println(Constants.bottom10);
        }
    }

    public void removeTheDead() {
        for (BasicCharacter[] line : character) {
            for (BasicCharacter squadCharacter : line)
                if (squadCharacter != null && squadCharacter.getStatus().equals("убит"))
                    character[squadCharacter.getPosition().x][squadCharacter.getPosition().y] = null;
        }
    }
}
