package pack;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class Driver {
    private static String ch_C;
    private static String ch_P;
    private static int diff=0;
    private  static void random(){
        diff= ThreadLocalRandom.current().nextInt(0,2);
    }
    public void first(){
        Object[] possibleValues = {"Human", "Computer"};
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Who goes first ?", "First Move",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);
        //TODO
        if(selectedValue=="Human") {
            ch_C = "0";
            ch_P = "X";
        }
        else {
            ch_C = "X";
            ch_P = "0";
        }


    }

    public static void main(String[] args)
    {
        Driver  main1=new Driver();
        String message =JOptionPane.showInputDialog("Please enter name:");
        GameGUI GUI =new GameGUI(message);
        main1.first();
        GUI.button_response(ch_P,ch_C,diff,message);
    }
}

