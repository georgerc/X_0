package pack;

import com.sun.javaws.exceptions.ExitException;
import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class GameGUI {
    int nr = 0;
    private JPanel panel;
    private JFrame window = new JFrame();
    public JButton b[] = new JButton[9];
    private String[] letters = new String[9];
    private JPanel content_holder = new JPanel();
    private JPanel Info_Menu = new JPanel();
    private JPanel Check_Board = new JPanel();
    private Computer_Player Ai;

    public void set_Button(int x, String s) {
        b[x].setText(s);
    }

    public GameGUI(String player_name) {
        //CONTENT HOLDER BUILDER//
        content_holder.setLayout(new BoxLayout(content_holder, BoxLayout.Y_AXIS));
        content_holder.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        content_holder.setBackground(Color.yellow);
        Info_Menu.setMaximumSize(new Dimension(500, 100));
        //INFO MENU BUILDER\
        int tester = 1;
        Info_Menu.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel Player_Points = new JLabel();
        Player_Points.setText(player_name + ":" + " " + "P");
        JLabel Computer_Points = new JLabel();
        Computer_Points.setText("Computer Points:" + "P");
        JLabel Draws = new JLabel();
        Draws.setText("Draws:" + "P");
        JButton New_G_Button = new JButton();
        New_G_Button.setText("New Game");
        Info_Menu.setBackground(Color.pink);
        Info_Menu.add(Player_Points);
        Info_Menu.add(Computer_Points);
        Info_Menu.add(Draws);
        Info_Menu.add(New_G_Button);
        //
        Check_Board.setLayout(new GridLayout(3, 3, 2, 2));

        Check_Board.setBackground(Color.white);
        for (int i = 0; i < 9; i++) {
            b[i] = new JButton(" ");
            b[i].setBackground(Color.yellow);
            Check_Board.add(b[i]);
        }
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content_holder.add(Info_Menu);
        content_holder.add(Check_Board);
        window.setSize(500, 500);
        window.setContentPane(content_holder);
        window.add(Check_Board);
        //window.pack();
        //window.setLocationByPlatform(true);
        window.setVisible(true);

        Object[] possibleValues = {"Human", "Computer"};
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Who goes first ?", "First Move",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);
        //TODO
        final String ch_C;
        final String ch_P;


        if(selectedValue=="Human") {
            ch_C = "0";
            ch_P = "X";
        }
        else {
            ch_C = "X";
            ch_P = "0";
        }

        // int game_dif=ThreadLocalRandom.current().nextInt(0,1);
        // Ai=new C_Player_Easy();
        // Ai.choise();
        /*if(game_dif==1)
            Ai=new C_Player_Hard();
        else {
            Ai = new C_Player_Easy();
            Ai.choise();
        }*/
      /*  for(int i=0;i<9;i++)
            letters[i]="";
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(3,3));
        for(int i=0;i<9;i++)
        {
            b[i]=new JButton();
            b[i].setBackground(Color.yellow);
            window.add(b[i]);
        }
        window.setVisible(true);
*/

      System.out.printf(b[0].getText());

        for(int i=0;i<9;i++) {


            b[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int pos;
                    for (int i = 0; i < 9; i++) {
                        if (b[i] == e.getSource()) {
                           set_Button(i,ch_P);
                            pos = i;
                        }
                    }
                    int x = ThreadLocalRandom.current().nextInt(0, 9);
                    while ((b[x].getText() == ch_P || b[x].getText() == ch_C) && nr < 8) {
                        x = ThreadLocalRandom.current().nextInt(0, 9);
                    }
                    if (nr < 8)
                        b[x].setText(ch_C);
                    nr += 2;
                    if ( (b[0].getText() == b[4].getText() && b[4].getText() == b[8].getText() ) && b[0].getText()!=" ")
                        JOptionPane.showMessageDialog(null, b[0].getText() + "WON");
                }


            });



        }



            int upper=1;
            int counter=0;
            int oc=0;

            // check diagonal



            }
    }



