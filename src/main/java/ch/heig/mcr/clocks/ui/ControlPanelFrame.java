package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.constant.StopWatchString;
import javax.swing.*;

/**
 * A control panel frame that initializes and controls all
 * the stopwatches required.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 */
public class ControlPanelFrame extends JFrame {

    public ControlPanelFrame(int amountStopwatches) {
        super(StopWatchString.CONTROL_PANEL_TITLE);
        StopWatch[] stopWatches = new StopWatch[amountStopwatches];

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        setContentPane(contentPane);
        setResizable(false);

        for (int i = 0; i < amountStopwatches; i++) {
            stopWatches[i] = new StopWatch();
            add(new StopWatchControlRow(stopWatches[i]));
        }

        add(new StopWatchControlAll(stopWatches));
    }
}
