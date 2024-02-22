package ch.heig.mcr.clocks;

import ch.heig.mcr.clocks.util.Observable;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class StopWatch extends Observable<Duration> {

    private static final long TIMER_INTERVAL = 1000;

    private final long id;
    private final Timer eventTimer;

    private long count;
    private boolean running;

    public StopWatch(long id) {
        this.id = id;
        this.eventTimer = new Timer("chrono-%d".formatted(id));
    }

    public void start() {
        if (isRunning()) {
            throw new IllegalStateException("Stopwatch is already running");
        }

        count = 0;
        running = true;
        eventTimer.scheduleAtFixedRate(new CountIncreaseTask(), TIMER_INTERVAL, TIMER_INTERVAL);
    }

    public void stop() {
        if (!isRunning()) {
            throw new IllegalStateException("Stopwatch is not running");
        }

        count = 0;
        running = false;
        eventTimer.cancel();
    }

    public void reset() {
        count = 0;
    }

    public boolean isRunning() {
        return running;
    }

    private class CountIncreaseTask extends TimerTask {

        @Override
        public void run() {
            count++;
        }
    }
}
