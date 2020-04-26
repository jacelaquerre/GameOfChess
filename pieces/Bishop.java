public class Bishop extends Piece {

    public Bishop(Color color, boolean alive) {
        super(color, alive);
        this.shape = "\u265d";
    }

    @Override
    public boolean validMove(Box curr, Box goTo) {
        int x = Math.abs(curr.getX() - goTo.getX());
        int y = Math.abs(curr.getY() - goTo.getY());
        return x / y == 1;
    }

}
