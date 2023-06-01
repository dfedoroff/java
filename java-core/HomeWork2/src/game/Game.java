package game;

import model.GameField;
import player.Player;
import player.HumanPlayer;
import player.AIPlayer;

import java.util.Scanner;

public class Game {
    private GameField field;
    private Player humanPlayer;
    private Player aiPlayer;
    private int currentTurn = 1;

    public Game() {
        this.field = new GameField();
        this.humanPlayer = new HumanPlayer();
        this.aiPlayer = new AIPlayer();
    }

    public void start() {
        while (true) {
            playRound();
            System.out.print("Сыграть еще раз? Да / Нет: ");
            if (!"Да".equalsIgnoreCase(new Scanner(System.in).next())) {
                break;
            }
        }
    }

    private void playRound() {
        field.initField();
        field.printField();
        while (true) {
            humanPlayer.makeMove(field);
            field.printField();
            if (checkEndGame('X')) break;

            aiPlayer.makeMove(field);
            field.printField();
            if (checkEndGame('O')) break;
        }
    }

    public boolean checkEndGame(char dot) {
        if (field.checkWin(dot)) {
            if (dot == 'X') {
                System.out.println("Человек победил!");
            } else {
                System.out.println("ИИ побеждает!");
            }
            return true;
        }
        if (currentTurn > field.getRows() * field.getColumns()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }
}

