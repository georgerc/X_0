package pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
/**
*The main class that drives the Tic Tac Toe Game.

 */
public class Driver {
    static private int diff = 0;
    static private int nr = 0;
    static private int ln = 0, col = 0;
    private static String ch_C;
    private static String ch_P;
    private static JButton b[] = new JButton[9];
    static private String winner="NoOne";
    static private String matrix[][] = new String[5][5];
    static private String[] letters = new String[9];

    /**
     * Gives the player a JOption pane to choose wich player goes first,Human or Computer.
     * */
    static private void first() {
        Object[] possibleValues = {"Human", "Computer"};
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Who goes first ?", "First Move",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);
        //TODO
        //Exeption
        if (selectedValue == "Human") {
            ch_C = "0";
            ch_P = "X";
        } else if (selectedValue=="Computer"){
            ch_C = "X";
            ch_P = "0";
        }
        else
        {
            ch_C=ch_P=null;
        }
    }

    /**
     *Validates if there is a win on row's colloms and diagonals.
     * @param r The row
     * @param c The collom
     * @param name The name of the player.
     * @return
     */
    static private String Validate(int r, int c, String name) {
        if (matrix[r][c] == matrix[r - 1][c] && matrix[r][c] == matrix[r - 2][c]) {
            GameGUI.color_buttons(r,r-1,r-2,c,c,c,b);
            return name;

        }
        if (matrix[r][c] == matrix[r - 1][c] && matrix[r][c] == matrix[r + 1][c])
        {
            GameGUI.color_buttons(r,r-1,r+1,c,c,c,b);
            return name;
        }
        if (matrix[r][c] == matrix[r + 1][c] && matrix[r][c] == matrix[r + 2][c]) {
            GameGUI.color_buttons(r,r+1,r+2,c,c,c,b);
            return name;

        }
        if (c >= 2)
            if (matrix[r][c] == matrix[r][c - 1] && matrix[r][c] == matrix[r][c - 2]) {
                GameGUI.color_buttons(r,r,r,c,c-1,c-2,b);
                return name;

            }
        if (matrix[r][c] == matrix[r][c - 1] && matrix[r][c] == matrix[r][c + 1]) {
            GameGUI.color_buttons(r,r,r,c,c-1,c+1,b);
            return name;
        }
        if (matrix[r][c] == matrix[r][c + 1] && matrix[r][c] == matrix[r][c + 2]) {
            GameGUI.color_buttons(r,r,r,c,c+1,c+2,b);
            return name;

        }
        if (matrix[r][c] == matrix[r + 1][c + 1] && matrix[r][c] == matrix[r + 2][c + 2]) {
            GameGUI.color_buttons(r,r+1,r+2,c,c+1,c+2,b);
            return name;

        }
        if (r >= 2 && c >= 2)
            if (matrix[r][c] == matrix[r - 1][c - 1] && matrix[r][c] == matrix[r - 2][c - 2]) {
                GameGUI.color_buttons(r,r-1,r-2,c,c-1,c-2,b);
                return name;

            }
        if (matrix[r][c] == matrix[r - 1][c - 1] && matrix[r][c] == matrix[r + 1][c + 1]) {
            GameGUI.color_buttons(r,r-1,r+1,c,c-1,c+1,b);
            return name;

        }
        if (c >= 2)
            if (matrix[r][c] == matrix[r + 1][c - 1] && matrix[r][c] == matrix[r + 2][c - 2]) {
                GameGUI.color_buttons(r,r+1,r+2,c,c-1,c-2,b);
                return name;
            }
        if (r >= 2)
            if (matrix[r][c] == matrix[r - 1][c + 1] && matrix[r][c] == matrix[r - 2][c + 2]) {
                GameGUI.color_buttons(r,r-1,r-2,c,c+1,c+2,b);
                return name;
            }
        if (matrix[r][c] == matrix[r + 1][c - 1] && matrix[r - 1][c + 1] == matrix[r][c]) {
            GameGUI.color_buttons(r, r + 1, r - 1, c, c - 1, c + 1, b);
            return name;
        }
        return "NoOne";
    }

    /**
     * Disables all buttons after a game session has ended.
     */
    static private void DisableAll() {
        for (int i = 0; i < 9; i++)
            b[i].setEnabled(false);
    }

