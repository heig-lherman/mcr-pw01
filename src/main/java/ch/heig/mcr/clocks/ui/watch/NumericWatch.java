package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;

import java.awt.*;
import java.time.Duration;

public class NumericWatch extends Watch implements StopWatch.Observer {
    public NumericWatch(StopWatch stopWatch) {
        super(stopWatch);
    }

    @Override
    protected void paintComponent(Graphics g) {
        String text = "Chrono #" + getStopWatch().getId() + ": 00:00:00";
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();
        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() + textHeight) / 2;
        g.drawString(text, x, y);
    }

    @Override
    public void update(long id, Duration value) {
    }
}
