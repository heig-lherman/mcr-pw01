package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

abstract public class Watch extends JPanel implements StopWatch.Observer {
    private final StopWatch stopWatch;
    private Duration value;

    Watch(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
        this.value = stopWatch.getDuration();
        setLayout(new BorderLayout());
    }

    protected StopWatch getStopWatch() {
        return stopWatch;
    }

    @Override
    public void update(long id, Duration value){
        this.value = value;
        repaint();
    }

    protected int getHours() {
        return (int) value.toHours();
    }

    protected int getMinutes() {
        return (int) (value.toMinutes() % 60);
    }

    protected int getSeconds() {
        return (int) (value.getSeconds() % 60);
    }
}
