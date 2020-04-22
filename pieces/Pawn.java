public class Pawn extends Piece {
    public Pawn(Color color, boolean alive){
        super(color, alive);
        shape = "\u265f";
    }

    @Override
    public boolean validMove(Box curr, Box goTo) {
        // Check if box has piece of same color
//        if (curr.getPiece().getColor() == goTo.getPiece().getColor()) {
//            return false;
//        }
        int x = Math.abs(curr.getX() - goTo.getX());
        int y = Math.abs(curr.getY() - goTo.getY());
        if(curr.getPiece().getColor() == Piece.Color.WHITE && curr.getX() < goTo.getX()) {
            return false;
        }
        if(curr.getPiece().getColor() == Piece.Color.BLACK && curr.getX() > goTo.getX()) {
            return false;
        }
        if(curr.getY() == 1) {
            if(y == 2 || y == 1) {
                if(x == 1 && goTo.getPiece().getColor() !=  curr.getPiece().getColor()) {
                    return true;
                }
                if(x == 0 && goTo.getPiece() == null) {
                    return true;
                }
            }
        }
        if(x == 1 && goTo.getPiece().getColor() ==  Piece.Color.BLACK) {
            return true;
        }
        if(x == 0 && goTo.getPiece() == null) {
            return true;
        }
        return false;
    }

}
