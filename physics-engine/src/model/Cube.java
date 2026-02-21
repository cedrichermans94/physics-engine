package model;

public class Cube {
    private final int x;
    private int y;
    private float size;
    private float relativePosition;
    private float startPosition;
    private final int density = 7847;
    private float mass;
    private float area;
    private final double dragCoefficient = 1.05;

    public Cube (int x, int y, float size, float relativePosition) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.relativePosition = relativePosition;
        this.startPosition = relativePosition;
        this.mass = size * size * size * density;
        this.area = size * size;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return  this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getRelativePosition() {
        return this.relativePosition;
    }

    public void setRelativePosition(float relativePosition) {
        this.relativePosition = relativePosition;
    }

    public float getMass() {
        return this.mass;
    }

    public float getStartPosition() {
        return this.startPosition;
    }

    public float getArea() {
        return this.area;
    }

    public double getDragCoefficient() {
        return this.dragCoefficient;
    }
}
