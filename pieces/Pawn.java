public class Pawn extends Piece {
    public Pawn(Color color, boolean alive){
        super(color, alive);
        shape = "\u265f";
    }

    @Override
    public boolean validMove(Box curr, Box goTo) {

        int x = Math.abs(curr.getX() - goTo.getX());
        int y = Math.abs(curr.getY() - goTo.getY());

        // These two if statements account for if it is the pawn's first move
        if (curr.getY() == 6 && (curr.getPiece().getColor() == Piece.Color.BLACK)) {
            return firstMove(y, x, curr, goTo);
        }
        if (curr.getY() == 1 && (curr.getPiece().getColor() == Piece.Color.WHITE)) {
            return firstMove(y, x, curr, goTo);
        }

        if ((y == 1) && (x == 0) && (goTo.getPiece() == null) && (backwardMove(curr, goTo))) {
            return true;
        }
        if ((x == 1 && y == 1) && (goTo.getPiece().getColor() != curr.getPiece().getColor())
                && (backwardMove(curr, goTo))) {
            return true;
        }
        return false;
    }

    // Returns false if the move is forward, true if it is not
    public boolean backwardMove(Box curr, Box goTo) {
        if (curr.getPiece().getColor() == Piece.Color.WHITE && curr.getY() > goTo.getY()) {
            return false;
        }
        else if (curr.getPiece().getColor() == Piece.Color.BLACK && curr.getY() < goTo.getY()) {
            return false;
        } else {
            return true;
        }
    }
    public boolean firstMove(int y, int x, Box curr, Box goTo) {
        if(y == 1) {
            if(x == 0 && goTo.getPiece() == null) {
                return true;
            }
            if(x == 1 && goTo.getPiece().getColor() !=  curr.getPiece().getColor()) {
                return true;
            }

        }
        if (y == 2) {
            if (x == 0 && goTo.getPiece() == null) {
                return true;
            }
        }
        return false;
    }
}
