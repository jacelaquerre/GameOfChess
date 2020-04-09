public class Board {


    private Piece[][] board = new Piece[8][8];

    public Board(){
        create_board();
    }

    public void create_board(){

        // THE CORDINATES FOR EACH PIECE IS INCORRECT RIGHT NOW

        //PAWNS
        for(int c = 0; c < 8; c++){
            Piece pWhite = new Pawn(c, 1, Piece.Color.white, Piece.Type.pawn, true);
            Piece pBlack = new Pawn(c, 6, Piece.Color.black, Piece.Type.pawn, true);
            board[c][1] = pWhite;
            board[c][6] = pBlack;
        }

        //KING & QUEEN
        Piece kingWhite = new King(5,0, Piece.Color.white, Piece.Type.king, true);
        Piece queenWhite = new Queen(4,0, Piece.Color.white, Piece.Type.queen, true);
        Piece kingBlack = new King(4,7, Piece.Color.black, Piece.Type.king, true);
        Piece queenBlack = new Queen(5,7, Piece.Color.black, Piece.Type.queen, true);

        // BISHOP
        Piece bishopWhiteA = new Bishop(2, 0, Piece.Color.white, Piece.Type.bishop, true);
        Piece bishopWhiteB = new Bishop(5, 0, Piece.Color.white, Piece.Type.bishop, true);
        Piece bishopBlackA = new Bishop(2, 7, Piece.Color.black, Piece.Type.bishop, true);
        Piece bishopBlackB = new Bishop(5, 7, Piece.Color.black, Piece.Type.bishop, true);

        // ROOK
        Piece rookWhiteA = new Rook( 0, 0, Piece.Color.white, Piece.Type.rook, true);
        Piece rookWhiteB = new Rook(0,7, Piece.Color.white, Piece.Type.rook, true);
        Piece rookBlackA = new Rook(7,0, Piece.Color.black, Piece.Type.rook, true);
        Piece rookBlackB = new Rook(7,7, Piece.Color.black, Piece.Type.rook, true);

        // KNIGHT
        Piece knightWhiteA = new Knight(0,2, Piece.Color.white, Piece.Type.knight, true);
        Piece knightWhiteB = new Knight(0,5, Piece.Color.white, Piece.Type.knight, true);
        Piece knightBlackA = new Knight(7,2, Piece.Color.black, Piece.Type.knight, true);
        Piece knightBlackB = new Knight(7,5, Piece.Color.black, Piece.Type.knight, true);

        // ADD EACH PIECE TO BOARD[][]
    }
}
