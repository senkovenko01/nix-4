package ua.com.alevel.application;

import ua.com.alevel.level_1.api.ApplicationOfFirstLevel;
import ua.com.alevel.level_2.Brackets;
import ua.com.alevel.level_3.GameOfLife;

import java.util.Scanner;

public class ApplicationOfAllLevels {
    public static ApplicationOfFirstLevel applicationOfFirstLevel = new ApplicationOfFirstLevel();
    public static Brackets brackets = new Brackets();
    public static GameOfLife gameOfLife = new GameOfLife();

    public void go() {
        System.out.println("Select level of module");
        Scanner scanner = new Scanner(System.in);

        String choice;
        while ((choice = scanner.nextLine()) != null) {
            switch (choice) {
                case "0": {
                    System.exit(0);
                }
                case "1":
                    applicationOfFirstLevel.go();
                    break;
                case "2":
                    brackets.go();
                    System.out.println("Back to select level");
                    break;
                case "3":
                    gameOfLife.go();
                    break;
                default:
                    System.out.println("Number of level not found");

            }
            System.out.println("If you want exit, please input 0, else, repeat logic");

        }
    }
}
