public class Player {

    private Piece.Color color;
    private boolean turn;
    private boolean winner;

    public Player(Piece.Color color, boolean turn, boolean winner) {
        this.color = color;
        this.turn = turn;
        this.winner = winner;
    }

    public Piece.Color getColor() {
        return color;
    }

    public void setColor(Piece.Color color) {
        this.color = color;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
