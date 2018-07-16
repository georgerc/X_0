package pack;
import java.util.concurrent.ThreadLocalRandom;
public class C_Player_Hard extends  Computer_Player {
    /**
     * Function verify if there is a winner, knowing the coordinates for the last X or 0 added to the table, function verifies on row,column and diagonals if we have 3 X or 3 0 in consecutive cells
     * @param matrix a String matrix that represent the game board, we have marked in this matrix, positions where are Xs and 0s
     * @param r is the index of the row where the current player put a sign
     * @param c index of the column wbere the current player put a sign
     * @return
     */
    static private int Validate(String matrix[][],int r, int c) {
        if (matrix[r][c] == matrix[r - 1][c] && matrix[r][c] == matrix[r - 2][c]) {
            return 1;

        }
        if (matrix[r][c] == matrix[r - 1][c] && matrix[r][c] == matrix[r + 1][c])
        {
            return 1;
        }
        if (matrix[r][c] == matrix[r + 1][c] && matrix[r][c] == matrix[r + 2][c]) {
            return 1;
        }
        if (c >= 2)
            if (matrix[r][c] == matrix[r][c - 1] && matrix[r][c] == matrix[r][c - 2]) {
                return 1;

            }
        if (matrix[r][c] == matrix[r][c - 1] && matrix[r][c] == matrix[r][c + 1]) {
            return 1;
        }
        if (matrix[r][c] == matrix[r][c + 1] && matrix[r][c] == matrix[r][c + 2]) {
            return 1;
        }
        if (matrix[r][c] == matrix[r + 1][c + 1] && matrix[r][c] == matrix[r + 2][c + 2]) {
            return 1;
        }
        if (r >= 2 && c >= 2)
            if (matrix[r][c] == matrix[r - 1][c - 1] && matrix[r][c] == matrix[r - 2][c - 2]) {
                return 1;
            }
        if (matrix[r][c] == matrix[r - 1][c - 1] && matrix[r][c] == matrix[r + 1][c + 1]) {
            return 1;
        }
        if (c >= 2)
            if (matrix[r][c] == matrix[r + 1][c - 1] && matrix[r][c] == matrix[r + 2][c - 2]) {
                return 1;
            }
        if (r >= 2)
            if (matrix[r][c] == matrix[r - 1][c + 1] && matrix[r][c] == matrix[r - 2][c + 2]) {
                return 1;
            }
        if (matrix[r][c] == matrix[r + 1][c - 1] && matrix[r - 1][c + 1] == matrix[r][c]) {
            return 1;
        }
        return 0;
    }

    /**
     * we have 9 buttons with indexes from 0 to 8, at every move, we put a character on a button, computer use matrix to decide where to put his character, in this function, we use validate function to see in which way a move will affect the game, if computer can stop player from winning or can win
     * @param matrix
     * @param ch_P characters of the player( 0 if player is the second, X if player is the first)
     * @param ch_C character of the computer( 0 if computer is the second, X if computer is the first)
     * @param ch_A character of the player or of the computer, depending on the case
     * @return
     */
    private int GetPos(String matrix[][],String ch_P,String ch_C,String ch_A)
    {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (matrix[i][j] != ch_C && matrix[i][j] != ch_P) {
                    matrix[i][j] = ch_A;
                    if (Validate(matrix, i, j) == 1) {
                        matrix[i][j] = "";
                        if (i == 1)
                            return i + j - 2;
                        if (i == 2)
                            return i + j;
                        if (i == 3)
                            return i + j + 2;
                    }
                    matrix[i][j] = "";
                }
            }
        }
        return 10;
    }

    /**
     * here is the game strategy, computer verifies if it can win, if it can, it select that cell and win, if it can't win with this move, verifies if player can win and blocks him, if neither player or computer can win this turn, computer select a random cell and put its character in it
     * @param matrix
     * @param b a String with characters that are on the buttons, because we want to see which button is marked and which isn't, and want to select a button to mark with comoputer's character
     * @param ch_P players' character
     * @param ch_C computer's character
     * @param nr
     * @return
     */
    public int choise(String matrix[][],String b[] ,String ch_P, String ch_C,int nr)
    {
        int x=0;
        x=GetPos(matrix,ch_P,ch_C,ch_C);
        if(x!=10)
            return x;
        x=GetPos(matrix,ch_P,ch_C,ch_P);
        if(x!=10)
            return x;
        x=ThreadLocalRandom.current().nextInt(0,9);
        if(b!=null) {
            while ((b[x] == ch_P || b[x] == ch_C) && nr < 9) {
                x = ThreadLocalRandom.current().nextInt(0, 9);
            }
        }
        return x;
    }
}
