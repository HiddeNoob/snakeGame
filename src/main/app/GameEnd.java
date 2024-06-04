package main.app;

import javax.swing.*;
import java.awt.*;

public class GameEnd extends JPanel {

    GameEnd(RunGame mainMenu,int score){
        setLayout(new BorderLayout());
        add(new JLabel("You Died\nScore: " + score), BorderLayout.CENTER);
    }

}
