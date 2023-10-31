// Класс, реализующий действие "Думать"
package action;

public class Think implements Action {
    private int id;

    public Think(int id) {
        this.id = id;
    }

    @Override
    public void execute() {
        System.out.println("Философ " + id + " размышляет");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
