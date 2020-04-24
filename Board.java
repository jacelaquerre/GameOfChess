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

        // BLACK PLAYER
        board[0][7] = new Box(new Rook(Piece.Color.BLACK, true), 0, 7);
        board[1][7] = new Box(new Knight(Piece.Color.BLACK, true), 1, 7);
        board[2][7] = new Box(new Bishop(Piece.Color.BLACK, true), 2, 7);
        board[3][7] = new Box(new Queen(Piece.Color.BLACK, true), 3, 7);
        board[4][7] = new Box(new King(Piece.Color.BLACK, true), 4, 7);
        board[5][7] = new Box(new Bishop(Piece.Color.BLACK, true), 5, 7);
        board[6][7] = new Box(new Knight(Piece.Color.BLACK, true), 6, 7);
        board[7][7] = new Box(new Rook(Piece.Color.BLACK, true), 7, 7);
         for(int i = 0; i < 8; ++i) {
             board[i][6] = new Box(new Pawn(Piece.Color.BLACK, true), i, 6);
         }

        // WHITE PLAYER
        board[0][0] = new Box(new Rook(Piece.Color.WHITE, true), 0, 0);
        board[1][0] = new Box(new Knight(Piece.Color.WHITE, true), 1, 0);
        board[2][0] = new Box(new Bishop(Piece.Color.WHITE, true), 2, 0);
        board[3][0] = new Box(new Queen(Piece.Color.WHITE, true), 3, 0);
        board[4][0] = new Box(new King(Piece.Color.WHITE, true), 4, 0);
        board[5][0] = new Box(new Bishop(Piece.Color.WHITE, true), 5, 0);
        board[6][0] = new Box(new Knight(Piece.Color.WHITE, true), 6, 0);
        board[7][0] = new Box(new Rook(Piece.Color.WHITE, true), 7, 0);
        for(int i = 0; i < 8; ++i) {
            board[i][1] = new Box(new Pawn(Piece.Color.WHITE, true), i, 1);
        }

        // Add empty boxes
        for (int i = 0; i < 8; ++i) {
            for (int j = 2; j < 6; ++j) {
                board[i][j] = new Box(null, i, j);
            }
        }
    }

    public Box getBox(int x, int y){
        return board[x][y];
    }

    public String getFen(String turn) {
        String fen = "";
        for(int i = board.length - 1; i >= 0; i--) {
            int num = 0;
            for(int j = 0; j < board[0].length; j++) {
                if(board[j][i].getPiece() != null && num != 0) {
                    fen += num;
                    num = 0;
                }
                if(board[j][i].getPiece() instanceof Pawn) {
                    if(board[j][i].getPiece().getColor() == Piece.Color.WHITE) {
                        fen += "P";
                    } else {
                        fen += "p";
                    }
                }
                else if(board[j][i].getPiece() instanceof Rook) {
                    if(board[j][i].getPiece().getColor() == Piece.Color.WHITE) {
                        fen += "R";
                    } else {
                        fen += "r";
                    }
                }
                else if(board[j][i].getPiece() instanceof Knight) {
                    if(board[j][i].getPiece().getColor() == Piece.Color.WHITE) {
                        fen += "N";
                    } else {
                        fen += "n";
                    }
                }
                else if(board[j][i].getPiece() instanceof Bishop) {
                    if(board[j][i].getPiece().getColor() == Piece.Color.WHITE) {
                        fen += "B";
                    } else {
                        fen += "b";
                    }
                }
                else if(board[j][i].getPiece() instanceof Queen) {
                    if(board[j][i].getPiece().getColor() == Piece.Color.WHITE) {
                        fen += "Q";
                    } else {
                        fen += "q";
                    }
                }
                else if(board[j][i].getPiece() instanceof King) {
                    if(board[j][i].getPiece().getColor() == Piece.Color.WHITE) {
                        fen += "K";
                    } else {
                        fen += "k";
                    }
                }
                else {
                    num++;
                }
            }
            if(num != 0) {
                fen += num;
                num = 0;
            }
            fen += "/";
        }
        fen += " " + turn;
        fen += " -";
        fen += " 0";
        fen += " 1";
        return fen;
    }
}
