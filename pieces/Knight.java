public class Knight extends Piece {
    public Knight(Color color, boolean alive){
        super(color, alive);
        if (color == Piece.Color.WHITE) {
            shape = "\u2658";
        }
        else{
            shape = "\u265e";
        }
    }

    public boolean validMove(Box curr, Box goTo) {
        // Check if box has piece of same color
        if (curr.getPiece().getColor() == goTo.getPiece().getColor()) {
            return false;
        }
        int x = Math.abs(curr.getX() - goTo.getX());
        int y = Math.abs(curr.getY() - goTo.getY());
        if (x * y == 2) {
            return true;
        }
        else {
            return false;
        }
    }

    public void draw() {

    }
}
