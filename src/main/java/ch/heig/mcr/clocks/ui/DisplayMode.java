package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.constant.StopWatchString;
import ch.heig.mcr.clocks.ui.watch.ArabicWatch;
import ch.heig.mcr.clocks.ui.watch.NumericWatch;
import ch.heig.mcr.clocks.ui.watch.RomanWatch;
import ch.heig.mcr.clocks.ui.watch.Watch;

/**
 * An enumeration to help with the creation of the different
 * rows of buttons for the control panel.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 */
public enum DisplayMode {
    ROMAN(StopWatchString.ROMAN) {
        @Override
        Watch createWatch(StopWatch stopWatch) {
            return new RomanWatch(stopWatch);
        }
    },
    ARABIC(StopWatchString.ARABIC) {
        @Override
        Watch createWatch(StopWatch stopWatch) {
            return new ArabicWatch(stopWatch);
        }
    },
    DIGITAL(StopWatchString.DIGITAL) {
        @Override
        Watch createWatch(StopWatch stopWatch) {
            return new NumericWatch(stopWatch);
        }
    };

    private final String name;

    DisplayMode(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the display mode.
     *
     * @return the description of the display mode
     */
    public String getDescription() {
        return name;
    }

    /**
     * Initializes the dial panel with the given stop watch.
     *
     * @param stopWatch the stop watch to visualize
     * @return the initialized dial panel
     */
    abstract Watch createWatch(StopWatch stopWatch);
}
