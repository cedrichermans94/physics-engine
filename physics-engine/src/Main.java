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
    JFrame frame = new JFrame();
    frame.setSize(500, 300);
    frame.setTitle("Physics Engine - Mk I");
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    // Setting up main JPanel
    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.setPreferredSize(frame.getSize());

    // Setting up label on top
    JTextPane explanationLabel = new JTextPane();
    explanationLabel.setText("Click anywhere on the simulation panel to generate a cube that falls in a vacuum at Earth's gravity. The maximum height of the simulation panel is 5 kilometer.");
    explanationLabel.setPreferredSize(new Dimension(500,50));
    explanationLabel.setOpaque(true);
    explanationLabel.setBackground(Color.BLUE);
    explanationLabel.setForeground(Color.WHITE);
    mainPanel.add(explanationLabel, BorderLayout.NORTH);

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
