package ch.heig.mcr.clocks.util;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple utility class for implementing the observer pattern
 * on a given object.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 */
public abstract class Observable {

    private final List<Observer> observers = new LinkedList<>();

    /**
     * Adds an observer to the list of observers.
     * @param observer the observer to add
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     * @param observer the observer to remove
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers that the state of the object has changed.
     */
    protected void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * Observers can implement this interface to be notified of changes using
     * either a lambda or a concrete implementation.
     */
    @FunctionalInterface
    public interface Observer {

        void update();
    }
}
