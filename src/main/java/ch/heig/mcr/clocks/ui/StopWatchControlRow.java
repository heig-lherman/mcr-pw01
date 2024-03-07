package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.constant.StopWatchString;
import java.awt.*;
import javax.swing.*;

/**
 * A control row for a given stopwatch.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 */
public class StopWatchControlRow extends JPanel {

    private final StopWatch stopWatch;

    /**
     * Creates a new control row for the given stopwatch.
     * @param stopWatch the stopwatch to control
     */
    public StopWatchControlRow(StopWatch stopWatch) {
        super(new FlowLayout(FlowLayout.LEFT));
        this.stopWatch = stopWatch;

        JLabel idLabel = new JLabel(StopWatchString.stopWatchWithId(stopWatch.getId()));

        JButton startButton = new JButton(StopWatchString.START);
        JButton stopButton = new JButton(StopWatchString.STOP);
        JButton resetButton = new JButton(StopWatchString.RESET);

        startButton.addActionListener(e -> stopWatch.start());
        stopButton.addActionListener(e -> stopWatch.stop());
        resetButton.addActionListener(e -> stopWatch.reset());

        add(idLabel);
        add(startButton);
        add(stopButton);
        add(resetButton);

        for (DisplayMode displayMode : DisplayMode.values()) {
            JButton button = new JButton(displayMode.getDescription());
            button.addActionListener(e -> showDialog(displayMode));
            add(button);
        }
    }

    private void showDialog(DisplayMode displayMode) {
        StopWatchVisualizerFrame dialog = new StopWatchVisualizerFrame(
                displayMode,
                stopWatch
        );

        dialog.pack();
        dialog.setVisible(true);
    }
}
