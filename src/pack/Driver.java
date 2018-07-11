package pack;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class Driver {
    static int ok = 0;
    static private int diff = 0;
    static private int nr = 0;
    static private int ln = 0, col = 0;
    private static String ch_C;
    private static String ch_P;
    private static JButton b[] = new JButton[9];
    static private String winner="NoOne";
    static private String matrix[][] = new String[5][5];
    static private String[] letters = new String[9];

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
        } else {
            ch_C = "X";
            ch_P = "0";
        }


    }

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
                GameGUI.color_buttons(r,r-1,r-2,c,c-1,c,b);
                return name;

            }
        if (matrix[r][c] == matrix[r - 1][c - 1] && matrix[r][c] == matrix[r + 1][c + 1]) {
            GameGUI.color_buttons(r,r-1,r+1,c,c-1,c,b);
            return name;

        }
        if (c >= 2)
            if (matrix[r][c] == matrix[r + 1][c - 1] && matrix[r][c] == matrix[r + 2][c - 2]) {
                GameGUI.color_buttons(r,r+1,r+2,c,c-1,c,b);
                return name;
            }
        if (r >= 2)

            if (matrix[r][c] == matrix[r - 1][c + 1] && matrix[r][c] == matrix[r - 2][c + 2]) {
                GameGUI.color_buttons(r,r-1,r-2,c,c,c,b);
                return name;
        }
        if (matrix[r][c] == matrix[r + 1][c - 1] && matrix[r - 1][c + 1] == matrix[r][c]) {
            GameGUI.color_buttons(r,r+1,r-1,c,c-1,c+1,b);
            return name;


        }

        return "NoOne";
    }

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

    static private void button_response(String ch_P, String ch_C, int diff, String player_name) {
        winner = "NoOne";
        for (int i = 0; i < 9; i++) {
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
                    if (diff == 0)
                        x = (new C_Player_Easy()).choise(letters, ch_P, ch_C, nr);
                    else
                        x = (new C_Player_Easy()).choise(letters, ch_P, ch_C, nr);
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

    static private void IGoFirst(String ch_P, String ch_C) {
        int x;
        x = (new C_Player_Easy()).choise(null, ch_P, ch_C, 0);
        nr++;
        b[x].setText(ch_C);
        b[x].setEnabled(false);
        letters[x] = ch_C;
        condition(x);
    }

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

    private static boolean check_buttons(){
        for(int i=0;i<9;i++)
            if(b[i].isEnabled()) {
                return true;

            }
        return  false;
    }
    public static void main(String[] args) {
        //  Driver d=new Driver();
        String message = JOptionPane.showInputDialog("Please enter name:");
      /*  GameGUI GUI = new GameGUI(message);
        Driver.first();
        b = GUI.get_buttons();
        if (ch_P == "0")
            Driver.IGoFirst(ch_P, ch_C);
            Driver.button_response(ch_P, ch_C, diff, message);*/
        GameGUI GUI = new GameGUI(message);
        Driver.first();
        b = GUI.get_buttons();
        Driver.button_response(ch_P, ch_C, diff, message);
            if (ch_P == "0")
                Driver.IGoFirst(ch_P, ch_C);
        //        Driver.reset_UI();
        //b[0].setBackground(Color.BLUE);

}
        /*if(ok==1) {
            Driver.reset_UI();
            ok=0;
        }*/
    }

