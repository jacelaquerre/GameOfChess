public class Board {

    public enum Color {white, black}
    public enum Type {pawn, bishop, king, queen, rook, knight}

    private Piece[][] board = new Piece[8][8];

    public Board(){
        create_board();
    }

    public void create_board(){

        // THE CORDINATES FOR EACH PIECE IS INCORRECT RIGHT NOW

        //PAWNS
        for(int c = 0; c < 8; c++){
            Piece pWhite = new Pawn(c, 1, white, pawn, true);
            Piece pBlack = new Pawn(c, 6, black, pawn, true);
            board[c][1] = pWhite;
            board[c][6] = pBlack;
        }

        //KING & QUEEN
        Piece kingWhite = new King(5,0, white, king, true);
        Piece queenWhite = new Queen(4,0, white, queen, true);
        Piece kingBlack = new King(4,7, black, king, true);
        Piece queenBlack = new Queen(5,7, black, queen, true);

        // BISHOP
        Piece bishopWhiteA = new Bishop(2, 0, white, bishop, true);
        Piece bishopWhiteB = new Bishop(5, 0, white, bishop, true);
        Piece bishopBlackA = new Bishop(2, 7, black, bishop, true);
        Piece bishopBlackB = new Bishop(5, 7, black, bishop, true);

        // ROOK
        Piece rookWhiteA = new Rook( 0, 0, white, rook, true);
        Piece rookWhiteB = new Rook(0,7, white, rook, true);
        Piece rookBlackA = new Rook(7,0, black, rook, true);
        Piece rookBlackB = new Rook(7,7, black, rook, true);

        // KNIGHT
        Piece knightWhiteA = new Knight(0,2, white, knight, true);
        Piece knightWhiteB = new Knight(0,5, white, knight, true);
        Piece knightBlackA = new Knight(7,2, black, knight, true);
        Piece knightBlackB = new Knight(7,5, black, knight, true);

        // ADD EACH PIECE TO BOARD[][]
    }
}
