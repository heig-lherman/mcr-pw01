package ch.heig.mcr.clocks.time;

import ch.heig.mcr.clocks.util.Observable;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple stopwatch that includes an API for observing the elapsed time.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 */
public class StopWatch extends Observable {

    private static final long TIMER_INTERVAL = 1000;
    private static int nextId = 0;

    private final int id;
    private final Timer eventTimer;

    private long count = 0;
    private CountIncreaseTask currentTask;

    /**
     * Creates a new stopwatch.
     */
    public StopWatch() {
        this.id = ++nextId;
        this.eventTimer = new Timer("chrono-" + id);
    }

    /**
     * Starts the stopwatch.
     */
    public void start() {
        if (isRunning()) {
            return;
        }

        currentTask = new CountIncreaseTask();
        eventTimer.scheduleAtFixedRate(
                currentTask,
                TIMER_INTERVAL,
                TIMER_INTERVAL
        );
    }

    /**
     * Stops the stopwatch.
     */
    public void stop() {
        if (!isRunning()) {
            return;
        }

        currentTask.cancel();
        currentTask = null;
    }

    /**
     * Resets the stopwatch to zero and notifies the observers.
     */
    public void reset() {
        count = 0;
        notifyObservers();
    }

    /**
     * Returns whether the stopwatch is currently running.
     * @return true if the stopwatch is running, false otherwise
     */
    public boolean isRunning() {
        return currentTask != null;
    }

    /**
     * Returns the unique identifier of the stopwatch.
     * @return the unique identifier of the stopwatch
     */
    public long getId() {
        return id;
    }

    /**
     * Returns the duration of the stopwatch in seconds.
     * @return the duration of the stopwatch in seconds
     */
    public Duration getDuration(){
        return Duration.ofSeconds(count);
    }

    /**
     * A task that increases the count of the stopwatch and notifies the observers.
     */
    private class CountIncreaseTask extends TimerTask {

        @Override
        public void run() {
            count++;
            notifyObservers();
        }
    }
}
