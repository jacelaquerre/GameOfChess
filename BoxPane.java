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

    public BoxPane(Box b){
        super();
        this.box = b;

        this.setAlignment(Pos.CENTER);
        this.setPrefSize(100,100);
        if((b.getX() + b.getY()) % 2 == 0){
            this.setStyle("-fx-background-color: #DBC69F");
        }
        else{
            this.setStyle("-fx-background-color: #A0815C");
        }

        if(b.getPiece() != null) {
            Text type = new Text(b.getPiece().getShape());
            type.setFont(new Font(50));
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

    /** 160 129 92
     * Method setSelected changes the appearance of the box
     * @param: pressed, box is set as selected is true, set as unselected otherwise
     */
    public void setSelected(boolean pressed){
        this.selected = pressed;
        if(pressed) {
            if ((box.getX() + box.getY()) % 2 == 0) {
                this.setStyle("-fx-background-color: #C8A984");
            } else {
                this.setStyle("-fx-background-color: #876844");
            }
        }
        else {
            if ((box.getX() + box.getY()) % 2 == 0) {
                this.setStyle("-fx-background-color: #DBC69F");
            } else {
                this.setStyle("-fx-background-color: #A0815C");
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

}
