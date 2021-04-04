package ua.com.alevel.controller;

import java.util.Scanner;

public class MainController {

    private final AuthorController authorController = new AuthorController();
    private final BookController bookController = new BookController();

    public void run(){
        System.out.println("CRUD Application");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select option:" +
                "\n1 - Operations with author" +
                "\n2 - Operations with book ");
        String check;
        while ((check=scanner.nextLine())!=null){
            switch (check){
                case "0":
                    System.exit(0);
                case "1":
                    authorController.run();
                    break;
                case "2":
                    bookController.run();
                    break;
                default:
                    System.out.println("Invalid number of operation");
            }
            System.out.println("If you want to exit, please input 0, else repeat logic");
        }


    }
}
