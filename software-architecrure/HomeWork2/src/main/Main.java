package main;

import mediator.*;

public class Main {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);

        mediator.addColleague(colleagueA);
        mediator.addColleague(colleagueB);

        colleagueA.send("Привет от Коллеги A!");
        colleagueB.send("Привет от Коллеги B!");
    }
}
