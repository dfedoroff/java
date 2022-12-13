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

            while (!Logger.logQueue.isEmpty())
                System.out.println(Logger.logQueue.poll());
        }
    }

    public static void makeStep(Squad squad1, Squad squad2) {

        for (BasicCharacter character : Squad.createTurnsOrder(squad1, squad2)) {
            if (!character.getStatus().equals("убит"))
                character.step();
        }
    }

    public static void createSquad(Squad squad1, Squad squad2) {

        int squadSize = Constants.SQUAD_SIZE;
        Random rand = new Random();

        for (int i = 0; i < squadSize - 1; i++) {
            switch (rand.nextInt(1, 4)) {
                case 1 -> new Farmer(100, i, 0, squad1, squad2);
                case 2 -> new Outlaw(20, i, 0, squad1, squad2);
                case 3 -> new Sniper(20, i, 0, squad1, squad2);
            }
        }

        new Wizard(1, 9, 0, squad1, squad2);

        for (int i = 0; i < squadSize - 1; i++) {
            switch (rand.nextInt(1, 4)) {
                case 1 -> new Farmer(100, i, 9, squad2, squad1);
                case 2 -> new Lancer(20, i, 9, squad2, squad1);
                case 3 -> new Archer(20, i, 9, squad2, squad1);
            }
        }
        new Monk(1, 9, 9, squad2, squad1);
    }
}
