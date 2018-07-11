package pack;
import java.util.concurrent.ThreadLocalRandom;
public class Computer_Player {


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
