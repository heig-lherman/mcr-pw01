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

    private long count = 10800;
    private CountIncreaseTask currentTask;

    public StopWatch() {
        this.id = ++nextId;
        this.eventTimer = new Timer("chrono-" + id);
    }

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

    public void stop() {
        if (!isRunning()) {
            return;
        }

        currentTask.cancel();
        currentTask = null;
    }

    public void reset() {
        count = 0;
        notifyObservers();
    }

    public boolean isRunning() {
        return currentTask != null;
    }

    public long getId() {
        return id;
    }

    public Duration getDuration(){
        return Duration.ofSeconds(count);
    }

    private class CountIncreaseTask extends TimerTask {

        @Override
        public void run() {
            count++;
            notifyObservers();
        }
    }
}
