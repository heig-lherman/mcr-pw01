package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.constants.StopWatchString;
import ch.heig.mcr.clocks.time.StopWatch;
import java.awt.*;
import javax.swing.*;

public class ControlPanelFrame extends JFrame {

    private StopWatch[] stopWatches;

    public ControlPanelFrame(int amountStopwatches) {
        super(StopWatchString.CONTROL_PANEL_TITLE);
        stopWatches = new StopWatch[amountStopwatches];

        JPanel contentPane = new JPanel();
        JPanel controlRowsPane = new JPanel();
        JPanel globalButtonsRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        setContentPane(contentPane);
        setResizable(false);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        controlRowsPane.setLayout(new BoxLayout(controlRowsPane, BoxLayout.Y_AXIS));

        for (int i = 0; i < amountStopwatches; i++) {
            stopWatches[i] = new StopWatch();
            controlRowsPane.add(new StopWatchControlRow(stopWatches[i]));
        }

        globalButtonsRow.add(new StopWatchControlAll(stopWatches));
        add(controlRowsPane);
        add(globalButtonsRow);
    }
}
