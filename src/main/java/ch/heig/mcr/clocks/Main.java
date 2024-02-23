package ch.heig.mcr.clocks;

import ch.heig.mcr.clocks.ui.ControlPanelFrame;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        ControlPanelFrame app = new ControlPanelFrame(3);
        app.pack();
        app.setVisible(true);
        app.setResizable(false);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
