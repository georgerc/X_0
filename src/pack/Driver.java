package pack;

import javax.swing.*;

public class Driver {


    public static void main(String[] args)
    {
        String message =JOptionPane.showInputDialog("Please enter name:");
        new GameGUI(message);

    }
}
