public class King extends Piece{

    public King(int x, int y, Color color, Type type, boolean alive){
        super(x, y, color, type, alive);

    }

    public boolean validMove(int newY, int newX) {
        int x = get_x();
        int y = get_y();
        if ((newY == x - 1 && newY == y) ||
                (newX == x + 1 && newY == y) ||
                (newX == x && newY == y - 1) ||
                (newX == x && newY == y + 1) ||
                (newX == x - 1 && newY == y - 1) ||
                (newX == x + 1 && newY == y + 1) ||
                (newX == x - 1 && newY == y + 1) ||
                (newX == x + 1 && newY == y - 1)) {
            return true;
        }
        return false;
    }

    public void draw() {

    }
}


