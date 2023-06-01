package player;

import model.GameField;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void makeMove(GameField field) {
        int x, y;
        do {
            System.out.print("Введите координаты вашего поворота x и y, разделенные пробелом: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!field.isCellValid(x, y) || !field.isCellEmpty(x, y));
        field.setCell(x, y, 'X');
    }
}

