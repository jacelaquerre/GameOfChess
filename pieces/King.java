public class King extends Piece {

    public King(Color color, boolean alive){
        super(color, alive);
        if (color == Piece.Color.WHITE) {
            shape = "\u2654";
        }
        else{
            shape = "\u265a";
        }
    }

    public boolean validMove(Box curr, Box goTo) {
        // Check if box has piece of same color
        if (curr.getPiece().getColor() == goTo.getPiece().getColor()) {
            return false;
        }
        int x = Math.abs(curr.getX() - goTo.getX());
        int y = Math.abs(curr.getY() - goTo.getY());
        if (x + y == 1) {
            if (goTo.getPiece().getColor() == curr.getPiece().getColor()) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }
}


