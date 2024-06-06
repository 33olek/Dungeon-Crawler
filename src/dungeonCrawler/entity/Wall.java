package dungeonCrawler.entity;

import java.awt.*;

public class Wall extends Rectangle {
    public Wall(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
    }
}