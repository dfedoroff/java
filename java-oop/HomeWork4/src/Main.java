import Classes.*;
import GameBoard.AnsiColors;
import GameBoard.Board;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int GANG_SIZE = 10;

    public static void main(String[] args) {

        Squad darkSide = new Squad(AnsiColors.ANSI_GREEN);
        Squad brightSide = new Squad(AnsiColors.ANSI_YELLOW);
        createSquad(darkSide, brightSide, GameBoard.Constants.GANG_SIZE);

        Board board = new Board();
        board.placeSquad(darkSide);
        board.placeSquad(brightSide);

        board.view();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Нажмите ENTER для продолжения");
            System.out.println("Нажмите Q и ENTER чтобы выйти");
            String tmp = scanner.nextLine();

            if (tmp.equals("Q") || tmp.equals("q"))
                System.exit(0);

            makeStep(darkSide, brightSide);
            board.view();
        }
    }

    public static void makeStep(Squad squad1, Squad squad2) {
        for (BasicCharacter player : Squad.createTurnsOrder(squad1, squad2)) {
            if (!player.getStatus().equals("убит"))
                player.step();
        }
    }

    public static void createSquad(Squad squad1, Squad squad2, int gangSize) {

        Random rand = new Random();

        for (int i = 0; i < gangSize; i++) {
            switch (rand.nextInt(1, 5)) {
                case 1 -> new Archer(i, 0, squad1, squad2);
                case 2 -> new Farmer(i, 0, squad1, squad2);
                case 3 -> new Outlaw(i, 0, squad1, squad2);
                case 4 -> new Wizard(i, 0, squad1, squad2);
            }
        }
        for (int i = 0; i < gangSize; i++) {
            switch (rand.nextInt(1, 5)) {
                case 1 -> new Farmer(i, 9, squad2, squad1);
                case 2 -> new Outlaw(i, 9, squad2, squad1);
                case 3 -> new Lancer(i, 9, squad2, squad1);
                case 4 -> new Monk(i, 9, squad2, squad1);
            }
        }
    }
}
