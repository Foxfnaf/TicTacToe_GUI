package edu.foxyfnaf;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class TicTacToe {

    public Button[][] buttons = new Button[3][3];
    public boolean isXturn = true;

    public void handleButtonClick(int row, int col) {
        if (!buttons[row][col].getText().equals("")) {
            return; // Button already clicked
        }

        if (isXturn) {
            buttons[row][col].setText("X");
        } else {
            buttons[row][col].setText("O");
        }
        isXturn = !isXturn;

        checkWin();
    }

    private void checkWin() {
        // Check rows, columns and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (checkCombination(buttons[i][0], buttons[i][1], buttons[i][2]) || checkCombination(buttons[0][i], buttons[1][i], buttons[2][i])) {
                showWinMessage();
                return;
            }
        }
        if (checkCombination(buttons[0][0], buttons[1][1], buttons[2][2]) || checkCombination(buttons[0][2], buttons[1][1], buttons[2][0])) {
            showWinMessage();
        }
    }

    private boolean checkCombination(Button b1, Button b2, Button b3) {
        return !b1.getText().equals("") && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText());
    }

    private void showWinMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Koniec Gry");
        alert.setHeaderText(null);
        alert.setContentText("We have a winner!");

        alert.showAndWait();

        Platform.exit();
    }
}

