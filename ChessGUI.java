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

import java.util.ArrayList;


public class ChessGUI extends Application {
    private Game game; // The game
    private GridPane grid; // grid of boxes
    private BorderPane main; // main layout
    private Button newGameBtn, endGameBtn;
    private VBox extra, whiteTimer, blackTimer, buttonPane;
    private HBox timers;
    private Text whiteTime, blackTime, label1, label2;
    private int wMins = 10, wSecs = 0, bMins = 10, bSecs = 0;
    private Timeline whiteClockTimeline, blackClockTimeline;
    private ArrayList<BoxPane> selected;

    @Override
    public void start(Stage primaryStage)throws Exception {
        primaryStage.setTitle("Chess");
        // Set up Panes
        main = new BorderPane();
        extra = new VBox(30);
        extra.setStyle("-fx-background-color: #4f5a69;");
        extra.setMinWidth(200);
        extra.setPadding(new Insets(20, 20, 20, 20));
        main.setLeft(extra);
        buttonPane = new VBox(30);
        buttonPane.setPadding(new Insets(20,20,20,20));
        buttonPane.setStyle("-fx-background-color: #7b5954;");
        main.setRight(buttonPane);

        grid = new GridPane();
        grid.setStyle("-fx-background-color:#392f2a;" + "-fx-border-color: #392f2a;" + "-fx-border-width: 10;");

        // Initialize game and draw Board
        game = new Game();
        drawBoard();
        selected = new ArrayList<BoxPane>();
        main.setCenter(grid);

        // New Game Button
        newGameBtn =  new Button("New Game");
        newGameBtn.setOnAction(this::newGame);
        buttonPane.getChildren().add(newGameBtn);

        // End Game Button
        endGameBtn = new Button("End Game");
        endGameBtn.setOnAction(this::handleEnd);
        buttonPane.getChildren().add(endGameBtn);

        // Set up timers
        whiteTime = new Text("10:00");
        whiteClockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeTime(whiteTime, Piece.Color.WHITE);
            }
        }));
        whiteClockTimeline.setCycleCount(Timeline.INDEFINITE);
        whiteClockTimeline.setAutoReverse(false);
        whiteTimer = new VBox(10);
        whiteTimer.setAlignment(Pos.CENTER);
        whiteTimer.setPadding(new Insets(5,5,5,5));
        label1 = new Text("Player 1");
        whiteTimer.getChildren().addAll(label1, whiteTime);

        blackTime = new Text("10:00");
        blackClockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeTime(blackTime, Piece.Color.BLACK);
            }
        }));
        blackClockTimeline.setCycleCount(Timeline.INDEFINITE);
        blackClockTimeline.setAutoReverse(false);
        blackTimer = new VBox(10);
        blackTimer.setAlignment(Pos.CENTER);
        blackTimer.setPadding(new Insets(5,5,5,5));
        label2 = new Text("Player 2");
        blackTimer.getChildren().addAll(label2, blackTime);

        timers = new HBox(10);
        timers.setAlignment(Pos.CENTER);
        timers.setStyle("-fx-background-color: mintcream;"+"-fx-border-width:2;" + "-fx-border-color: black;");
        timers.setPadding(new Insets(10, 10, 10, 10));
        timers.getChildren().addAll(whiteTimer, blackTimer);
        extra.getChildren().add(timers);

        if(game.getCurrentTurn() == game.getWhitePlayer()){
            blackTimer.setStyle("-fx-background-color: mintcream;");
            label2.setStrokeWidth(0);
            blackTime.setFont(new Font(13));

            whiteTimer.setStyle("-fx-background-color: salmon;" + "-fx-border-width:2;"+"-fx-border-color: indianred;");
            label1.setStroke(Color.BLACK);
            label1.setStrokeWidth(.5);
            whiteTime.setFont(new Font(15));
            blackClockTimeline.pause();
            whiteClockTimeline.play();

        }
        else if(game.getCurrentTurn() == game.getBlackPlayer()){
            whiteTimer.setStyle("-fx-background-color: mintcream;");
            label1.setStrokeWidth(0);
            whiteTime.setFont(new Font(13));

            blackTimer.setStyle("-fx-background-color: salmon;" + "-fx-border-width:2;"+"-fx-border-color: indianred;");
            label2.setStroke(Color.BLACK);
            label2.setStrokeWidth(.5);
            blackTime.setFont(new Font(15));
            whiteClockTimeline.pause();
            blackClockTimeline.play();
        }

        // complete setup
        Scene scene = new Scene(main);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Event handling for user clicking Box
     * User should only be able to select one tile. Once another tile is clicked, if it is a valid move,
     * the current piece moves there
     */
    public void handleClick(MouseEvent e){
         BoxPane bp =(BoxPane)(e.getSource());

         // allow a user to un-select the piece
         if(bp.isSelected()){
             bp.setSelected(false);
             selected.remove(bp);
         }
         // if color of piece aligns with current team and no other piece is selected allow click
         else if(bp.getBox().getPiece()!= null && selected.isEmpty()) {
             if (bp.getBox().getPiece().getColor() == Piece.Color.WHITE && game.getCurrentTurn() == game.getWhitePlayer()) {
                 bp.setSelected(true);
                 selected.add(bp);
             } else if (bp.getBox().getPiece().getColor() == Piece.Color.BLACK && game.getCurrentTurn() == game.getBlackPlayer()) {
                 bp.setSelected(true);
                 selected.add(bp);
             }
         }
         // if box is empty or holds an opponent piece check to see if it is a valid move
         else if((bp.getBox().getPiece() == null || bp.getBox().getPiece().getColor() != game.getCurrentTurn().getColor()) && !selected.isEmpty()){
             boolean ans = game.playerMove(game.getCurrentTurn(), selected.get(0).getBox(), bp.getBox());
             if(ans){
                 selected.get(0).setSelected(false);
                 selected.clear();
             }
         }
         // Check if piece is the same color as previously selected piece, if so remove past piece from selected and select new piece
         else if(selected.get(0).getBox().getPiece().getColor() == bp.getBox().getPiece().getColor()){
             selected.get(0).setSelected(false);
             selected.clear();
             selected.add(bp);
             bp.setSelected(true);
         }
    }

    // Event handling for timer running out or ending game
    public void handleEnd(ActionEvent e){
        for(Node pane : grid.getChildren()){
            pane.setOnMouseClicked(null);
        }
        blackClockTimeline.pause();
        whiteClockTimeline.pause();
    }

    // Event Handling for press of new game
    public void newGame(ActionEvent e){
        game = new Game();
        drawBoard();
        bMins = 10;
        bSecs = 0;
        wMins = 10;
        wSecs = 0;
        whiteTime = new Text("10:00");
        blackTime = new Text("10:00");
        whiteClockTimeline.play();
        blackClockTimeline.pause();
    }
    //

    public void changeTime(Text txt, Piece.Color team) {
        if (team == Piece.Color.WHITE){
            if(wSecs == 0) {
                --wMins;
                wSecs = 60;
            }
            txt.setText(((wMins/10 == 0 ? "0" : "")+ wMins) + ":" + (((wSecs/10) == 0) ? "0" : "") + --wSecs);
            if(wMins == 0 && wSecs == 0){
                game.setStatus(Game.GameMode.BLACK_WIN);
                whiteClockTimeline.stop();
            }
        }
        else {
            if(bSecs == 0) {
                --bMins;
                bSecs = 60;
            }
            txt.setText(((bMins/10 == 0 ? "0" : "")+ bMins) + ":" + (((bSecs/10) == 0) ? "0" : "") + --bSecs);
            if(bMins == 0 && bSecs == 0){
                game.setStatus(Game.GameMode.WHITE_WIN);
                blackClockTimeline.stop();
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



