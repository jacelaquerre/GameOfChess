public class Game {

    public enum GameMode {
        ACTIVE,
        BLACK_WIN,
        WHITE_WIN,
        TIE
    }
    private Board board;
    public  GameMode status;
    public  Player whitePlayer = new Player(Piece.Color.WHITE, true, false);
    public  Player blackPlayer = new Player(Piece.Color.BLACK, false, false);
    public Player currentTurn;
    public Box start;
    public Box end;
    private Piece pieceMoved;
    private Piece pieceKilled;

    public Game(){
        this.startGame();
    }

    public Game(Board board, GameMode status, Player currentTurn, Box start, Box end, Piece pieceMoved, Piece pieceKilled) {
        this.board = board;
        this.status = status;
        this.currentTurn = currentTurn;
        this.start = start;
        this.end = end;
        this.pieceMoved = pieceMoved;
        this.pieceKilled = pieceKilled;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameMode getStatus() {
        return status;
    }

    public void setStatus(GameMode status) {
        this.status = status;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public void setWhitePlayer(Player whitePlayer) {
        this.whitePlayer = whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    public void setBlackPlayer(Player blackPlayer) {
        this.blackPlayer = blackPlayer;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Player currentTurn) {
        this.currentTurn = currentTurn;
    }

    public Box getStart() {
        return start;
    }

    public void setStart(Box start) {
        this.start = start;
    }

    public Box getEnd() {
        return end;
    }

    public void setEnd(Box end) {
        this.end = end;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }

    public void startGame() {
        status = GameMode.ACTIVE;
        Player black = blackPlayer;
        Player white = whitePlayer;

        board = new Board();
        board.create_board();

        if (white.isTurn()) {
            this.currentTurn = white;
        }
        else {
            this.currentTurn = black;
        }
    }

    public boolean playerMove(Player player, Box start, Box end) {
        pieceMoved = start.getPiece();
        //if (pieceMoved.validMove()) {
        //}
        return false;
    }
}
