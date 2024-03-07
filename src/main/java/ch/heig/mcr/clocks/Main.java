package ch.heig.mcr.clocks;

import ch.heig.mcr.clocks.ui.ControlPanelFrame;
import javax.swing.*;

/**
 * A simple utility class for implementing the observer pattern
 * on a given object.
 *
 * @author Loïc Herman
 * @author Massimo Stefani
 * @version 1.0
 * @since 2024-02-22
 */
public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: clocks <number of stopwatches>");
            System.exit(1);
            return;
        }

        int amountStopwatches = Integer.parseInt(args[0]);
        SwingUtilities.invokeLater(() -> {
            ControlPanelFrame app = new ControlPanelFrame(amountStopwatches);

            app.pack();
            app.setVisible(true);
            app.setResizable(false);
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
