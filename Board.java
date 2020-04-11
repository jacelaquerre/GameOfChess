public class Board {

    public Box[][] board = new Box[8][8];

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
        board[0][0] = new Box(new Rook(Piece.Color.white, true), 0, 0);
        board[0][1] = new Box(new Knight(Piece.Color.white, true), 0, 1);
        board[0][2] = new Box(new Bishop(Piece.Color.white, true), 0, 2);
        board[0][3] = new Box(new Rook(Piece.Color.white, true), 0, 3);
        board[0][4] = new Box(new Queen(Piece.Color.white, true), 0, 4);
        board[0][5] = new Box(new King(Piece.Color.white, true), 0, 5);
        board[0][6] = new Box(new Bishop(Piece.Color.white, true), 0, 6);
        board[0][7] = new Box(new Knight(Piece.Color.white, true), 0, 7);
        board[0][8] = new Box(new Rook(Piece.Color.white, true), 0, 8);
         for(int i = 0; i < 8; ++i) {
             board[1][i] = new Box(new Pawn(Piece.Color.white, true), 1, i);
         }

        // BLACK PLAYER
        board[8][0] = new Box(new Rook(Piece.Color.black, true), 8, 0);
        board[8][1] = new Box(new Knight(Piece.Color.black, true), 8, 1);
        board[8][2] = new Box(new Bishop(Piece.Color.black, true), 8, 2);
        board[8][3] = new Box(new Rook(Piece.Color.black, true), 8, 3);
        board[8][4] = new Box(new Queen(Piece.Color.black, true), 8, 4);
        board[8][5] = new Box(new King(Piece.Color.black, true), 8, 5);
        board[8][6] = new Box(new Bishop(Piece.Color.black, true), 8, 6);
        board[8][7] = new Box(new Knight(Piece.Color.black, true), 8, 7);
        board[8][8] = new Box(new Rook(Piece.Color.black, true), 8, 8);
        for(int i = 0; i < 8; ++i) {
            board[7][i] = new Box(new Pawn(Piece.Color.black, true), 7, i);
        }

        // Add empty spots
        for (int i = 2; i < 6; ++i) {
            for (int j = 0; j < 8; ++j) {
                board[i][j] = new Box(null, i, j);
            }
        }
    }
}
