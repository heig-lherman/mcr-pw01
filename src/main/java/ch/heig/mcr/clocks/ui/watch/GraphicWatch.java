package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.constants.StopWatchConstants;
import ch.heig.mcr.clocks.constants.StopWatchString;
import ch.heig.mcr.clocks.time.StopWatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Objects;

abstract public class GraphicWatch extends Watch {
    private final Color hourColor;
    private final Color minuteColor;
    private final Color secondColor;
    private final Image image;
    GraphicWatch(StopWatch stopWatch, String imagePath, Color hourColor, Color minuteColor, Color secondColor) {
        super(stopWatch);
        this.image = new ImageIcon(
                (Objects.requireNonNull(getClass().getResource(imagePath))))
                .getImage()
                .getScaledInstance(StopWatchConstants.WIDTH, StopWatchConstants.HEIGHT, Image.SCALE_DEFAULT);
        this.hourColor = hourColor;
        this.minuteColor = minuteColor;
        this.secondColor = secondColor;
        JLabel label = new JLabel(StopWatchString.stopWatchWithId(stopWatch.getId()), SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 10, 10, this.getWidth() - 20, this.getHeight() - 20, this);
        drawNeedle(g, secondColor, Math.PI * getSeconds() / 30, 0.75);
        drawNeedle(g, minuteColor, Math.PI * getMinutes() / 30, 0.5);
        drawNeedle(g, hourColor, Math.PI * (getHours() + getMinutes() / 360.0), 0.4);
    }

    private void drawNeedle(Graphics g, Color color, double angle, double length){
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        int x2 = (int) (x + Math.sin(angle) * (getWidth() / 2 * length));
        int y2 = (int) (y - Math.cos(angle) * (getHeight() / 2 * length));
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.setColor(color);
        g2.draw(new Line2D.Double(x, y, x2, y2));
    }
}