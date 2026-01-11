import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimulationPanel extends JPanel implements MouseListener {
    Cube cube;

    public SimulationPanel() {
        //cube = new Cube(100,100,100,100);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        if (cube != null) {
            IO.println("Cube made");
            g.drawRect(cube.getX(), cube.getY(), cube.getWidth(), cube.getHeight());
            g.setColor(Color.black);
            g.fillRect(cube.getX(), cube.getY(), cube.getWidth(), cube.getHeight());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cube = new Cube(e.getX(), e.getY(), 100, 100);
        this.repaint();
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
