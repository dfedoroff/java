package classes;

import interfaces.Listener;

public abstract class Adapter implements Listener {
    @Override
    public void event1() {}

    @Override
    public void event2() {}

    @Override
    public void event3() {}
}
