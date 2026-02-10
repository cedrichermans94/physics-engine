import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

public class Main {
    static void main() {
        // Setting up JFrame
        System.setProperty( "apple.awt.application.name", "Physics Engine - Mk II" );
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int infoHeight = 100;
        int infoWidth = 100;
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setMinimumSize(new Dimension(800,400));
        frame.setTitle("Physics Engine - Mk I");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Setting up root panel
        JPanel rootPanel = new JPanel(new BorderLayout());
        rootPanel.setPreferredSize(frame.getSize());

        // Setting up info panel
        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setPreferredSize(new Dimension(300, frame.getHeight()));
        infoPanel.setBackground(Color.DARK_GRAY);
        JLabel infoLabel = new JLabel("Variables");
        infoLabel.setForeground(Color.WHITE);
        infoPanel.add(infoLabel);
        rootPanel.add(infoPanel, BorderLayout.EAST);

        // Setting up main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(frame.getSize());

        // Setting up head panel
        JPanel headPanel = new JPanel(new BorderLayout());
        //infoPanel.setPreferredSize(new Dimension(frame.getWidth(), infoHeight));
        mainPanel.add(headPanel, BorderLayout.NORTH);

        // Setting up icon on left
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/img/icon2.png")));
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(infoWidth, infoHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel iconLabel = new JLabel(scaledIcon);
        iconLabel.setPreferredSize(new Dimension(infoWidth,infoHeight));
        headPanel.add(iconLabel, BorderLayout.WEST);

        // Setting up info label on right
        JLabel explanationLabel = new JLabel("", SwingConstants.CENTER);
        explanationLabel.setText("<html>" +
                "Click anywhere on the simulation panel to generate a cube that falls in a vacuum under Earth's gravity.<br> " +
                "The maximum height of the simulation panel is 5 kilometers and the cube has a size of 100 meters.");
        explanationLabel.setOpaque(true);
        explanationLabel.setBackground(Color.BLUE);
        explanationLabel.setForeground(Color.WHITE);
        headPanel.add(explanationLabel, BorderLayout.CENTER);

        // Setting up simulation panel
        SimulationPanel simulationPanel = new SimulationPanel();
        Border inside = new LineBorder(Color.BLACK, 5);
        Border outside = new EmptyBorder(20,20,20,20);
        simulationPanel.setBorder(new CompoundBorder(outside, inside));
        mainPanel.add(simulationPanel, BorderLayout.CENTER);
        simulationPanel.addMouseListener(simulationPanel);

        // finalize frame
        rootPanel.add(mainPanel, BorderLayout.CENTER);
        frame.setContentPane(rootPanel);
        frame.pack();

        // init simulation
        simulationPanel.init();

        // start simulation
        int ups = 60;
        simulationPanel.start();
        long previousTime = System.currentTimeMillis();
        long wait = 0;
        while (simulationPanel.isStarted()) {
            long currentTime = System.currentTimeMillis();
            long deltaTime = currentTime - previousTime;
            previousTime = currentTime;
            wait += deltaTime;
            while (wait >= 1000/ups) {
                simulationPanel.update(wait);
                simulationPanel.repaint();
                wait = 0;
            }
        }
    }
}