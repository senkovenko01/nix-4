package ua.com.alevel.level_1;

import java.util.Scanner;

public class KnightsMove {

    private static final Scanner scanner = new Scanner(System.in);

    public void go() {
        System.out.println("1 level 1 task: Knights Move");
        System.out.println("\"it is believed that the chessboard is numbered only with numbers\"");
        System.out.println("Write coordinates of your position");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.println("Write coordinates, where do you want to go");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int absX = Math.abs(x1 - x2);
        int absY = Math.abs(y1 - y2);

        if ((absX == 1 && absY == 2) || (absX == 2 && absY == 1)) {
            System.out.println("Move correct");
        } else System.out.println("Move incorrect");
    }
}
