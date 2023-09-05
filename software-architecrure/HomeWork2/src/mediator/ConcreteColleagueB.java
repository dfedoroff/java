package mediator;

public class ConcreteColleagueB extends Colleague {

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        System.out.println("Коллега B: Отправка сообщения: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void notify(String message) {
        System.out.println("Коллега B: Получено сообщение: " + message);
    }
}
