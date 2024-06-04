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
    byte selectedButton = 0;

    JPanel buttons[] = new JPanel[3];

    GameMenu(RunGame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        mainFrame.addKeyListener(this);
        setSize(mainFrame.getWidth() / 2, mainFrame.getHeight() / 2);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JPanel();
            buttonPanel.add(buttons[i]);
        }

        buttons[0].add(new JLabel("Start"));
        buttons[1].add(new JLabel("Options"));
        buttons[2].add(new JLabel("Exit"));

        add(buttonPanel, BorderLayout.CENTER);
    }


    @Override
    public void keyTyped(KeyEvent e) {



    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(selectedButton);
        if(e.getKeyChar() == KeyEvent.VK_ENTER){
            mainFrame.showGamePanel();
        }
        else if(e.getKeyCode() == 40){ // down arrow
            selectedButton++;
        }
        else if(e.getKeyCode() == 38){ // up arrow
            selectedButton--;
        }

        if(selectedButton >= buttons.length){
            selectedButton = 0;
        } else if (selectedButton < 0) {
            selectedButton = (byte) (buttons.length - 1);
        }

        resetButtonBackgrounds();
        selectButton(buttons[selectedButton]);


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private  void resetButtonBackgrounds(){
        for(JPanel panel : buttons){
            panel.setBackground(Color.white);
            panel.getComponent(0).setForeground(Color.BLACK);
        }
    }

    private void selectButton(JPanel button){
        button.setBackground(Color.darkGray);
        button.getComponent(0).setForeground(Color.WHITE);
    }
}
