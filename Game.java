public class Game {

    public enum GameMode {
        ACTIVE,
        BLACK_WIN,
        WHITE_WIN,
        TIE
    }
    private Board board;
    public GameMode status;
    public Player whitePlayer = new Player(Piece.Color.WHITE, true, false);
    public Player blackPlayer = new Player(Piece.Color.BLACK, false, false);
    public Player currentTurn;
    public Box start;
    public Box end;
    private Piece pieceMoved;
    private Piece pieceKilled;

    Stockfish stockfish = new Stockfish();

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

    // This function initializes the game
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

    // This function provides logic for the game
    // Moving Pieces, determining winners, back-and-forth between players
    public boolean playerMove(Player currPlayer, Box start, Box end) {
        pieceMoved = start.getPiece();
        // Check if the move is valid
        if (pieceMoved.validMove(start, end)) {
            // Check if the end Box has a Piece or not
            if (end.getPiece() != null) {
                if (end.getPiece().getColor() != pieceMoved.getColor()) {
                    pieceKilled = end.getPiece();
                    pieceKilled.setAlive(false);
                    // Check if the Piece killed is a King
                    if (pieceKilled instanceof King) {
                        // Set winner and end game
                        if (currPlayer == whitePlayer) {
                            status = GameMode.WHITE_WIN;
                            whitePlayer.setWinner(true);
                        } else {
                            status = GameMode.BLACK_WIN;
                            blackPlayer.setWinner(true);
                        }
                    }
                }
            }
            // Move Piece and make last Box null
            end.setPiece(pieceMoved);
            pieceKilled = null;
            start.setPiece(null);
            // Switch which players turn it is
            if (currPlayer == whitePlayer) {
                currentTurn = blackPlayer;
                blackPlayer.setTurn(true);
                whitePlayer.setTurn(false);
            } else {
                currentTurn = whitePlayer;
                blackPlayer.setTurn(false);
                whitePlayer.setTurn(true);
            }
            getAiMove("b");
            return true;
        }
        return false;
    }

    //returns an array with length 4
    //[initial board x, initial board y, final board x, final board y]
    //takes in a string for which side to make the move for
    //b for black w for white
    public int[] getAiMove(String side) {
        if(System.getProperty("os.name").startsWith("Windows")) {
            stockfish.startEngine("./stockfish_windows.exe"); // should be moved to only called once
        } else {
            stockfish.startEngine("stockfish_mac"); // should be moved to only called once
        }

        String move = stockfish.getBestMove(board.getFen(side), 20); //b makes tells ai to make a move for black

        int startX = ((int)(move.charAt(0)) - 97);
        int startY = ((int)(move.charAt(1)) - 49);
        int endX = ((int)(move.charAt(2)) - 97);
        int endY = ((int)(move.charAt(3)) - 49);
        int[] moves = {startX, startY, endX, endY};

        return moves;
    }

    // Function to take in timer, if game is too long, set as tie
    public boolean isTie() {
        return false;
    }
}
