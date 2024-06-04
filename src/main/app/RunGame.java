package main.app;

import javax.swing.*;
import java.awt.*;
import main.resources.Canvas;

public class RunGame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Canvas canvas;
    RunGame(){
        setTitle("Snake Game");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        canvas = new Canvas(20, 20);

        GameMenu mainMenu = new GameMenu(this);
        cardPanel.add(mainMenu, "MainMenu");

        add(cardPanel);

        setVisible(true);
    }

    public void showMainMenu() {
        cardLayout.show(cardPanel, "MainMenu");
    }

    public void showGamePanel() {
        GamePanel gamePanel = new GamePanel(this, canvas);
        cardPanel.add(gamePanel, "GamePanel");
        cardLayout.show(cardPanel, "GamePanel");
    }

    public void showGameEndPanel(int score) {

        GameEnd gameEnd = new GameEnd(this, score);
        cardPanel.add(gameEnd, "GameEnd");
        cardLayout.show(cardPanel, "GameEnd");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RunGame::new);
    }
}