    static private void condition(int i) {
        if (i < 3) {
            matrix[1][i + 1] = letters[i];
            ln = 1;
            col = i + 1;
        } else if (i < 6) {
            matrix[2][i - 2] = letters[i];
            ln = 2;
            col = i - 2;
        } else if (i < 9) {
            matrix[3][i - 5] = letters[i];
            ln = 3;
            col = i - 5;
        }
    }

    /**
     * Creates the Action Handler for each button, chooses based on variable "diff" what type of strategy to use, and checks if there is a winner or a draw.
     * @param ch_P The player character (Either 0 or X)
     * @param ch_C The computer player character (Either 0 or X)
     * @param diff The game difficulty (0 for a "naive" computer or 1 for a "strategic" computer)
     * @param player_name The name of the player.
     */
         static private void button_response(String ch_P, String ch_C, int diff, String player_name) {

        winner = "NoOne";
        for (int i = 0; i < 9; i++) {
            b[i].setFont(new Font("Serif",Font.BOLD,20));
            b[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int pos;
                    for (int i = 0; i < 9; i++) {
                        if (b[i] == e.getSource()) {
                            b[i].setText(ch_P);
                            b[i].setEnabled(false);
                            letters[i] = ch_P;
                            Driver.condition(i);
                            nr++;
                        }
                    }

                    //Validate
                    winner = Validate(ln, col, player_name);
                    if (winner == player_name) {
                        JOptionPane.showMessageDialog(null, "Winner is " + winner);
                        GameGUI.add_score("P",player_name);
                        DisableAll();
                        reset_UI();
                        if (ch_P == "0")
                            Driver.IGoFirst(ch_P, ch_C);
                        return;
                    }
                    int x;
                    if (diff == 0) {
                        x = (new C_Player_Easy()).choise(letters, ch_P, ch_C, nr);
                    }
                    else {
                        x = (new C_Player_Hard()).choise(matrix, letters, ch_P, ch_C, nr);
                    }
                    if (nr < 9) {
                        b[x].setText(ch_C);
                        letters[x] = ch_C;
                        b[x].setEnabled(false);
                        Driver.condition(x);
                        nr++;

                        //Validate
                            winner = Validate(ln, col, "Computer");
                        if (winner == "Computer") {
                            JOptionPane.showMessageDialog(null, "Winner is Computer!");
                            GameGUI.add_score("C",player_name);
                            DisableAll();
                            reset_UI();
                            if (ch_P == "0")
                                Driver.IGoFirst(ch_P, ch_C);
                            return;
                        }
                    }
                    if (nr>=9 && winner == "NoOne") {

                        JOptionPane.showMessageDialog(null, "Draw");
                        DisableAll();
                        GameGUI.add_score("D",player_name);
                        reset_UI();
                        if (ch_P == "0")
                            Driver.IGoFirst(ch_P, ch_C);
                        return;

                    }
                }
            });
        }
    }

    /**
     * Make the first move if the Computer Player goes first.
     * @param ch_P ch_P The player character (Either 0 or X)
     * @param ch_C The computer player character (Either 0 or X)
     */
    static private void IGoFirst(String ch_P, String ch_C) {
        int x;
        x = (new C_Player_Easy()).choise(null, ch_P, ch_C, 0);
        nr++;
        b[x].setText(ch_C);
        b[x].setEnabled(false);
        letters[x] = ch_C;
        condition(x);
    }

    /**
     * Rest all the variables for a new game.
     */
    static public void reset_UI() {
        for (int i = 0; i < 9; i++) {
            b[i].setText("");
            b[i].setEnabled(true);
            b[i].setBackground(Color.YELLOW);
            letters[i]="";

        }
        nr=0;
        winner="NoOne";
        for (int i = 1; i <= 3; i++)
            for(int j=1;j<=3;j++)
                matrix[i][j]="";


    }

    /**
     * Main funtion.
     * @param args
     */
    public static void main(String[] args) {
        String message = null;
        message = JOptionPane.showInputDialog("Please enter name:");
        if(message==null)
             return;
        GameGUI GUI = new GameGUI(message);
        Driver.first();
        if(ch_C==null)
        {
            GUI.GetWindow().dispose();
            return;
        }
        b = GUI.get_buttons();
        diff=ThreadLocalRandom.current().nextInt(0, 2);
        if(diff==0)
        {
            JOptionPane.showMessageDialog(null,"Play against naive computer player!");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Play against strategic computer player!");
        }
        Driver.button_response(ch_P, ch_C, diff, message);
            if (ch_P == "0")
                Driver.IGoFirst(ch_P, ch_C);
}
    }

