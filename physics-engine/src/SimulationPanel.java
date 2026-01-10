import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends JPanel {
    Cube cube;

    public SimulationPanel() {
        cube = new Cube(100,100,100,100);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawRect(cube.getX(), cube.getY(), cube.getWidth(), cube.getHeight());
        g.setColor(Color.black);
        g.fillRect(100,100,100,100);
    }
}
