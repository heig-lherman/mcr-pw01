package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.Disposable;
import ch.heig.mcr.clocks.util.Observable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public abstract class Watch extends JPanel implements Observable.Observer, Disposable {

    protected static final int WIDTH = 200;
    protected static final int HEIGHT = 200;

    private final StopWatch stopWatch;

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

    @Override
    public void update() {
        repaint();
    }

    @Override
    public final void dispose() {
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
