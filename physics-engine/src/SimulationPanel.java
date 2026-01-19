import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimulationPanel extends JPanel implements MouseListener {
    private static final float worldHeight = 5000;
    private static final float cubeSize = 100;
    private float meterPerPixel = 0;
    private float scaledCubeSize = 0;
    private boolean isStarted = false;
    Cube cube;

    public SimulationPanel() {

    }

    public void init() {
        meterPerPixel = worldHeight / this.getHeight();
        scaledCubeSize = cubeSize / meterPerPixel;
    }

    public void start() {
        this.isStarted = true;
    }

    public boolean isStarted() {
        return this.isStarted;
    }

    public void update() {
        if (cube != null) {
            cube.setY(cube.getY()+1);
        }
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
        if (isStarted) {
            int deadSpace = 50;
            if (e.getY() >= deadSpace / 2 &&
                    e.getY() <= this.getHeight() - deadSpace / 2 - scaledCubeSize &&
                    e.getX() >= deadSpace / 2 &&
                    e.getX() <= this.getWidth() - deadSpace / 2 - scaledCubeSize) {
                cube = new Cube(e.getX(), e.getY(), (int) scaledCubeSize, (int) scaledCubeSize);
                this.repaint();
            }
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
