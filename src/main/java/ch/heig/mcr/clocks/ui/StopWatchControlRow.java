package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.time.StopWatch;
import java.awt.*;
import java.util.Objects;
import javax.swing.*;

public class StopWatchControlRow extends JPanel {

    private final StopWatch stopWatch;

    public StopWatchControlRow(StopWatch stopWatch) {
        super(new FlowLayout(FlowLayout.LEFT));
        this.stopWatch = stopWatch;

        JLabel idLabel = new JLabel("Chrono #" + stopWatch.getId());

        JButton startButton = new JButton("Démarrer");
        JButton stopButton = new JButton("Arrêter");
        JButton resetButton = new JButton("Réinitialiser");

        startButton.addActionListener(e -> stopWatch.start());
        stopButton.addActionListener(e -> stopWatch.stop());
        resetButton.addActionListener(e -> stopWatch.reset());

        JButton romanButton = new JButton("Cadre romain");
        JButton arabicButton = new JButton("Cadre arabe");
        JButton digitalButton = new JButton("Numérique");

        romanButton.addActionListener(e -> showDialog(DisplayMode.ROMAN));
        arabicButton.addActionListener(e -> showDialog(DisplayMode.ARABIC));
        digitalButton.addActionListener(e -> showDialog(DisplayMode.DIGITAL));

        add(idLabel);
        add(startButton);
        add(stopButton);
        add(resetButton);
        add(romanButton);
        add(arabicButton);
        add(digitalButton);
    }
    private void showDialog(DisplayMode displayMode) {
        StopWatchVisualizerDialog dialog = new StopWatchVisualizerDialog(
                (JFrame) SwingUtilities.getWindowAncestor(this),
                displayMode,
                stopWatch
        );
        dialog.setVisible(true);
    }
}
