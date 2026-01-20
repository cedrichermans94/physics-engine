public class Cube {
    private int x;
    private int y;
    private int width;
    private int height;
    private float relativePosition;

    public Cube (int x, int y, int width, int height, float relativePosition) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getRelativePosition() {
        return this.relativePosition;
    }

    public void setRelativePosition(float relativePosition) {
        this.relativePosition = relativePosition;
    }
}
