import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends JPanel {
    public SimulationPanel() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawRect(100,100,100,100);
        g.setColor(Color.black);
        g.fillRect(100,100,100,100);
    }
}
