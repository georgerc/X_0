package pack;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class C_Player_Easy extends  Computer_Player {



public int choise(String b[] ,String ch_P, String ch_C,int nr){
    int x = ThreadLocalRandom.current().nextInt(0, 9);
    while ((b[x] == ch_P || b[x] == ch_C) && nr < 8) {
        x = ThreadLocalRandom.current().nextInt(0, 9);
    }
    return x;
}

}
