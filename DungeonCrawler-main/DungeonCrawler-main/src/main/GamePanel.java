package main;

import entity.Player;

import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = 48;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = 768;
    final int screenHeight = 576;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this,keyH);

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    public void run() {
        while (true) {

            long currentTime = System.nanoTime();

            update();
            try {
                Thread.sleep(1000 / 60); // 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        player.draw(g2);

        g2.dispose();
    }
}
