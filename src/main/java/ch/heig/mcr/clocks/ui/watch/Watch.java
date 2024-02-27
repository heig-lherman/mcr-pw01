package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;

import javax.swing.*;
import java.awt.*;

abstract public class Watch extends JPanel {
    private final StopWatch stopWatch;

    Watch(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
        setLayout(new BorderLayout());
    }

    protected StopWatch getStopWatch() {
        return stopWatch;
    }
}
