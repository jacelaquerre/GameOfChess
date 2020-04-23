public class Queen extends Piece {
    public Queen(Color color, boolean alive){
        super(color, alive);
            shape = "\u265b";
    }

    @Override
    public boolean validMove(Box curr, Box goTo) {
        int x = Math.abs(curr.getX() - goTo.getX());
        int y = Math.abs(curr.getY() - goTo.getY());
        if ((x != 0 && y == 0) || (y != 0 && x ==0 || (x / y == 1))) {
            return true;
        }
        else {
            return false;
        }
    }
}
