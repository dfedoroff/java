package GameBoard;

import java.util.Collections;

public class Constants {

    public static final int SQUAD_SIZE = 10;
    public static final int BOARD_SIZE = 10;
    static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(BOARD_SIZE - 1, formatDiv("---b"))) + formatDiv("---c");
    static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(BOARD_SIZE - 1, formatDiv("---e"))) + formatDiv("---f");
    static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(BOARD_SIZE - 1, formatDiv("---h"))) + formatDiv("---i");

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

    public static class AnsiColors {

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    }
}
