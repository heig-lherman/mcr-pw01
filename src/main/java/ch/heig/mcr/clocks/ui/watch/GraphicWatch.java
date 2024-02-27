package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.time.Duration;
import java.util.Objects;
import java.util.Observer;

abstract public class GraphicWatch extends Watch implements StopWatch.Observer {
    private final Image image;
    GraphicWatch(StopWatch stopWatch, String imagePath) {
        super(stopWatch);
        this.image = new ImageIcon(
                        (Objects.requireNonNull(getClass().getResource(imagePath))))
                        .getImage()
                        .getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel label = new JLabel("Chrono #" + stopWatch.getId(), SwingConstants.CENTER);
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
        double minuteRot = 2 * Math.PI / 30d;
        double hourRot = 1 * Math.PI / 6d + minuteRot / 12d;
        g2.setStroke(new BasicStroke(8f));
        g2.setPaint(Color.BLACK);
        g2.draw(AffineTransform.getRotateInstance(hourRot).createTransformedShape(hourHand));

        // Drawing the minute hand
        float minuteHandLen = 5f * radius / 6f;
        Shape minuteHand = new Line2D.Float(0f, 0f, 0f, -minuteHandLen);
        g2.setStroke(new BasicStroke(4f));
        g2.setPaint(Color.BLACK);
        g2.draw(AffineTransform.getRotateInstance(minuteRot).createTransformedShape(minuteHand));

        // Drawing the second hand
        float r = radius / 6f;
        float secondHandLen = radius - r;
        Shape secondHand = new Line2D.Float(0f, r, 0f, -secondHandLen);
        double secondRot = 1 * Math.PI / 30d;
        g2.setPaint(Color.RED);
        g2.setStroke(new BasicStroke(1f));
        g2.draw(AffineTransform.getRotateInstance(secondRot).createTransformedShape(secondHand));
        g2.fill(new Ellipse2D.Float(-r / 4f, -r / 4f, r / 2f, r / 2f));

        g2.dispose();
    }

    @Override
    public void update(long id, Duration value) {
    }
}
