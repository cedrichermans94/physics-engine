package view;

import model.Simulation;

import javax.swing.*;
import java.awt.*;

public class InfoView extends JPanel {
    private Simulation simulation;
    private JLabel heightLabelValue;
    private JLabel velocityLabelValue;

    public InfoView(RootView rootView, Simulation simulation) {
        this.simulation = simulation;
        setPreferredSize(new Dimension(300, rootView.getHeight()));
        setBackground(Color.DARK_GRAY);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel heightLabelText = new JLabel("Height:");
        heightLabelValue = new JLabel("");

        JLabel velocityLabelText = new JLabel("Velocity:");
        velocityLabelValue = new JLabel("");

        heightLabelText.setForeground(Color.WHITE);
        heightLabelValue.setForeground(Color.WHITE);
        velocityLabelText.setForeground(Color.WHITE);
        velocityLabelValue.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(heightLabelText, gbc);
        gbc.gridx = 1;
        add(heightLabelValue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(velocityLabelText, gbc);

        gbc.gridx = 1;
        add(velocityLabelValue, gbc);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        heightLabelValue.setText((int)this.simulation.getRelativeHeight() + " m");
        velocityLabelValue.setText((int)this.simulation.getVelocity() + " m/s");
    }
}
