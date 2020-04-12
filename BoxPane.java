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

    public BoxPane(Box b){
        super();
        this.box = b;

        this.setAlignment(Pos.CENTER);
        this.setPrefSize(100,100);
        if((b.getX() + b.getY()) % 2 == 0){
            this.setStyle("-fx-background-color: rgb(.7373, .6196,.4863)");
        }
        else{
            this.setStyle("-fx-background-color: rgb(.4, .314, .239)");
        }

        if(b.getPiece() != null) {
            Text type = new Text(b.getPiece().getShape());
            type.setFont(new Font(30));
            this.getChildren().add(type);
        }
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

}
