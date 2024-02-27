package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.constants.StopWatchString;
import ch.heig.mcr.clocks.time.StopWatch;
import java.awt.*;
import javax.swing.*;

public class StopWatchControlRow extends JPanel {

    private final StopWatch stopWatch;

    public StopWatchControlRow(StopWatch stopWatch) {
        super(new FlowLayout(FlowLayout.LEFT));
        this.stopWatch = stopWatch;

        JLabel idLabel = new JLabel("Chrono #" + stopWatch.getId());

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
            JButton button = new JButton(displayMode.getName());
            button.addActionListener(e -> showDialog(displayMode));
            add(button);
        }
    }
    private void showDialog(DisplayMode displayMode) {
        StopWatchVisualizerFrame dialog = new StopWatchVisualizerFrame(
                (JFrame) SwingUtilities.getWindowAncestor(this),
                displayMode,
                stopWatch
        );
        dialog.setVisible(true);
    }
}
