package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.constants.StopWatchConstants;
import ch.heig.mcr.clocks.constants.StopWatchString;
import ch.heig.mcr.clocks.time.StopWatch;

import javax.swing.*;
import java.awt.*;
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
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle rect = SwingUtilities.calculateInnerArea(this, null);
        float radius = Math.min(rect.width, rect.height) / 2f - 10f;
        g2.translate(rect.getCenterX(), rect.getCenterY());

        // Drawing the hour hand
        float hourHandLen = radius / 2f;
        Shape hourHand = new Line2D.Float(0f, 0f, 0f, -hourHandLen);
        double minuteRot = getMinutes() * Math.PI / 30d;
        double hourRot = getHours() * Math.PI / 6d + minuteRot / 12d;
        g2.setStroke(new BasicStroke(8f));
        g2.setPaint(hourColor);
        g2.draw(AffineTransform.getRotateInstance(hourRot).createTransformedShape(hourHand));

        // Drawing the minute hand
        float minuteHandLen = 5f * radius / 6f;
        Shape minuteHand = new Line2D.Float(0f, 0f, 0f, -minuteHandLen);
        g2.setStroke(new BasicStroke(4f));
        g2.setPaint(minuteColor);
        g2.draw(AffineTransform.getRotateInstance(minuteRot).createTransformedShape(minuteHand));

        // Drawing the second hand
        float r = radius / 6f;
        float secondHandLen = radius - r;
        Shape secondHand = new Line2D.Float(0f, r, 0f, -secondHandLen);
        double secondRot = getSeconds() * Math.PI / 30d;
        g2.setPaint(secondColor);
        g2.setStroke(new BasicStroke(1f));
        g2.draw(AffineTransform.getRotateInstance(secondRot).createTransformedShape(secondHand));
        g2.fill(new Ellipse2D.Float(-r / 4f, -r / 4f, r / 2f, r / 2f));

        g2.dispose();
    }
}