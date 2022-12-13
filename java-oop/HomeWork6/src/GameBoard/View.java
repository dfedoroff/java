package GameBoard;

import Classes.AbstractTypes.BasicCharacter;

import java.util.ArrayDeque;

public class View {

    public static int step = 0;

    public void view() {

        System.out.println(AnsiColors.ANSI_RED + "Ход: " + step++ + AnsiColors.ANSI_RESET);
        System.out.println(Constants.top10);

        ArrayDeque<BasicCharacter> characterInRow = new ArrayDeque<>();

        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                BasicCharacter character = Board.board[i][j];
                if (character == null) {
                    System.out.print("|   ");
                } else {
                    characterInRow.add(character);
                    System.out.print("| " + character.getSquadColor() + character.getCharacterSymbol() + " " + AnsiColors.ANSI_RESET);
                }
            }
            System.out.print("|  ");

            while (!characterInRow.isEmpty()) {

                BasicCharacter character = characterInRow.pop();
                String characterName = character.getClass().getSimpleName();
                System.out.print(character.getSquadColor() + String.format("%-9s", characterName));
                System.out.print("x" + String.format("%-5d", character.getAmount()));
                System.out.print("номер=" + String.format("%-3d", character.getId()));
                System.out.print("здоровье=" + String.format("%4.1f/%-4.1f    ", character.getHealth(), character.getMaxHealth()) + AnsiColors.ANSI_RESET);
            }
            System.out.println();

            if (i != Constants.BOARD_SIZE - 1)
                System.out.println(Constants.mid10);
            else System.out.println(Constants.bottom10);
        }
    }
}
