import javafx.scene.layout.HBox;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.geometry.Pos;
import java.util.Optional;

public class Box{
    private Piece piece;
    private int x;
    private int y;

    public Box(Piece piece, int x, int y) {
        super();
        this.x = x;
        this.y = y;

        if(piece != null) {
            this.piece = piece;
        }
    }


    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
