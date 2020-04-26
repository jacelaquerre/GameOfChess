public class Knight extends Piece {
    public Knight(Color color, boolean alive){
        super(color, alive);
        shape = "\u265e";
    }

    @Override
    public boolean validMove(Box curr, Box goTo) {
        int x = Math.abs(curr.getX() - goTo.getX());
        int y = Math.abs(curr.getY() - goTo.getY());
        return x * y == 2;
    }
}
