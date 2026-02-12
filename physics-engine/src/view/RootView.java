package view;

import model.Simulation;

import javax.swing.*;
import java.awt.*;

public class RootView extends JFrame {
    private int width;
    private int height;

    private Simulation simulation;

    private HeaderView headerView;
    private SimulationView simulationView;
    private InfoView infoView;

    public RootView(Simulation simulation) {
        System.setProperty( "apple.awt.application.name", "Physics Engine - Mk II" );
        width = Toolkit.getDefaultToolkit().getScreenSize().width;
        height = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.init();

        this.simulation = simulation;

        headerView = new HeaderView(this);
        simulationView = new SimulationView(this, simulation);
        infoView = new InfoView(this);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, simulationView, infoView);
        splitPane.setResizeWeight(1);
        splitPane.setDividerSize(0);
        splitPane.setBorder(null);
        splitPane.setEnabled(false);

        add(headerView, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);
    }

    public void init() {
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800,400));
        setTitle("Physics Engine - Mk II");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void render() {
        this.simulationView.repaint();
    }

    public SimulationView getSimulationView() {
        return this.simulationView;
    }
}
