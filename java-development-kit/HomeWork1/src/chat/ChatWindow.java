package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 640;
    private static final int WINDOW_WIDTH = 720;
    private static final int WINDOW_POS_X = 300;
    private static final int WINDOW_POS_Y = 100;
    private static final String WINDOW_NAME = "Чат с сервером";
    private static final String LOG_FILE = "chat_log.txt";

    private JTextArea textOutput = new JTextArea("");
    private JLabel label = new JLabel("Введите сообщение серверу: ");
    private JTextField textInput = new JTextField();
    private JButton buttonConnect = new JButton("Отправить");
    private JPanel grid = new JPanel(new GridLayout(4, 1));

    ChatWindow(String login) {
        setTitle(WINDOW_NAME);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);

        textOutput.setEditable(false);
        textOutput.setBackground(Color.GRAY);

        loadChatHistory();

        grid.add(textOutput);
        grid.add(label);
        grid.add(textInput);
        grid.add(buttonConnect);

        buttonConnect.addActionListener(e -> sendMessage(login));

        textInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage(login);
                }
            }
        });

        add(grid);
        setVisible(true);
    }

    private void sendMessage(String login) {
        String message = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss")) + " " + login + " : " + textInput.getText() + "\n";
        textOutput.append(message);
        saveMessageToFile(message);
        textInput.setText("");
    }

    private void saveMessageToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadChatHistory() {
        File file = new File(LOG_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    textOutput.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}