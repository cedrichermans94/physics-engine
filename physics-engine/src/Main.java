import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    // Setting up JFrame
    int width = 1000;
    int height = 600;
    JFrame frame = new JFrame();
    frame.setSize(width, height);
    frame.setTitle("Physics Engine - Mk I");
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    // Setting up main panel
    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.setPreferredSize(frame.getSize());

    // Setting up information panel
    JPanel infoPanel = new JPanel(new BorderLayout());
    infoPanel.setPreferredSize(new Dimension(frame.getWidth(), 75));
    mainPanel.add(infoPanel, BorderLayout.NORTH);

    // Setting up icon on left
    int iconWidth = 100;
    int iconHeight = 75;
    ImageIcon icon = new ImageIcon(this.getClass().getResource("/img/icon.png"));
    Image image = icon.getImage();
    Image scaledImage = image.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(scaledImage);
    JLabel iconLabel = new JLabel(scaledIcon);
    iconLabel.setPreferredSize(new Dimension(iconWidth,iconHeight));
    infoPanel.add(iconLabel, BorderLayout.WEST);

    // Setting up info label on right
    JLabel explanationLabel = new JLabel("", SwingConstants.CENTER);
    explanationLabel.setText("<html>" +
            "Click anywhere on the simulation panel to generate a cube that falls in a vacuum at Earth's gravity.<br> " +
            "The maximum height of the simulation panel is 5 kilometer.");
    explanationLabel.setPreferredSize(new Dimension(frame.getWidth() - iconWidth,50));
    explanationLabel.setOpaque(true);
    explanationLabel.setBackground(Color.BLUE);
    explanationLabel.setForeground(Color.WHITE);
    infoPanel.add(explanationLabel, BorderLayout.EAST);

    // Setting up simulation panel
    JPanel simulationPanel = new JPanel();
    Border inside = new LineBorder(Color.BLACK, 5);
    Border outside = new EmptyBorder(20,20,20,20);
    simulationPanel.setBorder(new CompoundBorder(outside, inside));
    mainPanel.add(simulationPanel, BorderLayout.CENTER);

    frame.setContentPane(mainPanel);

    //
    frame.pack();
    frame.setVisible(true);
}
