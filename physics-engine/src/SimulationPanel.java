import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimulationPanel extends JPanel implements MouseListener {
    private static final float worldHeight = 5000;
    private static final float cubeSize = 100;
    private float meterPerPixel = 0;
    private float scaledCubeSize = 0;
    Cube cube;

    public SimulationPanel() {

    }

    public void init() {
        meterPerPixel = worldHeight / this.getHeight();
        scaledCubeSize = cubeSize / meterPerPixel;
        IO.println(scaledCubeSize);
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
        IO.println("doe iets");
        int deadSpace = 50;
        if (e.getY() >= deadSpace / 2 &&
                e.getY() <= this.getHeight() - deadSpace / 2 - scaledCubeSize &&
                e.getX() >= deadSpace / 2 &&
                e.getX() <= this.getWidth() - deadSpace / 2 - scaledCubeSize) {
            cube = new Cube(e.getX(), e.getY(), (int)scaledCubeSize, (int)scaledCubeSize);
            IO.println(cube.getWidth());
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
