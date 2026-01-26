public class Cube {
    private final int x;
    private int y;
    private float relativePosition;

    public Cube (int x, int y, float relativePosition) {
        this.x = x;
        this.y = y;
        this.relativePosition = relativePosition;
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
}
