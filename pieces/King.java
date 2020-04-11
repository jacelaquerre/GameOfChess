public class King extends Piece {

    public King(Color color, boolean alive){
        super(color, alive);
    }

    public boolean validMove(Box curr, Box goTo) {
        // Check if box has piece of same color
        if (curr.getPiece().getColor() == goTo.getPiece().getColor()) {
            return false;
        }
        int x = Math.abs(curr.getX() - goTo.getX());
        int y = Math.abs(curr.getY() - goTo.getY());
        if (x + y == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public void draw() {

    }
}


