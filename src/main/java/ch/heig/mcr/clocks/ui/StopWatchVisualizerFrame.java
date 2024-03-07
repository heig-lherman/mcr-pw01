package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.watch.Watch;
import java.awt.*;
import javax.swing.*;

/**
 * A visualizer for one or more stopwatches,
 * initialized with a specific display mode.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 */
public class StopWatchVisualizerFrame extends JFrame {

    /**
     * Initializes a new visualizer frame for a single dial.
     * The window will not be resizable.
     *
     * @param displayMode the display mode to use
     * @param stopWatch the stopwatch to visualize
     */
    public StopWatchVisualizerFrame(
            DisplayMode displayMode,
            StopWatch stopWatch
    ) {
        this(displayMode, new StopWatch[]{stopWatch});
    }

    /**
     * Initializes a new visualizer frame for multiple dials.
     * @param displayMode the display mode to use
     * @param stopWatches the stopwatches to visualize
     */
    public StopWatchVisualizerFrame(
            DisplayMode displayMode,
            StopWatch[] stopWatches
    ) {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(stopWatches.length > 1);
        setBackground(Color.LIGHT_GRAY);

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);

        for (StopWatch stopWatch : stopWatches) {
            Watch watch = displayMode.createWatch(stopWatch);
            add(watch);
        }
    }

    /**
     * When the window is disposed, we must unsubscribe
     * the inner dials to the parent stopwatch.
     */
    @Override
    public void dispose() {
        synchronized (getTreeLock()) {
            for (Component component : getComponents()) {
                ((Watch) component).dispose();
            }
        }

        super.dispose();
    }
}
