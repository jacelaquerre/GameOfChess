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
    private Board board;
    private GridPane grid; // grid of boxes
    private BorderPane main; // main layout

    @Override
    public void start(Stage primaryStage)throws Exception {
        // Set up Panes
        main = new BorderPane();
        grid = new GridPane();

        // Initialize game and draw Board
        board = new Board();
        drawBoard();

        // Complete set up
        primaryStage.setTitle("Chess");
        Scene scene = new Scene(main);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Event handling for user clicking Box

    // Draws the board
    public void drawBoard() {
        grid.getChildren().clear();
        Box[][] boxes = board.getBoard();
        for (int x=0; x < 8; ++x) {
            for (int y = 0; y <8; y++) {
                grid.add(boxes[x][y],x,y);
            }
        }
    }

    public static void main(String [] args)
    {
        launch(args);
    }
}



