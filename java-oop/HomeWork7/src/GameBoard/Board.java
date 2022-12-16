package GameBoard;

import Classes.AbstractTypes.BasicCharacter;
import Classes.AbstractTypes.Coordinates;
import Classes.AbstractTypes.Squad;

public class Board {
    public static BasicCharacter[][] board = new BasicCharacter[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

    public void placeSquad(Squad squad) {

        for (BasicCharacter character : squad) {
            board[character.getPosition().getX()][character.getPosition().getY()] = character;
        }
    }

    public static boolean isFree(int x, int y) {
        return board[x][y] == null || board[x][y].getCharacterSymbol() == '_' || board[x][y].getStatus().equals("убит");
    }

    public static void moveCharacter(BasicCharacter character, Coordinates newPosition) {

        int oldX = character.getPosition().getX();
        int oldY = character.getPosition().getY();
        board[oldX][oldY] = null;
        character.setPosition(newPosition);
        board[newPosition.getX()][newPosition.getY()] = character;
    }

    public static void moveCharacter(BasicCharacter character, String direction) {

        int x = character.getPosition().getX();
        int y = character.getPosition().getY();
        board[x][y] = null;

        switch (direction){
            case "вправо" -> character.setCoordinates(x, ++y);
            case "влево" -> character.setCoordinates(x, --y);
            case "вниз" -> character.setCoordinates(++x, y);
            case "вверх" -> character.setCoordinates(--x, y);
        }
        board[x][y] = character;
    }
}
