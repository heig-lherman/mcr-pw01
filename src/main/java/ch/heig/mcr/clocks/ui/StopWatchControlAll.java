package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.constant.StopWatchString;
import java.awt.*;
import javax.swing.*;
public class StopWatchControlAll extends JPanel {
    private final StopWatch[] stopWatches;

    public StopWatchControlAll(LayoutManager layout, StopWatch[] stopWatches) {
        super(layout);
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
                displayMode,
                stopWatches
        );

        dialog.pack();
        dialog.setVisible(true);
    }
}
