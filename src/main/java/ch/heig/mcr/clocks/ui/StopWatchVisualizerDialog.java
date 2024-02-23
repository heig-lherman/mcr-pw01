package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.time.StopWatch;
import javax.swing.*;

public class StopWatchVisualizerDialog extends JDialog {

    private final DisplayMode displayMode;
    private final StopWatch[] stopWatches;

    public StopWatchVisualizerDialog(
            JFrame parentFrame,
            DisplayMode displayMode,
            StopWatch stopWatch
    ) {
        this(parentFrame, displayMode, new StopWatch[]{stopWatch});
    }

    public StopWatchVisualizerDialog(
            JFrame parentFrame,
            DisplayMode displayMode,
            StopWatch[] stopWatches
    ) {
        super(parentFrame);

        this.displayMode = displayMode;
        this.stopWatches = stopWatches;

        setSize(200, 200);
        setLocationRelativeTo(parentFrame);
        setResizable(stopWatches.length > 1);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}
