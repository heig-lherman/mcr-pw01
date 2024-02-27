package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.constants.StopWatchString;
import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.watch.ArabicWatch;
import ch.heig.mcr.clocks.ui.watch.NumericWatch;
import ch.heig.mcr.clocks.ui.watch.RomanWatch;
import ch.heig.mcr.clocks.ui.watch.Watch;

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
    String getName() {
        return name;
    }
    abstract Watch createWatch(StopWatch stopWatch);
}
