import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimulationPanel extends JPanel implements MouseListener {
    private final int worldHeight = 5000;
    private final int cubeSize = 50;
    private final int deadSpace = 50;
    Cube cube;

    public SimulationPanel() {
        //cube = new Cube(100,100,100,100);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        if (cube != null) {
            g.drawRect(cube.getX(), cube.getY(), cube.getWidth(), cube.getHeight());
            g.setColor(Color.blue);
            g.fillRect(cube.getX(), cube.getY(), cube.getWidth(), cube.getHeight());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        IO.println("panel height: " + this.getHeight());
        if (e.getY() >= this.deadSpace / 2 &&
                e.getY() <= this.getHeight() - this.deadSpace / 2 - this.cubeSize &&
                e.getX() <= this.getWidth() - this.deadSpace / 2 - this.cubeSize) {
            cube = new Cube(e.getX(), e.getY(), this.cubeSize, this.cubeSize);
            IO.println(e.getX() + " " + e.getY());
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
