package ua.com.alevel.level_1;

import java.util.Scanner;

public class SquareTriangle {
    private final Scanner scanner = new Scanner(System.in);

    public void go() {
        System.out.println("1 level 2 task: Calculate the square of triangle");
        System.out.println("Write first dot");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.println("Write second dot");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        System.out.println("Write third dot");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        double a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double b = Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
        double c = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
        if (((b + c) > a) && ((a + c) > b) && ((a + b) > c)) {
            double p = (a + b + c) / 2.0;
            double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            System.out.println("Square is " + square);

        } else System.out.println("Triangle is not exist");
    }
}
