package ch.heig.mcr.clocks.ui.constant;

/**
 * String constants reused across the application.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 */
public final class StopWatchString {
    public static final String CONTROL_PANEL_TITLE = "Panneau de contrôle";
    public static final String ALL_STOPWATCHES = "Tous les chronos";
    public static final String ROMAN = "Cadre romain";
    public static final String ARABIC = "Cadre arabe";
    public static final String DIGITAL = "Numérique";
    public static final String START = "Démarrer";
    public static final String STOP = "Arrêter";
    public static final String RESET = "Réinitialiser";

    /**
     * Returns the string representation of a stopwatch with the given id.
     * @param id the id of the stopwatch
     * @return the string representation of a stopwatch with the given id
     */
    public static String stopWatchWithId(long id) {
        return "Chrono #" + id;
    }

    private StopWatchString() {
        throw new IllegalStateException("Utility class");
    }
}
