package pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI {
   private static int  score_player=0;
   private static int  score_ai=0;
   private static int  draws=0;
    private JFrame window = new JFrame();
    private JButton b[] = new JButton[9];
    private JPanel content_holder = new JPanel();
    private JPanel Info_Menu = new JPanel();
    private JPanel Check_Board = new JPanel();
   static JLabel Player_Points = new JLabel();
   static JLabel Computer_Points = new JLabel();
   static JLabel Draws = new JLabel();
   static public void Color_now(int row,int col,JButton b[])
   {
       if(row==1)
           b[row+col-2].setBackground(Color.GREEN);
       if(row==2)
           b[row+col].setBackground(Color.GREEN);
       if(row==3)
           b[row+col+2].setBackground(Color.GREEN);
   }
   static public void color_buttons(int row,int row1,int row2, int col,int col1,int col2,JButton b[]){

       Color_now(row,col,b);
       Color_now(row1,col1,b);
       Color_now(row2,col2,b);
   }
    public  JButton[] get_buttons(){
        return b;
    }
    static public void add_score(String c,String player_name){
        if(c=="C") {
            score_ai++;
            Computer_Points.setText("Computer Points:" + score_ai);
        }
        if(c=="P") {

            score_player++;
            Player_Points.setText(player_name + ":" + " " + score_player);
        }
        if(c=="D") {
            draws++;
            Draws.setText("Draws:" + draws);
        }
    }
    private void Reset_Scoreboard()
    {
        score_ai=0;
        score_player=0;
        draws=0;
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
        //JLabel Player_Points = new JLabel();
        Player_Points.setText(player_name + ":" + " " + score_player);
       // JLabel Computer_Points = new JLabel();
        Computer_Points.setText("Computer Points:" + score_ai);
       // JLabel Draws = new JLabel();
        Draws.setText("Draws:" + draws);
        JButton New_G_Button = new JButton();
        New_G_Button.setText("New Game");
        New_G_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                Reset_Scoreboard();
                Driver.main(null);
            }
        });
        Info_Menu.setBackground(Color.pink);
        Info_Menu.add(Player_Points);
        Info_Menu.add(Computer_Points);
        Info_Menu.add(Draws);
        Info_Menu.add(New_G_Button);
        Check_Board.setLayout(new GridLayout(3, 3, 2, 2));
        Check_Board.setBackground(Color.white);
        for (int i = 0; i < 9; i++) {
            b[i] = new JButton();
            b[i].setBackground(Color.yellow);
            Check_Board.add(b[i]);
        }
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content_holder.add(Info_Menu);
        content_holder.add(Check_Board);
        window.setSize(500, 500);
        window.setContentPane(content_holder);
        window.add(Check_Board);
        window.setVisible(true);
        }
            }




