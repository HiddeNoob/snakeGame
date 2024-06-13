package main.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.resources.Canvas;

public class RunGame extends JFrame implements KeyListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Canvas canvas;
    private GameMenu mainMenu;
    private GamePanel gamePanel;
    public GameState gameState = GameState.mainMenu;
    GameEnd gameEnd;
    Font textFonts = new Font(Font.SANS_SERIF, Font.PLAIN, 36);
    RunGame(){
        setTitle("Snake Game");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        canvas = new Canvas(20, 20);

        mainMenu = new GameMenu(this);
        cardPanel.add(mainMenu, "MainMenu");

        add(cardPanel);
        addKeyListener(this);
        setVisible(true);
    }

    public void showMainMenu() {
        gameState = GameState.mainMenu;
        cardPanel.remove(mainMenu);
        cardPanel.add(mainMenu, "MainMenu");
        cardLayout.show(cardPanel, "MainMenu");
    }

    public void showGamePanel() {
        removeKeyListener(this);
        gameState = GameState.gameRunning;
        canvas.resetCanvas();
        gamePanel = new GamePanel(this, canvas);
        cardPanel.add(gamePanel, "GamePanel");
        cardLayout.show(cardPanel, "GamePanel");

    }

    public void showGameEndPanel(int score) {
        gameState = GameState.gameEnd;
        addKeyListener(this);
        gameEnd = new GameEnd(this, score);
        cardPanel.add(gameEnd, "GameEnd");
        cardLayout.show(cardPanel, "GameEnd");

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RunGame::new);
    }

    public void exitGame() {
        System.exit(0);
    }

    public void showOptionPanel() {
    }




    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(gameState == GameState.mainMenu){
            mainMenu.mainMenuKeyFunction(e);
        }else if(gameState == GameState.gameEnd){
            gameState = GameState.mainMenu;
            cardPanel.remove(gameEnd);
            cardPanel.remove(gamePanel);
            cardLayout.show(cardPanel, "MainMenu");

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}

enum GameState {
    mainMenu, gameEnd, gameRunning
}
