package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.constants.StopWatchString;
import ch.heig.mcr.clocks.time.StopWatch;

import javax.swing.*;
public class StopWatchControlAll extends JPanel {
    private final StopWatch[] stopWatches;

    public StopWatchControlAll(StopWatch[] stopWatches) {
        this.stopWatches = stopWatches;
        add(new JLabel(StopWatchString.ALL_STOPWATCHES));
        for (DisplayMode displayMode : DisplayMode.values()) {
            JButton button = new JButton(displayMode.getName());
            button.addActionListener(e -> showDialog(displayMode));
            add(button);
        }
    }

    private void showDialog(DisplayMode displayMode) {
        StopWatchVisualizerFrame dialog = new StopWatchVisualizerFrame(
                (JFrame) SwingUtilities.getWindowAncestor(this),
                displayMode,
                stopWatches
        );
        dialog.setVisible(true);
    }
}
