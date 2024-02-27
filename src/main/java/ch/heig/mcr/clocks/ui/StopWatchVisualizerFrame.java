package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.watch.Watch;

import javax.swing.*;
import java.awt.*;

public class StopWatchVisualizerFrame extends JFrame {

    private final DisplayMode displayMode;
    private final StopWatch[] stopWatches;

    public StopWatchVisualizerFrame(
            JFrame parentFrame,
            DisplayMode displayMode,
            StopWatch stopWatch
    ) {
        this(parentFrame, displayMode, new StopWatch[]{stopWatch});
    }

    public StopWatchVisualizerFrame(
            JFrame parentFrame,
            DisplayMode displayMode,
            StopWatch[] stopWatches
    ) {
        super(parentFrame.getGraphicsConfiguration());
        this.displayMode = displayMode;
        this.stopWatches = stopWatches;
        addWatchPanel();
        setSize(235 * stopWatches.length, 260);
        setLocationRelativeTo(parentFrame);
        setResizable(stopWatches.length > 1);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    private void addWatchPanel() {
        setLayout(new GridLayout(1, stopWatches.length));
        for (StopWatch stopWatch : stopWatches) {
            Watch watch = displayMode.createWatch(stopWatch);
            stopWatch.addObserver(watch);
            add(watch);
        }
    }
}
