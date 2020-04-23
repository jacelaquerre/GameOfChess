import javafx.scene.layout.HBox;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.geometry.Pos;
import java.util.Optional;

public class BoxPane  extends HBox{
    private Box box;
    private boolean selected;
    private Text type;

    public BoxPane(Box b){
        super();
        this.box = b;

        this.setAlignment(Pos.CENTER);
        this.setPrefSize(100,100);
        if((b.getX() + b.getY()) % 2 == 0){
            this.setStyle("-fx-background-color: #534437;");
        }
        else{
            this.setStyle("-fx-background-color: #e7c79f;");
        }

        if(b.getPiece() != null) {
            type = new Text(b.getPiece().getShape());
            type.setFont(new Font(50));
            if(box.getPiece().getColor() == Piece.Color.WHITE) {
                type.setStyle("-fx-fill: white;");
            }
        }
        else{
            type = new Text("");
            type.setFont(new Font(50));
        }
        this.getChildren().add(type);
    }

    /**
     * BoxPane constructor creates an instance of a box pane
     * @param b Board object
     * @param row of box
     * @param col of box
     */
    public BoxPane(Board b, int row, int col){
        this(b.getBox(row,col));
    }

    /**
     * Method setSelected changes the appearance of the box
     * @param: pressed, box is set as selected is true, set as unselected otherwise
     */
    public void setSelected(boolean pressed){
        this.selected = pressed;
        if(pressed) {
            if ((box.getX() + box.getY()) % 2 == 0) {
                this.setStyle("-fx-background-color: #392f2a;");
            } else {
                this.setStyle("-fx-background-color: #a68b67;");
            }
        }
        else {
            if ((box.getX() + box.getY()) % 2 == 0) {
                this.setStyle("-fx-background-color: #534437;");
            } else {
                this.setStyle("-fx-background-color: #e7c79f;");
            }
        }
    }

    public boolean isSelected() {
        return selected;
    }

    public Box getBox(){
        return box;
    }

    public int getRow(){
        return box.getX();
    }

    public int getCol() {
        return box.getY();
    }

    public void updated(){
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(100,100);
        if((box.getX() + box.getY()) % 2 == 0){
            this.setStyle("-fx-background-color: #534437;");
        }
        else{
            this.setStyle("-fx-background-color: #e7c79f;");
        }

        if(box.getPiece() != null) {
            type = new Text(box.getPiece().getShape());
            type.setFont(new Font(50));
            if(box.getPiece().getColor() == Piece.Color.WHITE) {
                type.setStyle("-fx-fill: white;");
            }
        }
        else{
            type = new Text("");
            type.setFont(new Font(50));
        }
        this.getChildren().clear();
        this.getChildren().add(type);

    }

}
