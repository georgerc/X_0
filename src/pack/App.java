package pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    int nr=0;
    private JPanel panel;
    JFrame window=new JFrame();
    JButton b[]=new JButton[9];
    String[] letters=new String[9];
    public App() {
        for(int i=0;i<9;i++)
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
        for(int i=0;i<9;i++)
        {
            b[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int pos;
                    for(int i=0;i<9;i++)
                    {
                        if(b[i]==e.getSource())
                        {
                            b[i].setText("X");
                            pos=i;
                        }
                    }
                    int x = ThreadLocalRandom.current().nextInt(0, 9);
                    while((b[x].getText()=="X" || b[x].getText()=="0") && nr<8) {
                        x = ThreadLocalRandom.current().nextInt(0, 9);
                    }
                    if(nr<8)
                        b[x].setText("0");
                    nr+=2;
                }
            });
        }
    }
    public static void main(String[] args)
    {
        new App();
    }
}
