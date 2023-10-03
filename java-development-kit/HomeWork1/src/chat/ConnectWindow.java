package chat;

import javax.swing.*;
import java.awt.GridLayout;

public class ConnectWindow extends JFrame {
    static private final int WINDOW_HEIGHT = 640;
    static private final int WINDOW_WIDTH = 720;
    static private final int WINDOW_POS_X = 300;
    static private final int WINDOW_POS_Y = 100;
    static private final String WINDOW_NAME = "Подключение к серверу";

    JTextField loginField = new JTextField("Введите ваш логин: ");
    JTextField passwordField = new JPasswordField("Введите ваш пароль: ");
    JTextField serverField = new JTextField("Введите адрес сервера и порт для подключения: ");
    JButton buttonConnect = new JButton("Подключиться");

    JPanel grid = new JPanel(new GridLayout(4,1));

    ConnectWindow(){
        setTitle(WINDOW_NAME);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        grid.add(loginField);
        grid.add(passwordField);
        grid.add(serverField);
        grid.add(buttonConnect);

        add(grid);

        buttonConnect.addActionListener(e -> {
            String login = loginField.getText().trim();
            new ChatWindow(login);
        });

        setVisible(true);
    }
}