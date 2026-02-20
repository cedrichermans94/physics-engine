package view;

import model.Simulation;

import javax.swing.*;
import java.awt.*;

public class InfoView extends JPanel {
    private Simulation simulation;
    private JLabel massLabelValue;
    private JLabel heightLabelValue;
    private JLabel gravityLabelValue;
    private JLabel velocityLabelValue;
    private JLabel impactLabelValue;

    public InfoView(RootView rootView, Simulation simulation) {
        this.simulation = simulation;
        setPreferredSize(new Dimension(300, rootView.getHeight()));
        setBackground(Color.DARK_GRAY);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel massLabelText = new JLabel("Mass:");
        massLabelValue = new JLabel("");

        JLabel heightLabelText = new JLabel("Height:");
        heightLabelValue = new JLabel("");

        JLabel gravityLabelText = new JLabel("Gravity:");
        gravityLabelValue = new JLabel("");

        JLabel velocityLabelText = new JLabel("Velocity:");
        velocityLabelValue = new JLabel("");

        JLabel impactLabelText = new JLabel("Kinetic energy on impact:");
        impactLabelValue = new JLabel("");

        massLabelText.setForeground(Color.WHITE);
        massLabelValue.setForeground(Color.WHITE);
        heightLabelText.setForeground(Color.WHITE);
        heightLabelValue.setForeground(Color.WHITE);
        gravityLabelText.setForeground(Color.WHITE);
        gravityLabelValue.setForeground(Color.WHITE);
        velocityLabelText.setForeground(Color.WHITE);
        velocityLabelValue.setForeground(Color.WHITE);
        impactLabelText.setForeground(Color.WHITE);
        impactLabelValue.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(massLabelText, gbc);

        gbc.gridx = 1;
        add(massLabelValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(heightLabelText, gbc);

        gbc.gridx = 1;
        add(heightLabelValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(gravityLabelText, gbc);

        gbc.gridx = 1;
        add(gravityLabelValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(velocityLabelText, gbc);

        gbc.gridx = 1;
        add(velocityLabelValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(impactLabelText, gbc);

        gbc.gridx = 1;
        add(impactLabelValue, gbc);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        massLabelValue.setText((long)this.simulation.getCubeMass() + " kg");
        heightLabelValue.setText((int)this.simulation.getRelativeHeight() + " m");
        gravityLabelValue.setText(this.simulation.getGravity() + " m/s²");
        velocityLabelValue.setText((int)this.simulation.getVelocity() + " m/s");
        impactLabelValue.setText(Math.round(this.simulation.getImpactEnergy()*100.00) / 100.00 + " TJ");
    }
}
