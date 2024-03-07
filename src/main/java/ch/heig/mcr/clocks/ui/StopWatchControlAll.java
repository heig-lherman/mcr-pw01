package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.constant.StopWatchString;
import java.awt.*;
import javax.swing.*;

/**
 * The control row for displaying all stopwatches.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 */
public class StopWatchControlAll extends JPanel {

    private final StopWatch[] stopWatches;

    /**
     * Creates a new control row for all the given stopwatches.
     * @param stopWatches the stopwatches to control
     */
    public StopWatchControlAll(StopWatch[] stopWatches) {
        super(new FlowLayout(FlowLayout.RIGHT));
        this.stopWatches = stopWatches;

        add(new JLabel(StopWatchString.ALL_STOPWATCHES));
        for (DisplayMode displayMode : DisplayMode.values()) {
            JButton button = new JButton(displayMode.getDescription());
            button.addActionListener(e -> showDialog(displayMode));
            add(button);
        }
    }

    private void showDialog(DisplayMode displayMode) {
        StopWatchVisualizerFrame dialog = new StopWatchVisualizerFrame(
                displayMode,
                stopWatches
        );

        dialog.pack();
        dialog.setVisible(true);
    }
}
