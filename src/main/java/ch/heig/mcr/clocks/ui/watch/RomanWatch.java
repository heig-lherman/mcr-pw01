package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;
import java.awt.*;

/**
 * A dial with Roman numerals.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 */
public final class RomanWatch extends GraphicWatch {

    /**
     * Creates a new watch with Roman numerals.
     * @param stopWatch the stopwatch to observe
     */
    public RomanWatch(StopWatch stopWatch) {
        super(
                stopWatch,
                "/images/cadran_chiffres_romains.jpg",
                Color.BLACK,
                Color.GRAY,
                Color.ORANGE
        );
    }
}
