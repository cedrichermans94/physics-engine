package view;

import model.Simulation;

import javax.swing.*;
import java.awt.*;

public class RootView extends JFrame {
    private int width;
    private int height;

    private Simulation simulation;

    private HeaderView headerView;
    private JSplitPane infoSimulationContainer;
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
        infoView = new InfoView(this, simulation);

        infoSimulationContainer = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, simulationView, infoView);
        infoSimulationContainer.setResizeWeight(1);
        infoSimulationContainer.setDividerSize(0);
        infoSimulationContainer.setBorder(null);
        infoSimulationContainer.setEnabled(false);

        add(headerView, BorderLayout.NORTH);
        add(infoSimulationContainer, BorderLayout.CENTER);
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
        if (!this.infoView.isHidden()) {
            this.infoView.repaint();
        }
    }

    public JSplitPane getInfoSimulationContainer() {
        return this.infoSimulationContainer;
    }

    public SimulationView getSimulationView() {
        return this.simulationView;
    }

    public  InfoView getInfoView() {
        return this.infoView;
    }
}
