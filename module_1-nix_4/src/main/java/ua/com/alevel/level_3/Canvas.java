package ua.com.alevel.level_3;

import javax.swing.*;
import java.awt.*;

public  class Canvas extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int x = 0; x < GameOfLife.LIFE_SIZE; x++) {
            for (int y = 0; y < GameOfLife.LIFE_SIZE; y++) {
                if (GameOfLife.lifeGeneration[x][y]) {
                    g.fillOval(x* GameOfLife.POINT_RADIUS, y* GameOfLife.POINT_RADIUS,
                            GameOfLife.POINT_RADIUS, GameOfLife.POINT_RADIUS);
                }
            }
        }
    }
}
