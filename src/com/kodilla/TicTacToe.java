package com.kodilla;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe extends Application {
    private int i = 0;
    private GridPane grid = new GridPane();

    private int PADDING_MEDIUM = 5;
    private int PADDING_LARGE = 10;
    private int PADDING_XLARGE = 20;

    public enum PLAYER {
        PLAYER_X,
        PLAYER_O
    }
    private List<Score> win = new ArrayList<>();

    private Button[][] board = new Button[3][3];

    static PLAYER whoIsNext = PLAYER.PLAYER_X;

    private Image imageback = new Image("file: resources/foto.png");

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        grid.setAlignment(Pos.CENTER);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = prepereBoardButton();
                board[i][j] = button;
                grid.getChildren();
                grid.add(button, i, j);
            }
        }
        VBox vbRoot = new VBox(),
                vbGrid = new VBox(),
                vbFooter = new VBox(),
                vbPlayers = new VBox(),
                vbGridInfo = new VBox(),
                vbHeader = new VBox();
        HBox hbOptions = new HBox(),
                hbNextGame = new HBox(),
                hbGameDetails = new HBox(),
                hbGameTitle = new HBox();

        vbGrid.getChildren().addAll(grid);
        vbGrid.setPadding(new Insets(PADDING_XLARGE));
        vbGrid.setAlignment(Pos.CENTER);

        Button nextGame = new Button("Next game");
        nextGame.setMinWidth(120);
        nextGame.setMinHeight(50);
        nextGame.setPadding(new Insets(PADDING_MEDIUM));
        nextGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button button = ((Button) actionEvent.getSource());
                for (Node node : grid.getChildren()) {
                    if (node.isDisable()) {
                        ((Button) node).setText("");
                        ((Button) node).setDisable(false);
                    }
                }
            }
        });
        hbNextGame.getChildren().add(nextGame);
        hbNextGame.setPadding(new Insets(PADDING_MEDIUM));
        hbNextGame.setAlignment(Pos.CENTER);

        Button exit = new Button("Exit");
        Button reset = new Button("Reset");

        exit.setMinWidth(60);
        exit.setMinHeight(25);
        exit.setPadding(new Insets(PADDING_LARGE));
        exit.setOnAction(event -> System.exit(0));

        reset.setMinWidth(60);
        reset.setMinHeight(25);
        reset.setPadding(new Insets(PADDING_LARGE));
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button button = ((Button) actionEvent.getSource());
                for (Node node : grid.getChildren()) {
                    ((Button) node).setText("");
                    ((Button) node).setDisable(false);
                }
            }
        });
        hbOptions.getChildren().addAll(exit, reset);
        hbOptions.setPadding(new Insets(PADDING_MEDIUM));
        hbOptions.setAlignment(Pos.CENTER);

        vbFooter.getChildren().addAll(hbNextGame, hbOptions);
        vbRoot.getChildren().addAll(vbGrid, vbFooter);

        Scene scene = new Scene(vbRoot, 500, 500, Color.BLACK);

        for (int y = 0; y < 3; y++) {
            win.add(new Score(board[0][y], board[1][y], board[2][y]));
        }
        for (int x = 0; x < 3; x++) {
            win.add(new Score(board[x][0], board[x][1], board[x][2]));
        }

        win.add(new Score(board[0][0], board[1][1], board[2][2]));
        win.add(new Score(board[2][0], board[1][1], board[0][2]));

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Button prepereBoardButton() {
        Button button = new Button("");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Button button = ((Button) actionEvent.getSource());
                button.setText(whoIsNext == PLAYER.PLAYER_X ? "X" : "O");
                button.setDisable(true);
                whoIsNext = whoIsNext == PLAYER.PLAYER_O ? PLAYER.PLAYER_X : PLAYER.PLAYER_O;
                checkWinner();
            }
        });
        button.setPrefSize(90, 90);
        return button;
    }
    private void checkWinner() {
        for (Score s : win) {
            PLAYER winner = s.getWinner();
            if (winner != null) {
                s.setStyle();
                Alert whoIsWinner = new Alert(Alert.AlertType.INFORMATION);
                if (winner == PLAYER.PLAYER_O) {
                    whoIsWinner.setHeaderText("The Winner is Player O");
                    whoIsWinner.showAndWait();
                    s.removeStyle();
                } else {
                    whoIsWinner.setHeaderText("The Winner is Player X");
                    whoIsWinner.showAndWait();
                    s.removeStyle();
                }
            }
        }
    }
}


















