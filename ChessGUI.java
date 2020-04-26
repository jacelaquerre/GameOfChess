/*
  Chess Game GUI
  Interactive display for Chess game
 */

import javafx.application.Application;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
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
import javafx.util.Duration;

import java.util.ArrayList;

// TODO: Find out why second scene is moved off center and correct it
public class ChessGUI extends Application {
    private Game game; // The game
    private GridPane gameBoard; // grid of boxes
    private VBox whiteTimer, blackTimer, entryPane;
    private HBox computerGame, playerGame;
    private Text whiteTime, blackTime;
    private Text whiteLabel, blackLabel;
    private Text endingMessage;
    private int wMins = 10, wSecs = 0, bMins = 10, bSecs = 0;
    private Timeline whiteClockTimeline, blackClockTimeline, aiMove;
    private ArrayList<BoxPane> selected;
    private Scene gameScene, activeScene;
    private Boolean p1vp2; // Whether or not the game is player 1 vs. player 2
    private Piece.Color choice; // color user chooses to play as

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chess Game");

        /* *******************************       Entry Scene      ******************************************* */
        Text computerGameLabel = new Text("Player 1\nvs.\nComputer");
        Text playerGameLabel = new Text("Player 1\nvs.\nPlayer 2");
        computerGameLabel.setTextAlignment(TextAlignment.CENTER);
        computerGameLabel.setFont(new Font(20));
        computerGameLabel.setFill(Paint.valueOf("#eeeeee"));
        playerGameLabel.setTextAlignment(TextAlignment.CENTER);
        playerGameLabel.setFont(new Font(20));
        playerGameLabel.setFill(Paint.valueOf("#eeeeee"));
        Text entryTitle = new Text(" New Game? ");
        entryTitle.setFont(new Font(50));
        entryTitle.setFill(Paint.valueOf("#35414a"));
        computerGame = new HBox();
        computerGame.setAlignment(Pos.CENTER);
        computerGame.setStyle("-fx-background-color: #35414a;");
        computerGame.setOnMouseEntered(new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                computerGame.setStyle("-fx-background-color: #6d7c7b;" + "-fx-border-color: #d88888;" + "-fx-border-width: 5");
            }
        });
        computerGame.setOnMouseExited(new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                computerGame.setStyle("-fx-background-color: #35414a;");

            }
        });
        playerGame = new HBox();
        playerGame.setAlignment(Pos.CENTER);
        playerGame.setStyle("-fx-background-color: #35414a;");
        playerGame.setOnMouseEntered(new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                playerGame.setStyle("-fx-background-color: #6d7c7b;" + "-fx-border-color: #d88888;" + "-fx-border-width: 5");
            }
        });
        playerGame.setOnMouseExited(new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                playerGame.setStyle("-fx-background-color: #35414a;");

            }
        });
        computerGame.getChildren().add(computerGameLabel);
        playerGame.getChildren().add(playerGameLabel);
        computerGame.setPadding(new Insets(10,10,10,10));
        computerGame.setMinSize(120,120);
        playerGame.setPadding(new Insets(10,10,10,10));
        playerGame.setMinSize(120,120);
        HBox buttons = new HBox(30);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(10,10,10,10));
        buttons.getChildren().addAll(computerGame, playerGame);

        computerGame.setOnMouseClicked(new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                p1vp2 = false;
                Text prompt = new Text("");
                prompt.setFont(new Font(50));
                prompt.setTextAlignment(TextAlignment.CENTER);

                HBox blackBox = new HBox();
                blackBox.setAlignment(Pos.CENTER);
                blackBox.setStyle("-fx-background-color: black;");
                Text blackL = new Text("Black?");
                blackL.setTextAlignment(TextAlignment.CENTER);
                blackL.setFont(new Font(30));
                blackL.setStyle("-fx-fill: white;");
                blackBox.getChildren().add(blackL);
                blackBox.setPadding(new Insets(10, 10, 10, 10));
                blackBox.setMinSize(120, 120);
                blackBox.setOnMouseEntered(new EventHandler<>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        blackBox.setStyle("-fx-background-color: grey;");
                        //blackL.setStyle("-fx-fill: black;");
                    }
                });
                blackBox.setOnMouseExited(new EventHandler<>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        blackBox.setStyle("-fx-background-color: black;");
                        //blackL.setStyle("-fx-fill: white;");
                    }
                });
                blackBox.setOnMouseClicked(new EventHandler<>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        primaryStage.setScene(gameScene);
                        activeScene = gameScene;
                        choice = Piece.Color.BLACK;
                        aiMove.play();
                        whiteClockTimeline.play();
                    }
                });

                HBox whiteBox = new HBox();
                whiteBox.setAlignment(Pos.CENTER);
                whiteBox.setStyle("-fx-background-color: white");
                Text whiteL = new Text("White?");
                whiteL.setTextAlignment(TextAlignment.CENTER);
                whiteL.setFont(new Font(30));
                whiteL.setStyle("-fx-fill: black;");
                whiteBox.getChildren().add(whiteL);
                whiteBox.setPadding(new Insets(10, 10, 10, 10));
                whiteBox.setMinSize(120, 120);
                whiteBox.setOnMouseEntered(new EventHandler<>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        whiteBox.setStyle("-fx-background-color: grey;");
                    }
                });
                whiteBox.setOnMouseExited(new EventHandler<>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        whiteBox.setStyle("-fx-background-color: white;");
                    }
                });
                whiteBox.setOnMouseClicked(new EventHandler<>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        primaryStage.setScene(gameScene);
                        activeScene = gameScene;
                        choice = Piece.Color.WHITE;
                        aiMove.play();
                        whiteClockTimeline.play();
                    }
                });

                buttons.getChildren().clear();
                buttons.getChildren().addAll(blackBox, whiteBox);

                entryPane.getChildren().clear();
                entryPane.getChildren().addAll(prompt, buttons);

            }
        });
        playerGame.setOnMouseClicked(new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                p1vp2 = true;
                primaryStage.setScene(gameScene);
                activeScene = gameScene;
                whiteClockTimeline.play();
            }
        });

        entryPane = new VBox(30);
        entryPane.setStyle("-fx-background-color: #ffe7d9;");
        entryPane.getChildren().addAll(entryTitle, buttons);
        //entryPane.setMinSize(200,200);
        Scene entryScene = new Scene(entryPane);
        activeScene = entryScene;

        /* *******************************       Main Scene      ******************************************* */
        // Set up Panes
        // main layout
        BorderPane main = new BorderPane();
        VBox extra = new VBox(30);
        extra.setStyle("-fx-background-color: #4f5a69;");
        extra.setMinWidth(200);
        extra.setPadding(new Insets(20, 20, 20, 20));
        main.setLeft(extra);
        VBox buttonPane = new VBox(30);
        buttonPane.setPadding(new Insets(20,20,20,20));
        buttonPane.setStyle("-fx-background-color: #7b5954;");
        main.setRight(buttonPane);

        gameBoard = new GridPane();
        gameBoard.setStyle("-fx-background-color:#392f2a;" + "-fx-border-color: #392f2a;" + "-fx-border-width: 10;");

        // Initialize game and draw Board
        game = new Game();
        drawBoard();
        selected = new ArrayList<>();
        main.setCenter(gameBoard);

        // New Game Button
        Button newGameBtn = new Button("New Game");
        newGameBtn.setOnAction(this::newGame);
        buttonPane.getChildren().add(newGameBtn);

        // End Game Button
        Button endGameBtn = new Button("End Game");
        endGameBtn.setOnMouseClicked(this::handleEnd);
        buttonPane.getChildren().add(endGameBtn);

        // Set up timers
        whiteTime = new Text("10:00");
        whiteClockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                changeTime(whiteTime, Piece.Color.WHITE);
                checkPlayerStatus();
            }
        }));
        whiteClockTimeline.setCycleCount(Timeline.INDEFINITE);
        whiteClockTimeline.setAutoReverse(false);
        whiteTimer = new VBox(10);
        whiteTimer.setAlignment(Pos.CENTER);
        whiteTimer.setPadding(new Insets(5,5,5,5));
        whiteLabel = new Text("Player 1");
        whiteTimer.getChildren().addAll(whiteLabel, whiteTime);

        blackTime = new Text("10:00");
        blackClockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                changeTime(blackTime, Piece.Color.BLACK);
                checkPlayerStatus();
            }
        }));
        blackClockTimeline.setCycleCount(Timeline.INDEFINITE);
        blackClockTimeline.setAutoReverse(false);
        blackTimer = new VBox(10);
        blackTimer.setAlignment(Pos.CENTER);
        blackTimer.setPadding(new Insets(5,5,5,5));
        blackLabel = new Text("Player 2");
        blackTimer.getChildren().addAll(blackLabel, blackTime);

        HBox timers = new HBox(10);
        timers.setAlignment(Pos.CENTER);
        timers.setStyle("-fx-background-color: #d1e5eb;" + "-fx-border-width:5;" + "-fx-border-color: #727a87;");
        timers.setPadding(new Insets(10, 10, 10, 10));
        timers.getChildren().addAll(whiteTimer, blackTimer);
        extra.getChildren().add(timers);
        checkPlayerStatus();

        aiMove = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                if (choice == Piece.Color.WHITE && game.getCurrentTurn().getColor() == Piece.Color.BLACK) {
                    int[] move = game.getAiMove("b");
                    game.playerMove(game.getBlackPlayer(), game.getBoard().getBox(move[0], move[1]), game.getBoard().getBox(move[2], move[3]));
                    for (Node p : gameBoard.getChildren()) {
                        BoxPane bp = (BoxPane) (p);
                        if (bp.getCol() == move[1] && bp.getRow() == move[0]) {
                            bp.updated();
                        } else if (bp.getCol() == move[3] && bp.getRow() == move[2]) {
                            bp.updated();
                        }
                    }
                }

                if (choice == Piece.Color.BLACK && game.getCurrentTurn().getColor() == Piece.Color.WHITE) {
                    int[] move = game.getAiMove("w");
                    game.playerMove(game.getWhitePlayer(), game.getBoard().getBox(move[0], move[1]), game.getBoard().getBox(move[2], move[3]));
                    for (Node p : gameBoard.getChildren()) {
                        BoxPane bp = (BoxPane) (p);
                        if (bp.getCol() == move[1] && bp.getRow() == move[0]) {
                            bp.updated();
                        } else if (bp.getCol() == move[3] && bp.getRow() == move[2]) {
                            bp.updated();
                        }
                    }
                }
            }
        }));
        aiMove.setCycleCount(Timeline.INDEFINITE);
        aiMove.setAutoReverse(false);

        gameScene = new Scene(main);

        HBox ending = new HBox();
        endingMessage = new Text("");
        endingMessage.setTextAlignment(TextAlignment.CENTER);
        ending.getChildren().add(endingMessage);
        ending.setAlignment(Pos.CENTER);
        main.setBottom(ending);

        // complete setup
        primaryStage.setScene(activeScene);
        primaryStage.show();
    }

    /**
     * Event handling for user clicking Box
     * User should only be able to select one tile. Once another tile is clicked, if it is a valid move,
     * the current piece moves there
     */
    public void handleClick(MouseEvent e) {
        if (activeScene == gameScene && (p1vp2 || choice == game.getCurrentTurn().getColor())) {
            BoxPane bp = (BoxPane) (e.getSource());

            // allow a user to un-select the piece
            if (bp.isSelected()) {
                bp.setSelected(false);
                selected.remove(bp);
            }
            // if color of piece aligns with current team and no other piece is selected allow click
            else if (bp.getBox().getPiece() != null && selected.isEmpty()) {
                if (bp.getBox().getPiece().getColor() == Piece.Color.WHITE && game.getCurrentTurn() == game.getWhitePlayer()) {
                    bp.setSelected(true);
                    selected.add(bp);
                } else if (bp.getBox().getPiece().getColor() == Piece.Color.BLACK && game.getCurrentTurn() == game.getBlackPlayer()) {
                    bp.setSelected(true);
                    selected.add(bp);
                }
            }
            // if box is empty or holds an opponent piece check to see if it is a valid move
            else if ((bp.getBox().getPiece() == null || bp.getBox().getPiece().getColor() != game.getCurrentTurn().getColor()) && !selected.isEmpty()) {
                boolean ans = game.playerMove(game.getCurrentTurn(), selected.get(0).getBox(), bp.getBox());
                if (ans) {
                    selected.get(0).setSelected(false);
                    selected.get(0).updated();
                    selected.clear();
                    bp.updated();
                }
            }
            // Check if piece is the same color as previously selected piece, if so remove past piece from selected and select new piece
            else if (!selected.isEmpty() && selected.get(0).getBox().getPiece().getColor() == bp.getBox().getPiece().getColor()) {
                selected.get(0).setSelected(false);
                selected.clear();
                selected.add(bp);
                bp.setSelected(true);
            }
        }

        //TODO once user has ability to choose color adjust message
        if (game.getStatus() == Game.GameMode.BLACK_WIN) {
            endingMessage.setText("Black Team Won!");
            handleEnd(e);
        } else if (game.getStatus() == Game.GameMode.WHITE_WIN) {
            endingMessage.setText("White Team Won!");
            handleEnd(e);
        } else if (game.getStatus() == Game.GameMode.TIE) {
            endingMessage.setText("Tie Game!");
            handleEnd(e);
        }
    }

    // Event handling for timer running out or ending game
    public void handleEnd(MouseEvent e){
        for(Node pane : gameBoard.getChildren()) {
            pane.setOnMouseClicked(null);
        }
        if(game.getStatus() == Game.GameMode.ACTIVE){
            endingMessage.setText("You Quit the Game!");
        }
        aiMove.pause();
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
        whiteTime.setText("10:00");
        blackTime.setText("10:00");
        whiteClockTimeline.play();
        aiMove.play();
        blackClockTimeline.pause();
        endingMessage.setText("");
    }

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

    /**
     * Checks and alters which timer is running based on the current player
     * TODO: Fix timer so that it only starts when the user gets to the game board
     */
    public void checkPlayerStatus(){
        if(activeScene == gameScene && game.getCurrentTurn() == game.getWhitePlayer()){
            blackTimer.setStyle("-fx-background-color: #d1e5eb;");
            blackLabel.setStrokeWidth(0);
            blackTime.setFont(new Font(13));

            whiteTimer.setStyle("-fx-background-color: #ec8f90;" + "-fx-border-width:2;"+"-fx-border-color: #e1577a;");
            whiteLabel.setStroke(Color.BLACK);
            whiteLabel.setStrokeWidth(.5);
            whiteTime.setFont(new Font(15));
            blackClockTimeline.pause();
            whiteClockTimeline.play();

        }
        else if(activeScene == gameScene && game.getCurrentTurn() == game.getBlackPlayer()){
            whiteTimer.setStyle("-fx-background-color: #d1e5eb;");
            whiteLabel.setStrokeWidth(0);
            whiteTime.setFont(new Font(13));

            blackTimer.setStyle("-fx-background-color: #ec8f90;" + "-fx-border-width:2;"+"-fx-border-color: #e1577a;");
            blackLabel.setStroke(Color.BLACK);
            blackLabel.setStrokeWidth(.5);
            blackTime.setFont(new Font(15));
            whiteClockTimeline.pause();
            blackClockTimeline.play();
        }
    }

    // Draws the board
    public void drawBoard() {
        gameBoard.getChildren().clear(); // clears the board
        for (int r = 0; r < 8; ++r) {
            for (int c = 0; c <8; c++) {
                BoxPane bp = new BoxPane(game.getBoard(),r,c);
                bp.setOnMouseClicked(this::handleClick);
                gameBoard.add(bp,r,c);
            }
        }
    }

    public static void main(String [] args)
    {
        launch(args);
    }
}



