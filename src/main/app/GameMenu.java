package main.app;

import main.resources.Canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameMenu extends JPanel{

    RunGame mainFrame;
    byte selectedButton = 0;

    JPanel buttons[] = new JPanel[3];

    GameMenu(RunGame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        setSize(mainFrame.getWidth() / 2, mainFrame.getHeight() / 2);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JPanel();
            buttons[i].setLayout(new BorderLayout());
            buttonPanel.add(buttons[i], BorderLayout.CENTER);
        }
        JLabel[] menuTexts = new JLabel[]{
            new JLabel("START", JLabel.CENTER), new JLabel("OPTIONS", JLabel.CENTER), new JLabel("EXIT", JLabel.CENTER),


        };
        for(int i = 0 ; i < menuTexts.length; i++){
            menuTexts[i].setFont(mainFrame.textFonts);
            buttons[i].add(menuTexts[i]);
        }

        selectButton(buttons[0]);

        add(buttonPanel, BorderLayout.CENTER);
    }

    public void mainMenuKeyFunction(KeyEvent e){
        if(e.getKeyChar() == KeyEvent.VK_ENTER){
            if(selectedButton == 0){
                mainFrame.showGamePanel();
            }else if(selectedButton == 1){
                mainFrame.showOptionPanel();
            }else if(selectedButton == 2){
                mainFrame.exitGame();
            }
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
