import Classes.BasicCharacter;
import Classes.Coordinates;

import java.util.ArrayList;
import java.util.Collections;

public class ConsoleView {

    public static int step = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static final int findCharacterLength = findCharacterLength(Main.darkSide, Main.brightSide) + 1;
    private static final int findSquadLength = findSquadLength(Main.darkSide, Main.brightSide) + 1;
    private static final int findIdLength = findIdLength(Main.darkSide, Main.brightSide) + 1;
    private static final int findHealthLength = findHealthLength(Main.darkSide, Main.brightSide) + 1;

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    public static void view() {

        String inf = "";

        if (step++ == 0) {
            System.out.println(AnsiColors.ANSI_RED + "Первый ход" + AnsiColors.ANSI_RESET);
        } else {
            System.out.println(AnsiColors.ANSI_RED + "Ход: " + step + AnsiColors.ANSI_RESET);
        }
        System.out.print(ConsoleView.top10);
        System.out.println("Персонаж" + String.join("",Collections.nCopies(findCharacterLength - "Персонаж".length(), " "))
                + "Идентификатор" + String.join("",Collections.nCopies(findIdLength - "Идентификатор".length(), " "))
                + "Уровень здоровья" + String.join("",Collections.nCopies(findHealthLength - "Уровень здоровья".length(), " "))
                + "Отряд" + String.join("", Collections.nCopies(findSquadLength - "Отряд".length(), " ")));

        for (int i = 1; i <= Main.SQUAD_SIZE - 1; i++) {

            inf = "";

            for (int j = 1; j <= Main.SQUAD_SIZE; j++) {
                System.out.print(getChar(new Coordinates(i, j)));
                inf += characterDetails(new Coordinates(i, j)) + ' ';
            }
            System.out.print("|");
            System.out.println(inf);
            System.out.println(ConsoleView.mid10);
        }

        for (int j = 1; j <= Main.SQUAD_SIZE; j++) {
            System.out.print(getChar(new Coordinates(10, j)));
        }
        System.out.print("|");
        System.out.println(inf);
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(Coordinates position) {

        String str = "| ";

        for (int i = 0; i < Main.SQUAD_SIZE; i++) {
            if (Main.darkSide.get(i).getPosition().isEqual(position)) {
                str = "|" + AnsiColors.ANSI_GREEN + Main.darkSide.get(i).getCharacter().charAt(0) + AnsiColors.ANSI_RESET;
            }
            if (Main.brightSide.get(i).getPosition().isEqual(position)) {
                str = "|" + AnsiColors.ANSI_BLUE + Main.brightSide.get(i).getCharacter().charAt(0) + AnsiColors.ANSI_RESET;
            }
        }
        return str;
    }

    private static String characterDetails(Coordinates position) {

        String str = "";

        for (int i = 0; i < Main.SQUAD_SIZE; i++) {
            if (Main.darkSide.get(i).getPosition().isEqual(position))
                str = Main.darkSide.get(i).getCharacter() + String.join("",Collections.nCopies(findCharacterLength - Main.darkSide.get(i).getCharacter().length(), " "))
                        + Main.darkSide.get(i).getId() + String.join("",Collections.nCopies(findIdLength - String.valueOf(Main.darkSide.get(i).getId()).length(), " "))
                        + Main.darkSide.get(i).getHealth() + String.join("",Collections.nCopies(findHealthLength - String.valueOf(Main.darkSide.get(i).getHealth()).length(), " "))
                        + Main.darkSide.get(i).getSquad() + String.join("", Collections.nCopies(findSquadLength - Main.darkSide.get(i).getSquad().length(), " "));

            if (Main.brightSide.get(i).getPosition().isEqual(position))
                str = Main.brightSide.get(i).getCharacter() + String.join("",Collections.nCopies(findCharacterLength - Main.brightSide.get(i).getCharacter().length(), " "))
                        + Main.brightSide.get(i).getId() + String.join("",Collections.nCopies(findIdLength - String.valueOf(Main.brightSide.get(i).getId()).length(), " "))
                        + Main.brightSide.get(i).getHealth() + String.join("",Collections.nCopies(findHealthLength - String.valueOf(Main.brightSide.get(i).getHealth()).length(), " "))
                        + Main.brightSide.get(i).getSquad() + String.join("", Collections.nCopies(findSquadLength - Main.brightSide.get(i).getSquad().length(), " "));
        }
        return str;
    }

    public static int findCharacterLength(ArrayList<BasicCharacter> squad1, ArrayList<BasicCharacter> squad2) {

        int len = squad1.get(0).getCharacter().length();

        for (int i = 1; i < squad1.size(); i++) {
            if (squad1.get(i).getCharacter().length() > len) {
                len = squad1.get(i).getCharacter().length();
            }
        }

        for (int i = 1; i < squad2.size(); i++) {
            if (squad2.get(i).getCharacter().length() > len) {
                len = squad2.get(i).getCharacter().length();
            }
        }
        return len;
    }

    public static int findSquadLength(ArrayList<BasicCharacter> squad1, ArrayList<BasicCharacter> squad2) {

        int len = squad1.get(0).getSquad().length();

        if (squad2.get(0).getSquad().length() > findCharacterLength) {
            len = squad2.get(0).getSquad().length();
        }
        return len;
    }

    public static int findIdLength(ArrayList<BasicCharacter> squad1, ArrayList<BasicCharacter> squad2) {

        String field = "Идентификатор";
        int len = field.length();

        for (int i = 0; i < squad1.size(); i++) {
            if (String.valueOf(squad1.get(i).getId()).length() > len) {
                len = String.valueOf(squad1.get(i).getId()).length();
            }
        }

        for (int i = 0; i < squad2.size(); i++) {
            if (String.valueOf(squad2.get(i).getId()).length() > len) {
                len = String.valueOf(squad2.get(i).getId()).length();
            }
        }
        return len;
    }

    public static int findHealthLength(ArrayList<BasicCharacter> squad1, ArrayList<BasicCharacter> squad2) {

        String field = "Уровень здоровья";
        int len = field.length();

        for (int i = 0; i < squad1.size(); i++) {
            if (String.valueOf(squad1.get(i).getHealth()).length() > len) {
                len = String.valueOf(squad1.get(i).getHealth()).length();
            }
        }

        for (int i = 0; i < squad2.size(); i++) {
            if (String.valueOf(squad2.get(i).getHealth()).length() > len) {
                len = String.valueOf(squad2.get(i).getHealth()).length();
            }
        }
        return len;
    }
}
