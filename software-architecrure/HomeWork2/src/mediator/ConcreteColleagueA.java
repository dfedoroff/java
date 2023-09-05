package mediator;

public class ConcreteColleagueA extends Colleague {

    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        System.out.println("Коллега A: Отправка сообщения: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void notify(String message) {
        System.out.println("Коллега A: Получено сообщение: " + message);
    }
}
