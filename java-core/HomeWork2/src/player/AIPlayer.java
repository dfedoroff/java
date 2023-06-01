package player;

import model.GameField;
import java.util.Random;

public class AIPlayer implements Player {
    private Random random = new Random();

    @Override
    public void makeMove(GameField field) {
        // Try to win
        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getColumns(); j++) {
                if (field.isCellEmpty(i, j)) {
                    field.setCell(i, j, 'O');
                    if (field.checkWin('O')) return;
                    field.setCell(i, j, ' ');
                }
            }
        }
        for (int i = 0; i < field.getRows(); i++) {
            for (int j = 0; j < field.getColumns(); j++) {
                if (field.isCellEmpty(i, j)) {
                    field.setCell(i, j, 'X');
                    if (field.checkWin('X')) {
                        field.setCell(i, j, 'O');
                        return;
                    }
                    field.setCell(i, j, ' ');
                }
            }
        }
        int x, y;
        do {
            x = random.nextInt(field.getRows());
            y = random.nextInt(field.getColumns());
        } while (!field.isCellEmpty(x, y));
        field.setCell(x, y, 'O');
    }
}
