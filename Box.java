import javafx.scene.layout.HBox;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.geometry.Pos;
import java.util.Optional;

public class Box extends HBox {
    private Piece piece;
    private int x;
    private int y;

    public Box(Piece piece, int x, int y) {
        super();
        this.x = x;
        this.y = y;

        this.setAlignment(Pos.CENTER);
        this.setPrefSize(100,100);
        if(x + y % 2 == 0){
            this.setStyle("-fx-background-color: rgb(.7373, .6196,.4863)");
        }
        else{
            this.setStyle("-fx-background-color: rgb(.4, .314, .239)");
        }

        if(piece != null) {
            this.piece = piece;
            Text type = new Text(piece.getShape());
            type.setFont(new Font(30));
            this.getChildren().add(type);
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
