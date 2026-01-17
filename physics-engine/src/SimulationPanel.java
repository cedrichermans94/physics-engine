import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimulationPanel extends JPanel implements MouseListener {
    public static final float worldHeight = 5000;
    public static final int cubeSize = 100;
    Cube cube;

    public SimulationPanel() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        if (cube != null) {
            g.drawRect(cube.getX(), cube.getY(), cube.getWidth(),cube.getHeight());
            g.setColor(Color.blue);
            g.fillRect(cube.getX(), cube.getY(), cube.getWidth(), cube.getHeight());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int deadSpace = 50;
        if (e.getY() >= deadSpace / 2 &&
                e.getY() <= this.getHeight() - deadSpace / 2 - cubeSize &&
                e.getX() <= this.getWidth() - deadSpace / 2 - cubeSize) {
            cube = new Cube(e.getX(), e.getY(), cubeSize, cubeSize);
            this.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
