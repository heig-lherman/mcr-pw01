package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;
import java.awt.*;

/**
 * A dial with Arabic numerals.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 */
public final class ArabicWatch extends GraphicWatch {

    public ArabicWatch(StopWatch stopWatch) {
        super(
                stopWatch,
                "/images/cadran_chiffres_arabes.jpg",
                Color.BLACK,
                Color.BLUE,
                Color.RED
        );
    }
}
