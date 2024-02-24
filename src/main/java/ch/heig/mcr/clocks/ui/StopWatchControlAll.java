package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.time.StopWatch;

import javax.swing.*;
import java.awt.*;

public class StopWatchControlAll extends JPanel {
    private final StopWatch[] stopWatches;

    public StopWatchControlAll(StopWatch[] stopWatches) {
        this.stopWatches = stopWatches;
        JButton romanGlobalButton = new JButton("Cadre romain");
        JButton arabicGlobalButton = new JButton("Cadre arabe");
        JButton digitalGlobalButton = new JButton("Numérique");
        romanGlobalButton.addActionListener(e -> showDialog(DisplayMode.ROMAN));
        arabicGlobalButton.addActionListener(e -> showDialog(DisplayMode.ARABIC));
        digitalGlobalButton.addActionListener(e -> showDialog(DisplayMode.DIGITAL));
        add(new JLabel("Tous les chronos"));
        add(romanGlobalButton);
        add(arabicGlobalButton);
        add(digitalGlobalButton);
    }

    private void showDialog(DisplayMode displayMode) {
        StopWatchVisualizerDialog dialog = new StopWatchVisualizerDialog(
                (JFrame) SwingUtilities.getWindowAncestor(this),
                displayMode,
                stopWatches
        );
        dialog.setVisible(true);
    }
}
