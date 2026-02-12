package view;

import model.Simulation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimulationView extends JPanel {
    private Simulation simulation;

    public SimulationView(RootView rootView, Simulation simulation) {
        this.simulation = simulation;
        Border inside = new LineBorder(Color.BLACK, 5);
        Border outside = new EmptyBorder(20,20,20,20);
        setBorder(new CompoundBorder(outside, inside));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.simulation.getMeterPerPixel() != (this.simulation.getWorldHeight() / this.getHeight())) {
            this.simulation.init(this.getHeight());
        }
        if (this.simulation.getCube() != null) {
            g.drawRect(this.simulation.getCube().getX(), this.simulation.getCube().getY(), (int) this.simulation.getScaledCubeSize(), (int)this.simulation.getScaledCubeSize());
            g.setColor(Color.BLUE);
            g.fillRect(this.simulation.getCube().getX(), this.simulation.getCube().getY(), (int) this.simulation.getScaledCubeSize(), (int)this.simulation.getScaledCubeSize());
        }
    }
}
