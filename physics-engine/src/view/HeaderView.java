package view;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class HeaderView extends JPanel {
    private JPanel headerPanel;
    private int infoWidth = 100;
    private int infoHeight = 100;

    public HeaderView(RootView rootView) {
        setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon2.png")));
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(infoWidth, infoHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel iconLabel = new JLabel(scaledIcon);
        iconLabel.setPreferredSize(new Dimension(infoWidth,infoHeight));
        add(iconLabel, BorderLayout.WEST);

        // Setting up info label on right
        JLabel explanationLabel = new JLabel("", SwingConstants.CENTER);
        explanationLabel.setText("<html>" +
                "Click anywhere on the simulation panel to generate an iron cube that falls under Earth's gravity.<br> " +
                "The maximum height of the simulation panel is 5 kilometers and the cube has a size of 100 meters.<br> " +
                "You can hide or show the parameters window by pressing the key I.");
        explanationLabel.setOpaque(true);
        explanationLabel.setBackground(Color.BLUE);
        explanationLabel.setForeground(Color.WHITE);
        add(explanationLabel, BorderLayout.CENTER);
    }
}
