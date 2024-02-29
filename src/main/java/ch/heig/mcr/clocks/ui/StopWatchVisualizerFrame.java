package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.watch.Watch;
import java.awt.*;
import javax.swing.*;

public class StopWatchVisualizerFrame extends JFrame {

    public StopWatchVisualizerFrame(
            DisplayMode displayMode,
            StopWatch stopWatch
    ) {
        this(displayMode, new StopWatch[]{stopWatch});
    }

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

    @Override
    public void dispose() {
        synchronized (getTreeLock()) {
            for (Component component : getComponents()) {
                if (component instanceof Disposable disposable) {
                    disposable.dispose();
                }
            }
        }

        super.dispose();
    }
}
