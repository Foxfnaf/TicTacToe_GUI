package edu.foxyfnaf.tictactoe_gui;

import edu.foxyfnaf.TicTacToe;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeAplication extends Application {

    TicTacToe ticTacToe = new TicTacToe();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kółko i Krzyżyk");

        GridPane gridPane = new GridPane();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                ticTacToe.buttons[row][col] = new Button("");
                ticTacToe.buttons[row][col].setMinSize(100, 100);
                final int r = row;
                final int c = col;
                ticTacToe.buttons[row][col].setOnAction(e -> ticTacToe.handleButtonClick(r, c));
                gridPane.add(ticTacToe.buttons[row][col], col, row);
            }
        }

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
