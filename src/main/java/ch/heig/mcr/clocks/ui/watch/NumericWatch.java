package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.constant.StopWatchString;
import java.awt.*;
import javax.swing.*;

public final class NumericWatch extends Watch {

    private final JLabel label;

    public NumericWatch(StopWatch stopWatch) {
        super(stopWatch);
        setLayout(new BorderLayout());

        label = new JLabel(
                getFormattedText(),
                SwingConstants.CENTER
        );

        add(label, BorderLayout.CENTER);
    }

    @Override
    public void update() {
        label.setText(getFormattedText());
    }

    private String getFormattedText() {
        return "%s: %02dh %02dm %02ds".formatted(
                StopWatchString.stopWatchWithId(getStopWatchId()),
                getHours(),
                getMinutes(),
                getSeconds()
        );
    }
}
