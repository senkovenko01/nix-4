package ua.com.alevel.controller;


import java.util.Scanner;

public class MainController {
    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        IntegerController integerController = new IntegerController();
        DoubleController doubleController = new DoubleController();
        while (true) {
            try {
                System.out.println("0. - Exit\n" +
                        "1.- Integer panel\n" +
                        "2.- Double panel");
                switch (scanner.nextLine()) {
                    case "1":
                        integerController.run();
                        break;
                    case "2":
                        doubleController.run();
                    case "0":
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("INCORRECT INPUT!!!");
            }
        }
    }
}
