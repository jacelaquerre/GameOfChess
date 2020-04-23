public class Rook extends Piece {
    public Rook(Color color, boolean alive) {
        super(color, alive);
            shape = "\u265c";
    }

    @Override
    public boolean validMove(Box curr, Box goTo) {
        int x = Math.abs(curr.getX() - goTo.getX());
        int y = Math.abs(curr.getY() - goTo.getY());
        if ((x != 0 && y == 0) || (y != 0 && x ==0)) {
            return true;
        }
        else {
            return false;
        }
    }
}
