// Класс, реализующий действие "Есть"
package action;

public class Eat implements Action {
    private int id;

    public Eat(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        System.out.println("Философ " + id + " обедает");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
