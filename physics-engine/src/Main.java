import controller.Controller;
import model.Simulation;
import view.RootView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

public class Main {

    static void main() {
        System.setProperty( "apple.awt.application.name", "Physics Engine - Mk II" );
        // --- CREATE CONTROLLER ---
        Simulation simulation = new Simulation();
        RootView view = new RootView(simulation);
        Controller controller = new Controller(simulation, view);
        controller.init();
        controller.start();
    }
}