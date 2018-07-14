package pack;
import java.util.concurrent.ThreadLocalRandom;
public class C_Player_Hard extends  Computer_Player {

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
