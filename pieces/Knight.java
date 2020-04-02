public class Knight extends Piece{
    public Knight(int x, int y, Color color, Type type, boolean alive){
        super(x, y, color, type, alive);
    }

    public boolean validMove(int newY, int newX) {
        int x = get_x();
        int y = get_y();
        // Logic here
        return false;
    }

    public void draw() {

    }
}
