package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;

import java.awt.*;

public class NumericWatch extends Watch {
    public NumericWatch(StopWatch stopWatch) {
        super(stopWatch);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String text = "Chrono #" + getStopWatch().getId() + ": "
                + String.format("%02d", getHours()) + ":"
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
