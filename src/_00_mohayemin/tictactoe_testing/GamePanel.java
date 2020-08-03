package _00_mohayemin.tictactoe_testing;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private JButton[][] buttons;
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
            if (isWon()) {
                statusBar.setText("WIN!");
            }
        });
        add(button);
        buttons[row][col] = button;
    }

    private boolean isWon() {
        for (int r = 0; r < 3; r++) {
            if (buttons[r][0].getText() == "x" &&
                    buttons[r][1].getText() == "x" &&
                    buttons[r][2].getText() == "x") {
                return true;
            }
        }

        for (int c = 0; c < 3; c++) {
            if (buttons[0][c].getText() == "x" &&
                    buttons[1][c].getText() == "x" &&
                    buttons[2][c].getText() == "x") {
                return true;
            }
        }

        if (buttons[0][0].getText() == "x" &&
                buttons[1][1].getText() == "x" &&
                buttons[2][2].getText() == "x") {
            return true;
        }

        if (buttons[0][2].getText() == "x" &&
                buttons[1][1].getText() == "x" &&
                buttons[2][0].getText() == "x") {
            return true;
        }

        return false;
    }
}

