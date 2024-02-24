package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.time.StopWatch;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class StopWatchVisualizerDialog extends JFrame {

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
        super(parentFrame.getGraphicsConfiguration());

        this.displayMode = displayMode;
        this.stopWatches = stopWatches;
        addImagePanel();
        setSize(235 * stopWatches.length, 260);
        setLocationRelativeTo(parentFrame);
        setResizable(stopWatches.length > 1);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    private void addImagePanel() {
        setLayout(new GridLayout(1, stopWatches.length));
        Image image = new ImageIcon(
                Objects.requireNonNull(getClass().getResource(displayMode.getImagePath())))
                .getImage()
                .getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        for (int i = 0; i < stopWatches.length; i++) {
            StopWatchVisualizerDialogPanel imageP = new StopWatchVisualizerDialogPanel(image);
            add(imageP);
        }
    }

    private static class StopWatchVisualizerDialogPanel extends JPanel {
        private final Image image;

        public StopWatchVisualizerDialogPanel(Image image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 10, 10, this);
        }

    }
}
