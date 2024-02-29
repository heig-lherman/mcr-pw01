package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.constants.StopWatchString;
import ch.heig.mcr.clocks.time.StopWatch;

import java.awt.*;
import java.time.Duration;

public class NumericWatch extends Watch {
    public NumericWatch(long id, Duration value) {
        super(id, value);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String text = StopWatchString.stopWatchWithId(getId()) + ": "
                + String.format("%02d", getHours() % 24) + ":"
                + String.format("%02d", getMinutes()) + ":"
                + String.format("%02d", getSeconds());
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();
        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() + textHeight) / 2;
        g.drawString(text, x, y);
    }
}
