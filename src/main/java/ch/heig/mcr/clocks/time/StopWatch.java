package ch.heig.mcr.clocks.time;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple stopwatch that includes an API for observing the elapsed time.
 */
public class StopWatch {

    private static final long TIMER_INTERVAL = 1000;
    private static int nextId = 0;

    private final int id;
    private final Timer eventTimer;

    private long count;
    private CountIncreaseTask currentTask;

    private final List<Observer> observers = new LinkedList<>();

    public StopWatch() {
        this.id = ++nextId;
        this.eventTimer = new Timer("chrono-" + id);
    }

    public void start() {
        if (isRunning()) {
            throw new IllegalStateException("Stopwatch is already running");
        }

        count = 0;
        currentTask = new CountIncreaseTask();
        eventTimer.scheduleAtFixedRate(
                currentTask,
                TIMER_INTERVAL,
                TIMER_INTERVAL
        );
    }

    public void stop() {
        if (!isRunning()) {
            throw new IllegalStateException("Stopwatch is not running");
        }

        count = 0;
        currentTask.cancel();
        currentTask = null;
    }

    public void reset() {
        // TODO check if need to notify here
        count = 0;
    }

    public boolean isRunning() {
        return currentTask != null;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public long getId() {
        return id;
    }

    private void notifyObservers() {
        observers.forEach(observer -> observer.update(
                id, getDuration()
        ));
    }

    public Duration getDuration(){
        return Duration.ofSeconds(count);
    }

    @FunctionalInterface
    public interface Observer {

        void update(long id, Duration value);
    }

    private class CountIncreaseTask extends TimerTask {

        @Override
        public void run() {
            count++;
            notifyObservers();
        }
    }
}
