package classes;

import interfaces.Runnable;
import interfaces.Eater;

public class Animal implements Runnable, Eater {
    @Override
    public void run() {
        System.out.println("Animal is running");
    }

    @Override
    public void eat() {
        System.out.println("Animal is eating");
    }
}
