public class King extends Piece {

    public King(Color color, boolean alive){
        super(color, alive);
        shape = "\u265a";
    }

    @Override
    public boolean validMove(Box curr, Box goTo) {
        int x = Math.abs(curr.getX() - goTo.getX());
        int y = Math.abs(curr.getY() - goTo.getY());
        if (x + y == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean inCheckmate() {
        return false;
    }
}


