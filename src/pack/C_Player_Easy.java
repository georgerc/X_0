package pack;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class C_Player_Easy extends  Computer_Player {


    /**
     * Pick a random number that represents the choise of the computer.
     * @param b The buttons
     * @param ch_P The character of the computer player(either "0" or "X").
     * @param ch_C The character of the human player(either "0"or "X")
     * @param nr the number of occupied buttons.
     * @return Returns a random number between 0 and 9,that represents the move of the computer player.
     */
    public int choise(String b[] ,String ch_P, String ch_C,int nr){

    int x = ThreadLocalRandom.current().nextInt(0, 9);
    if(b!=null) {
        while ((b[x] == ch_P || b[x] == ch_C) && nr < 9) {
            x = ThreadLocalRandom.current().nextInt(0, 9);
        }
    }
    return x;
}

}
