package main.app;

import javax.swing.*;
import java.awt.*;


public class GameEnd extends JPanel{
    RunGame mainMenu;
    GameEnd(RunGame mainMenu,int score){
        this.mainMenu = mainMenu;
        setLayout(new BorderLayout(10,10));
        setBackground(Color.BLUE);
        JLabel text = new JLabel("You Died");
        JLabel text1 = new JLabel("Score: " + score);
        JLabel text2 = new JLabel("press enter to go back menu");
        JPanel icPanel = new JPanel();
        icPanel.setLayout(new GridLayout(3,1));

        text.setFont(mainMenu.textFonts);
        text2.setFont(mainMenu.textFonts);
        text1.setFont(mainMenu.textFonts);

        text.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setHorizontalAlignment(SwingConstants.CENTER);

        icPanel.add(text);
        icPanel.add(text1);
        icPanel.add(text2);
        add(icPanel,BorderLayout.CENTER);

    }

}
