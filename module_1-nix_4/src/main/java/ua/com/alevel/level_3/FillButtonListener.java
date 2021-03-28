package ua.com.alevel.level_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FillButtonListener implements ActionListener {
    Random random = new Random();

    @Override
    public void actionPerformed(ActionEvent ev) {
        for (int x = 0; x < GameOfLife.LIFE_SIZE; x++) {
            for (int y = 0; y < GameOfLife.LIFE_SIZE; y++) {
                GameOfLife.lifeGeneration[x][y] = random.nextBoolean();
            }
        }
        GameOfLife.canvasPanel.repaint();
    }
}
