package GameBoard;

import Classes.AbstractTypes.BasicCharacter;

import java.util.ArrayDeque;

public class View {

    public static int step = 0;

    public void view() {

        System.out.println(AnsiColors.ANSI_RED + "Ход: " + step++ + AnsiColors.ANSI_RESET);
        System.out.println(Constants.top10);

        ArrayDeque<BasicCharacter> characterInRow = new ArrayDeque<>();

        for (int i = 0; i < Constants.GANG_SIZE; i++) {
            for (int j = 0; j < Constants.GANG_SIZE; j++) {
                BasicCharacter character = Board.board[i][j];
                if (character == null) {
                    System.out.print("|   ");
                } else {
                    characterInRow.add(character);
                    System.out.print("| " + character.getTeamColor() + character.getCharacterSymbol() + " " + AnsiColors.ANSI_RESET);
                }
            }
            System.out.print("|  ");

            while (!characterInRow.isEmpty()) {

                BasicCharacter character = characterInRow.pop();
                String playerName = character.getClass().getSimpleName();
                System.out.print(character.getTeamColor() + String.format("%-9s", playerName));
                System.out.print("номер=" + String.format("%-3d", character.getId()));
                System.out.print("здоровье=" + String.format("%4.1f/%-4.1f    ", character.getHealth(), character.getMaxHealth()) + AnsiColors.ANSI_RESET);
            }
            System.out.println();

            if (i != Constants.GANG_SIZE - 1)
                System.out.println(Constants.mid10);
            else System.out.println(Constants.bottom10);
        }
    }
}
