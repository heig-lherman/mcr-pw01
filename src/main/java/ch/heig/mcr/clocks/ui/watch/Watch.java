package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.util.Observable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * A base dial class for observing events
 * on a stopwatch and displaying them.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 */
public abstract class Watch extends JPanel implements Observable.Observer {

    protected static final int WIDTH = 200;
    protected static final int HEIGHT = 200;

    private final StopWatch stopWatch;

    /**
     * Creates a new watch for the given stopwatch.
     * @param stopWatch the stopwatch to observe
     */
    protected Watch(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
        stopWatch.addObserver(this);

        setSize(WIDTH, HEIGHT);
        setPreferredSize(getSize());

        super.addMouseListener(new MouseActionListener());
    }

    protected final long getStopWatchId() {
        return stopWatch.getId();
    }

    /**
     * Calls for a repaint of the watch, which should in most cases
     * update the display of the time.
     *
     * Cases when this behavior is not desired can override the
     * default behavior with a custom implementation.
     */
    @Override
    public void update() {
        repaint();
    }

    /**
     * Disposes of the watch and unsubscribes itself from the stopwatch.
     */
    public void dispose() {
        stopWatch.removeObserver(this);
    }

    protected int getHours() {
        return (int) stopWatch.getDuration().toHours();
    }

    protected int getMinutes() {
        return stopWatch.getDuration().toMinutesPart();
    }

    protected int getSeconds() {
        return stopWatch.getDuration().toSecondsPart();
    }

    /**
     * A listener for mouse events on the dial so that the stopwatch
     * can be stopped or restarted on demand.
     */
    private final class MouseActionListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (stopWatch.isRunning()) {
                stopWatch.stop();
            } else {
                stopWatch.start();
            }
        }
    }
}
