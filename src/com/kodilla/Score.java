package com.kodilla;

import javafx.scene.control.Button;

public class Score {
    private Button button1;
    private Button button2;
    private Button button3;

    public Score(Button button1, Button button2, Button button3) {
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
    }
    public TicTacToe.PLAYER getWinner() {
        if (button1.getText().isEmpty()) {
            return null;
        }

        if (button1.getText().equals(button2.getText()) && button2.getText().equals(button3.getText())) {
            return button1.getText().equals("O") ? TicTacToe.PLAYER.PLAYER_O : TicTacToe.PLAYER.PLAYER_X;

        }

        return null;
    }
    public void setStyle() {
        if (getWinner() != null) {
            button1.setStyle("-fx-background-color: #ff0000;");
            button2.setStyle("-fx-background-color: #ff0000;");
            button3.setStyle("-fx-background-color: #ff0000;");
        }
    }
    public void removeStyle() {
        button1.setStyle("");
        button2.setStyle("");
        button3.setStyle("");
    }
}



