// Класс, реализующий интерфейс Philosopher
package philosopher;
import action.*;
import java.util.concurrent.Semaphore;

public class ConcretePhilosopher implements Philosopher, Runnable {
    private int id;
    private Semaphore table;
    private Action eatAction;
    private Action thinkAction;

    // Конструктор принимает идентификатор философа и семафор для синхронизации
    public ConcretePhilosopher(int id, Semaphore table) {
        this.id = id;
        this.table = table;
        this.eatAction = new Eat(this.id);
        this.thinkAction = new Think(this.id);
    }

    // Выполнение последовательности действий философа
    @Override
    public void performAction() {
        for (int i = 0; i < 3; i++) {
            thinkAction.execute();

            try {
                table.acquire();
                eatAction.execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                table.release();
            }
        }
    }

    // Запуск потока
    @Override
    public void run() {
        performAction();
    }
}
