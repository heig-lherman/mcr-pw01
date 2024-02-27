package ch.heig.mcr.clocks.ui.watch;

import ch.heig.mcr.clocks.time.StopWatch;

public class RomanWatch extends GraphicWatch implements StopWatch.Observer {
    private static final String IMAGE_PATH = "/images/cadran_chiffres_romains.jpg";

    public RomanWatch(StopWatch stopWatch) {
        super(stopWatch, IMAGE_PATH);
    }

}
