package ua.com.alevel.level_1.api;

import ua.com.alevel.application.ApplicationOfAllLevels;
import ua.com.alevel.level_1.KnightsMove;
import ua.com.alevel.level_1.SquareTriangle;
import ua.com.alevel.level_1.UniqueNumbers;

import java.util.Scanner;

public class ApplicationOfFirstLevel {

    public static KnightsMove knightsMove = new KnightsMove();
    public static SquareTriangle squareTriangle = new SquareTriangle();
    public static UniqueNumbers uniqueNumbers = new UniqueNumbers();
    public static ApplicationOfAllLevels application = new ApplicationOfAllLevels();

    public void go() {
        System.out.println("You are selected 1 level");
        System.out.println("Select number of task");
        Scanner scanner = new Scanner(System.in);
        String option;
        while ((option = scanner.nextLine()) != null) {
            switch (option) {
                case "0":
                    application.go();
                    break;
                case "1":
                    knightsMove.go();
                    break;
                case "2":
                    squareTriangle.go();
                    break;
                case "3":
                    System.out.println("You are selected 3 task");
                    uniqueNumbers.go();
                    break;
            }
            System.out.println("If you want to go back to level selection, please input 0, else, repeat logic");
        }


    }


}
