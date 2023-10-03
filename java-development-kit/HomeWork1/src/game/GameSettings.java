package game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class GameSettings extends JFrame {
    // Константы для настроек окна
    static public final int WINDOW_HEIGHT = 400;
    static public final int WINDOW_WIDTH = 320;
    static public int sliderSizeValue = 3;
    static public int sliderWinValue = 3;
    static public boolean modeValue = false;

    JLabel labelMode = new JLabel("Выберите режим игры");

    JRadioButton humanVsCPUButton = new JRadioButton("Человек против Компьютера");
    JRadioButton humanVshumanButton = new JRadioButton("Человек против Человека", true);

    ButtonGroup modeButtonGroup = new ButtonGroup();

    JLabel labelFieldSize = new JLabel("Выберите размеры поля");
    JLabel labelSelectedFieldSize = new JLabel(String.format("Установленный размер поля: %d", sliderSizeValue));
    JSlider sliderSize = new JSlider(3, 10, sliderSizeValue);

    JLabel labelWinLength = new JLabel("Выберите длину для победы");
    JLabel labelSelectedWinLength = new JLabel(String.format("Установленная длина: %d", sliderWinValue));
    JSlider sliderWin = new JSlider(3, 10, sliderWinValue);

    JButton buttonStart = new JButton("Запуск игры");

    GameSettings(GameWindow gameWindow) {
        // Настройка окна настроек
        setTitle("Окно настроек");
        setLocation(gameWindow.getLocation().x, gameWindow.getLocation().y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        // Группировка радиокнопок выбора режима игры
        modeButtonGroup.add(humanVsCPUButton);
        modeButtonGroup.add(humanVshumanButton);

        // Обработчик изменения значения слайдера размера поля
        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderSizeValue = sliderSize.getValue();
                labelSelectedFieldSize.setText(String.format("Установленный размер поля: %d", sliderSizeValue));
            }
        });

        // Обработчик изменения значения слайдера длины для победы
        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderWinValue = sliderWin.getValue();
                labelSelectedWinLength.setText(String.format("Установленная длина: %d", sliderWinValue));
            }
        });

        // Обработчик нажатия кнопки "Запуск игры"
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeValue = humanVshumanButton.isSelected();
                gameWindow.startNewGame(modeValue, sliderSizeValue, sliderSizeValue, sliderWinValue);
                setVisible(false);
            }
        });

        // Добавление элементов интерфейса на панель
        mainPanel.add(labelMode);
        mainPanel.add(humanVsCPUButton);
        mainPanel.add(humanVshumanButton);
        mainPanel.add(labelFieldSize);
        mainPanel.add(labelSelectedFieldSize);
        mainPanel.add(sliderSize);
        mainPanel.add(labelWinLength);
        mainPanel.add(labelSelectedWinLength);
        mainPanel.add(sliderWin);
        mainPanel.add(buttonStart);

        add(mainPanel);
    }
}
