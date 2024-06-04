package main.app;

import main.resources.Canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameMenu extends JPanel implements KeyListener {

    RunGame mainFrame;

    GameMenu(RunGame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        mainFrame.addKeyListener(this);
        add(new JLabel("press enter to start"), BorderLayout.CENTER);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == KeyEvent.VK_ENTER){
            mainFrame.showGamePanel();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
