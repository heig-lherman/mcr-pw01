package ch.heig.mcr.clocks.ui;

import ch.heig.mcr.clocks.constants.StopWatchString;
import ch.heig.mcr.clocks.time.StopWatch;
import ch.heig.mcr.clocks.ui.watch.ArabicWatch;
import ch.heig.mcr.clocks.ui.watch.NumericWatch;
import ch.heig.mcr.clocks.ui.watch.RomanWatch;
import ch.heig.mcr.clocks.ui.watch.Watch;

import java.time.Duration;

public enum DisplayMode {
    ROMAN(StopWatchString.ROMAN) {
        @Override
        Watch createWatch(long id, Duration value) {
            return new RomanWatch(id, value);
        }
    },
    ARABIC(StopWatchString.ARABIC) {
        @Override
        Watch createWatch(long id, Duration value) {
            return new ArabicWatch(id, value);
        }
    },
    DIGITAL(StopWatchString.DIGITAL) {
        @Override
        Watch createWatch(long id, Duration value) {
            return new NumericWatch(id, value);
        }
    };
    private final String name;
    DisplayMode(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
    abstract Watch createWatch(long id, Duration value);
}
