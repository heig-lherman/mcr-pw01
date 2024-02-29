package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;

import java.awt.*;
import java.time.Duration;

public class ArabicWatch extends GraphicWatch {
    private static final String IMAGE_PATH = "/images/cadran_chiffres_arabes.jpg";
    private static final Color HOUR_COLOR = Color.BLACK;
    private static final Color MINUTE_COLOR = Color.BLUE;
    private static final Color SECOND_COLOR = Color.RED;
    public ArabicWatch(long id, Duration value) {
        super(id, value, IMAGE_PATH, HOUR_COLOR, MINUTE_COLOR, SECOND_COLOR);
    }
}
