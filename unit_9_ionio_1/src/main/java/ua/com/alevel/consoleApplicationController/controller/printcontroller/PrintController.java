package ua.com.alevel.consoleApplicationController.controller.printcontroller;

import ua.com.alevel.consoleApplicationController.controller.MainController;
import ua.com.alevel.consoleApplicationController.util.consolehelper.ConsoleHelper;
import ua.com.alevel.service.AuthorOperationRealisation;
import ua.com.alevel.service.BookOperationsRealisation;

public class PrintController {
    public static void run(){
        ConsoleHelper consoleHelper = ConsoleHelper.getInstance();
        boolean printController = true;
        while (printController){
            System.out.println("0. - Exit\n" +
                    "1. - Print all authors\n" +
                    "2. - Print author by name\n" +
                    "3. - Print all books\n" +
                    "4. - Print book by name\n" +
                    "5. - Print books  by author\n" +
                    "6. - Print authors by book");
            switch (consoleHelper.readInteger()){
                case 1:
                    AuthorOperationRealisation.printAllAuthors();
                    System.out.println();
                    break;
                case 2:
                    AuthorOperationRealisation.printAuthorByName(MainController.enterFirstLastName());
                    System.out.println();
                    break;
                case 3:
                    BookOperationsRealisation.printAllBoos();
                    System.out.println();
                    break;
                case 4:
                    BookOperationsRealisation.printBookByName(MainController.enterBookName());
                    System.out.println();
                    break;
                case 5:
                    BookOperationsRealisation.printBooksByAuthorName(MainController.enterFirstLastName());
                    System.out.println();
                    break;
                case 6:
                    AuthorOperationRealisation.printAuthorsByBookName(MainController.enterBookName());
                    System.out.println();
                    break;
                case 0:
                    printController = false;
            }


        }
    }
}
