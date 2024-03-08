package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.constant.StopWatchString;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Base class for dials that implement a graphic representation of the time
 * using a background image.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 */
public abstract class GraphicWatch extends Watch {

    private final Image image;
    private final Color hourColor;
    private final Color minuteColor;
    private final Color secondColor;

    protected GraphicWatch(
            StopWatch stopWatch,
            String imagePath,
            Color hourColor,
            Color minuteColor,
            Color secondColor
    ) {
        super(stopWatch);
        this.image = Toolkit.getDefaultToolkit()
                .getImage(getClass().getResource(imagePath))
                .getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

        this.hourColor = hourColor;
        this.minuteColor = minuteColor;
        this.secondColor = secondColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graph = (Graphics2D) g;
        graph.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        graph.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        drawNeedle(graph, secondColor, Math.PI * getSeconds() / 30, 0.75);
        drawNeedle(graph, minuteColor, Math.PI * (getMinutes() + (getSeconds() / 60.0)) / 30.0, 0.5);
        drawNeedle(graph, hourColor, Math.PI * (getHours() + getMinutes() / 360.0), 0.4);

        var text = StopWatchString.stopWatchWithId(getStopWatchId());
        FontMetrics metrics = graph.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(text)) / 2;
        int y = (getHeight() - metrics.getHeight()) / 2 + 25;
        graph.drawString(text, x, y);
    }

    private void drawNeedle(Graphics2D graph, Color color, double angle, double length) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int endX = (int) (centerX * (1 + Math.sin(angle) * length));
        int endY = (int) (centerY * (1 - Math.cos(angle) * length));
        graph.setStroke(new BasicStroke(2));
        graph.setColor(color);
        graph.draw(new Line2D.Double(centerX, centerY, endX, endY));
    }
}
