package main;

import main.GamePanel;

import java.awt.Component;
import javax.swing.JFrame;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(3);
        window.setResizable(false);
        window.setTitle("Dungeon Crawler 2D");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo((Component)null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
