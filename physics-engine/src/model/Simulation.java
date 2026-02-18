package model;

public class Simulation {

    private final float worldHeight = 5000;
    private static final float cubeSize = 100;
    private static final double gravity = 9.80665;
    private float meterPerPixel = 0;
    private float scaledCubeSize = 0;
    private boolean isStarted = false;
    private Cube cube;
    private float velocity;
    private int panelHeight;

    public Simulation() {

    }

    public void init(int panelHeight) {
        this.panelHeight = panelHeight;
        meterPerPixel = worldHeight / panelHeight;
        scaledCubeSize = cubeSize / meterPerPixel;
    }

    public void start() {
        this.isStarted = true;
        this.velocity = 0;
    }

    public void stop() {
        this.velocity = 0;
        this.cube.setRelativePosition(0);
    }

    public boolean isStarted() {
        return this.isStarted;
    }

    public void update(float delta) {
        if (cube != null) {
            if (cube.getY() >= panelHeight - 25 - scaledCubeSize) {
                this.stop();
            } else {
                velocity += (float) (gravity * delta / 1000);
                float newPosition = cube.getRelativePosition() - velocity * delta / 1000;
                cube.setRelativePosition(newPosition);
                int newY = (int) (panelHeight - 25 - scaledCubeSize - (newPosition / worldHeight * (panelHeight - 25 - scaledCubeSize)));
                cube.setY(newY);
            }
        }
    }

    public float getRelativeHeight() {
        if (cube != null) {
            return cube.getRelativePosition();
        }
        return 0;
    }

    public Cube getCube() {
        return this.cube;
    }

    public void setCube(Cube cube) {
        this.cube = cube;
    }

    public float getMeterPerPixel() {
        return this.meterPerPixel;
    }

    public float getWorldHeight() {
        return this.worldHeight;
    }

    public float getScaledCubeSize() {
        return this.scaledCubeSize;
    }

    public float getVelocity() {
        return this.velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public float getCubeSize() {
        return cubeSize;
    }

    public float getCubeMass() {
        if (cube != null) {
            return this.cube.getMass();
        }
        return 0;
    }

    public double getGravity() {
        return gravity;
    }
}
