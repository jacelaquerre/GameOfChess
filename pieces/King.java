public class King extends Piece {

    public King(Color color, boolean alive){
        super(color, alive);
        shape = "\u265a";
    }

    @Override
    public boolean validMove(Box curr, Box goTo) {
        int x = Math.abs(curr.getX() - goTo.getX());
        int y = Math.abs(curr.getY() - goTo.getY());
        return (x + y == 1) || (x == 1 && y == 1);
    }

    public boolean inCheckmate() {
        return false;
    }
}


