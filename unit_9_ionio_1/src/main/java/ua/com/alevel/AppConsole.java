package ua.com.alevel;

import ua.com.alevel.consoleApplicationController.controller.MainController;

public class AppConsole {
    public static void main(String[] args) {
        MainController controller = new MainController();
        try {
            controller.run();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
