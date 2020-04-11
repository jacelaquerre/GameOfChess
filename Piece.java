public class Piece {
    public enum Color {white, black}
    private Color color;
    public boolean alive;

    public Piece(Color color, boolean alive) {
        this.color = color;
        this.alive = alive;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}



