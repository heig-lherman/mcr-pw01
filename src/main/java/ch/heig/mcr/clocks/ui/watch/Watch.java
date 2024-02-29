package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;

abstract public class Watch extends JPanel implements StopWatch.Observer {
    private final long id;
    private Duration value;

    Watch(long id, Duration value) {
        this.id = id;
        this.value = value;
        setLayout(new BorderLayout());
    }

    protected long getId() {
        return id;
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
