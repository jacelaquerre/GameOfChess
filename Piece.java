public class Piece {
    public enum Color {white, black}
    public enum Type {pawn, bishop, king, queen, rook, knight}

    private int x;
    private int y;
    private Color color;
    private Type type;

    Piece(int x, int y, Color color, Type type){
        this.x = x;
        this.y = y;
        this.color = color;
        this.type = type;
    }

    public void set_x(int x){
        this.x = x;
    }

    public void set_y(int y){
        this.y = y;
    }
}
