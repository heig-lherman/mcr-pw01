package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;

public class ArabicWatch extends GraphicWatch {
    private static final String IMAGE_PATH = "/images/cadran_chiffres_arabes.jpg";
    public ArabicWatch(StopWatch stopWatch) {
        super(stopWatch, IMAGE_PATH);
    }
}
