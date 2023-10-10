package application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import classes.Animal;
import classes.MouseAdapter;
import interfaces.Clickable;

public class Application extends JFrame {
    public Application() {
        JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    throw new Exception("Exception occurred on button click");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(button);
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Application();
        
        Animal animal = new Animal();
        animal.sleep();
        
        MouseAdapter mouseAdapter = new MouseAdapter();
        mouseAdapter.event1();
        
        Clickable clickable = new Clickable() {
            @Override
            public void click() {
                System.out.println("Element clicked");
            }
        };
        clickable.click();
    }
}
