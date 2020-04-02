public class Piece {
    public enum Color {white, black}
    public enum Type {pawn, bishop, king, queen, rook, knight}

    private int x;
    private int y;
    private Color color;
    private Type type;
    public boolean alive;

    public Piece(int x, int y, Color color, Type type, boolean alive){
        this.x = x;
        this.y = y;
        this.color = color;
        this.type = type;
        this.alive = alive;
    }

    public void movePiece(int x, int y) {
        this.x = x;
        this.y = y;
    }

// SETTERS
    public void set_x(int x){
        this.x = x;
    }
    public void set_y(int y){
        this.y = y;
    }
    public void set_color(Color color){
        this.color = color;
    }
    public void set_type(Type type){
        this.type = type;
    }

// GETTERS
    public int get_y(){
        return this.y;
    }
    public int get_x(){
        return this.x;
    }
    public Color get_color(){
        return this.color;
    }
    public Type get_type(){
        return this.type;
    }
}
