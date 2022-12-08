import Classes.*;
import Classes.AbstractTypes.BasicCharacter;
import Classes.AbstractTypes.Squad;
import GameBoard.*;

import java.util.Random;
import java.util.Scanner;

public class Controller {

    public void start() {

        Squad darkSide = new Squad(AnsiColors.ANSI_GREEN);
        Squad brightSide = new Squad(AnsiColors.ANSI_YELLOW);
        createSquad(darkSide, brightSide);

        Board board = new Board();
        View view = new View();
        board.placeSquad(darkSide);
        board.placeSquad(brightSide);

        view.view();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Нажмите ENTER для продолжения");
            System.out.println("Нажмите Q и ENTER чтобы выйти");
            String tmp = scanner.nextLine();

            if (tmp.equals("Q") || tmp.equals("q"))
                System.exit(0);

            makeStep(darkSide, brightSide);
            view.view();
        }
    }

    public static void makeStep(Squad squad1, Squad squad2) {

        for (BasicCharacter character : Squad.createTurnsOrder(squad1, squad2)) {
            if (!character.getStatus().equals("dead"))
                character.step();
        }
    }

    public static void createSquad(Squad squad1, Squad squad2) {

        int gangSize = Constants.GANG_SIZE;
        Random rand = new Random();

        for (int i = 0; i < gangSize - 1; i++) {
            switch (rand.nextInt(1, 4)) {
                case 1 -> new Farmer(i, 0, squad1, squad2);
                case 2 -> new Outlaw(i, 0, squad1, squad2);
                case 3 -> new Sniper(i, 0, squad1, squad2);
            }
        }

        new Wizard(9, 0, squad1, squad2);

        for (int i = 0; i < gangSize - 1; i++) {
            switch (rand.nextInt(1, 4)) {
                case 1 -> new Farmer(i, 9, squad2, squad1);
                case 2 -> new Lancer(i, 9, squad2, squad1);
                case 3 -> new Archer(i, 9, squad2, squad1);
            }
        }
        new Monk(9, 9, squad2, squad1);
    }
}
