package ua.com.alevel;


import ua.com.alevel.controller.MainController;

import java.io.IOException;

public class ModuleApplication {

    public static void main(String[] args) {
        MainController mainController = new MainController();
        try {
            mainController.run();
        } catch (IOException e) {
            System.out.println("INVALID FILE PATH" );
        }
    }
}
