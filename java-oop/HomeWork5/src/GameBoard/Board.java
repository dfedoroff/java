package GameBoard;

import Classes.AbstractTypes.BasicCharacter;
import Classes.AbstractTypes.Squad;

public class Board {

    static BasicCharacter[][] board = new BasicCharacter[10][10];

    public void placeSquad(Squad squad) {

        for (BasicCharacter character : squad) {
            board[character.getPosition().x][character.getPosition().y] = character;
        }
    }

    public static boolean isFree(int x, int y) {

        return board[x][y] == null || board[x][y].getCharacterSymbol() == '_' || board[x][y].getStatus().equals("убит");
    }

    public static void move(BasicCharacter character, String direction) {

        int x = character.getPosition().x;
        int y = character.getPosition().y;
        board[x][y] = null;

        switch (direction) {
            case "вправо" -> character.setCoordinates(x, ++y);
            case "влево" -> character.setCoordinates(x, --y);
            case "вниз" -> character.setCoordinates(++x, y);
            case "вверх" -> character.setCoordinates(--x, y);
        }
        board[x][y] = character;
    }

    public void removeTheDead() {
        for (BasicCharacter[] line : board) {
            for (BasicCharacter character : line)
                if (character != null && character.getStatus().equals("убит"))
                    board[character.getPosition().x][character.getPosition().y] = null;
        }
    }
}
