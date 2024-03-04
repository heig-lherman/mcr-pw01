package ch.heig.mcr.clocks.util;

import java.util.LinkedList;
import java.util.List;

public abstract class Observable {

    private final List<Observer> observers = new LinkedList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @FunctionalInterface
    public interface Observer {

        void update();
    }
}
