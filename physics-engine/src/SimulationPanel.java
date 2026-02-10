import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimulationPanel extends JPanel implements MouseListener {
    private static final float worldHeight = 5000;
    private static final float cubeSize = 100;
    private static final int cubeDensity = 7847;
    private static final double gravity = 9.80665;
    private float meterPerPixel = 0;
    private float scaledCubeSize = 0;
    private float cubeMassa = 0;
    private boolean isStarted = false;
    Cube cube;
    private float velocity;

    public SimulationPanel() {

    }

    public void init() {
        meterPerPixel = worldHeight / this.getHeight();
        scaledCubeSize = cubeSize / meterPerPixel;
        cubeMassa = cubeSize * cubeSize * cubeSize * cubeDensity;
    }

    public void start() {
        this.isStarted = true;
        this.velocity = 0;
    }

    public void stop() {
        this.velocity = 0;
    }

    public boolean isStarted() {
        return this.isStarted;
    }

    public void update(float delta) {
        if (cube != null) {
            if (cube.getY() >= this.getHeight() - 25 - scaledCubeSize) {
                this.stop();
            } else {
                velocity += (float) (gravity * delta / 1000);
                float newPosition = cube.getRelativePosition() - velocity * delta / 1000;
                cube.setRelativePosition(newPosition);
                int newY = (int) (this.getHeight() - 25 - scaledCubeSize - (newPosition / worldHeight * (this.getHeight() - 25 - scaledCubeSize)));
                cube.setY(newY);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (meterPerPixel != (worldHeight / this.getHeight())) {
            this.init();
        }
        if (cube != null) {
            g.drawRect(cube.getX(), cube.getY(), (int) scaledCubeSize, (int)scaledCubeSize);
            g.setColor(Color.blue);
            g.fillRect(cube.getX(), cube.getY(), (int) scaledCubeSize, (int)scaledCubeSize);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        velocity = 0;
        int deadSpace = 50;
        if (e.getY() >= deadSpace / 2 &&
                e.getY() <= this.getHeight() - (float) deadSpace / 2 - scaledCubeSize &&
                e.getX() >= deadSpace / 2 &&
                e.getX() <= this.getWidth() - (float) deadSpace / 2 - scaledCubeSize) {
            float relativePosition = worldHeight - ((float) e.getY() / (this.getHeight() - (float) deadSpace / 2 - scaledCubeSize)) * worldHeight;
            cube = new Cube(e.getX(), e.getY(), relativePosition);
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

    public float getRelativeHeight() {
        if (cube != null) {
            return cube.getRelativePosition();
        }
        return 0;
    }
}
