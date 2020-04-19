/**
 * Chess Game GUI
 * Interactive display for Chess game
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.Animation;
import javafx.scene.shape.*;
import javafx.util.Duration;
import javafx.scene.control.TextField;


public class ChessGUI extends Application {
    private Game game;
    private GridPane grid; // grid of boxes
    private BorderPane main; // main layout

    @Override
    public void start(Stage primaryStage)throws Exception {
        primaryStage.setTitle("Chess");
        // Set up Panes
        main = new BorderPane();
        grid = new GridPane();

        // Initialize game and draw Board
        game = new Game();
        drawBoard();
        main.setCenter(grid);

        // complete setup
        Scene scene = new Scene(main);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Event handling for user clicking Box
    // User should only be able to select one tile. Once another tile is clicked, if it is a valid move,
    // the current piece moves there
    public void handleClick(MouseEvent e){
         BoxPane bp =(BoxPane)(e.getSource());

         // allow a user to un-select the piece
         if(bp.isSelected()){
             bp.setSelected(false);
         }
         else if(bp.getBox().getPiece()!= null){
             // if color of piece aligns with current team allow click
             if (bp.getBox().getPiece().getColor() == Piece.Color.WHITE && game.getCurrentTurn() == game.getWhitePlayer()) {
                 bp.setSelected(true);
             } else if (bp.getBox().getPiece().getColor() == Piece.Color.BLACK && game.getCurrentTurn() == game.getBlackPlayer()) {
                 bp.setSelected(true);
             }
         }

    }

    // Draws the board
    public void drawBoard() {
        grid.getChildren().clear(); // clears the board
        for (int r = 0; r < 8; ++r) {
            for (int c = 0; c <8; c++) {
                BoxPane bp = new BoxPane(game.getBoard(),r,c);
                bp.setOnMouseClicked(this::handleClick);
                grid.add(bp,r,c);
            }
        }
    }

    public static void main(String [] args)
    {
        launch(args);
    }
}



