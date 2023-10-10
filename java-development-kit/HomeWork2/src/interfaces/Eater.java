package interfaces;

public interface Eater {
    void eat();
    
    default void sleep() {
        System.out.println("Animal is sleeping");
    }
}

