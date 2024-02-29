package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;
import java.awt.*;

public final class RomanWatch extends GraphicWatch {

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
