public class Pawn extends Piece {
    public Pawn(Color color, boolean alive){
        super(color, alive);
    }

    public boolean validMove(Box curr, Box goTo) {
        // Check if box has piece of same color
        if (curr.getPiece().getColor() == goTo.getPiece().getColor()) {
            return false;
        }
        int x = Math.abs(curr.getX() - goTo.getX());
        int y = Math.abs(curr.getY() - goTo.getY());
        if(color == white && curr.getX() < goTo.getX()) {
            return false;
        }
        if(color == black && curr.getX() > goTo.getX()) {
            return false;
        }
        if(curr.getY == 1) {
            if(y == 2 || y == 1) {
                if(x == 1 && goTo.getPiece().getColor() !=  curr.getPiece().getColor()) {
                    return true;
                }
                if(x == 0 && goTo.getPiece() == null) {
                    return true;
                }
            }
        }
        if(x == 1 && goTo.getPiece().getColor() ==  black) {
            return true;
        }
        if(x == 0 && goTo.getPiece() == null) {
            return true;
        }
        return false;
    }

    public void draw() {

    }
}
