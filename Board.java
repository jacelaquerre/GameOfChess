public class Board {

    public Box[][] board = new Box[7][7];

    public Board() {
        this.create_board();
    }

    public Box[][] getBoard() {
        return board;
    }

    public void setBoard(Box[][] board) {
        this.board = board;
}

    public void create_board(){

        // WHITE PLAYER
        board[0][0] = new Box(new Rook(Piece.Color.WHITE, true), 0, 0);
        board[0][1] = new Box(new Knight(Piece.Color.WHITE, true), 0, 1);
        board[0][2] = new Box(new Bishop(Piece.Color.WHITE, true), 0, 2);
        board[0][3] = new Box(new Queen(Piece.Color.WHITE, true), 0, 3);
        board[0][4] = new Box(new King(Piece.Color.WHITE, true), 0, 4);
        board[0][5] = new Box(new Bishop(Piece.Color.WHITE, true), 0, 5);
        board[0][6] = new Box(new Knight(Piece.Color.WHITE, true), 0, 6);
        board[0][7] = new Box(new Rook(Piece.Color.WHITE, true), 0, 7);
         for(int i = 0; i < 8; ++i) {
             board[1][i] = new Box(new Pawn(Piece.Color.WHITE, true), 1, i);
         }

        // BLACK PLAYER
        board[7][0] = new Box(new Rook(Piece.Color.BLACK, true), 7, 0);
        board[7][1] = new Box(new Knight(Piece.Color.BLACK, true), 7, 1);
        board[7][2] = new Box(new Bishop(Piece.Color.BLACK, true), 7, 2);
        board[7][3] = new Box(new Queen(Piece.Color.BLACK, true), 7, 3);
        board[7][4] = new Box(new King(Piece.Color.BLACK, true), 7, 4);
        board[7][5] = new Box(new Bishop(Piece.Color.BLACK, true), 7, 5);
        board[7][6] = new Box(new Knight(Piece.Color.BLACK, true), 7, 6);
        board[7][7] = new Box(new Rook(Piece.Color.BLACK, true), 7, 7);
        for(int i = 0; i < 8; ++i) {
            board[6][i] = new Box(new Pawn(Piece.Color.BLACK, true), 6, i);
        }

        // Add empty boxes
        for (int i = 2; i < 6; ++i) {
            for (int j = 0; j < 8; ++j) {
                board[i][j] = new Box(null, i, j);
            }
        }
    }
}
