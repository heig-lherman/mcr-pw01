package ch.heig.mcr.clocks;

import ch.heig.mcr.clocks.ui.ControlPanelFrame;
import javax.swing.*;

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
