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
}
