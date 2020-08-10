package _00_mohayemin.tictactoe_testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private JButton[][] buttons;
    GameState gameState = new GameState();
    private JLabel statusBar;

    public GamePanel(JLabel statusBar) {
        this.statusBar = statusBar;
        GridLayout lm = new GridLayout(3, 3);
        lm.setHgap(10);
        lm.setVgap(10);
        setLayout(lm);
        setPreferredSize(new Dimension(300, 300));
        InitContent();
    }
// 1 2
//
    private void InitContent() {
        buttons = new JButton[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                addButton(r, c);
            }
        }
    }

    private void addButton(int row, int col) {
        JButton button = new JButton();
        button.addActionListener(e -> {
            button.setText("x");
            gameState.setPlayersMove(row, col);
            if (gameState.isPlayerWon()) {
                statusBar.setText("WIN!");
            }
        });
        add(button);
        buttons[row][col] = button;
    }
}

class GameState {
    String[][] moves = new String[3][3];

    void setPlayersMove(int row, int col) {
        moves[row][col] = "x";
    }

    void setComputersMove(int row, int col) {
        moves[row][col] = "0";
    }

    public boolean isPlayerWon(){
        for (int r = 0; r < 3; r++) {
            if (moves[r][0] == "x" &&
                    moves[r][1]== "x" &&
                    moves[r][2] == "x") {
                return true;
            }
        }

        for (int c = 0; c < 3; c++) {
            if (moves[0][c] == "x" &&
                    moves[1][c] == "x" &&
                    moves[2][c] == "x") {
                return true;
            }
        }

        if (moves[0][0] == "x" &&
                moves[1][1] == "x" &&
                moves[2][2] == "x") {
            return true;
        }

        if (moves[0][2] == "x" &&
                moves[1][1] == "x" &&
                moves[2][0] == "x") {
            return true;
        }

        return false;
    }
}

class GameStateTest {
    @Test
    void virticalWin() {
        GameState gameState = new GameState();
        gameState.setPlayersMove(0, 0);
        gameState.setComputersMove(0, 1);
        gameState.setPlayersMove(1, 0);
        gameState.setComputersMove(0, 2);
        gameState.setPlayersMove(2, 0);

        boolean won = gameState.isPlayerWon();
        Assertions.assertTrue(won);
        /*
        x00
        x--
        x--
         */
    }
}