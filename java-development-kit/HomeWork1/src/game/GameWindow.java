package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    // Константы для настройки окна
    static public final int WINDOW_HEIGHT = 640;
    static public final int WINDOW_WIDTH = 720;
    static public final int WINDOW_POS_X = 300;
    static public final int WINDOW_POS_Y = 100;
    static public final String WINDOW_NAME = "Игра в крестики-нолики";
    GameSettings gameSettings;
    GameMap gameMap;

    GameWindow() {
        // Настройка главного окна приложения
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(WINDOW_NAME);
        setResizable(false);

        // Создание элементов основной части
        gameSettings = new GameSettings(this);
        gameMap = new GameMap(gameSettings.sliderSizeValue, gameSettings.sliderSizeValue);

        // Создание элементов нижней части
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Exit");
        JPanel controlPanel = new JPanel(new GridLayout(1, 2));

        // Обработчики кнопок
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettings.setVisible(true);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Отрисовка
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        add(controlPanel, BorderLayout.PAGE_END);
        add(gameMap);
        gameMap.setVisible(false);
        setVisible(true);
    }

    // Метод для начала новой игры с заданными параметрами
    void startNewGame(boolean mode, int size_x, int size_y, int win_len) {
        gameMap.setVisible(true);
        gameMap.startNewGame(mode, size_x, size_y, win_len);
    }
}
