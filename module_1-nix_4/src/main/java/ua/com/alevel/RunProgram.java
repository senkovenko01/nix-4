package ua.com.alevel;


import ua.com.alevel.application.ApplicationOfAllLevels;
import ua.com.alevel.level_1.api.ApplicationOfFirstLevel;
import ua.com.alevel.level_2.Brackets;
import ua.com.alevel.level_3.GameOfLife;

import java.util.Scanner;

public class RunProgram {
    public static ApplicationOfAllLevels application = new ApplicationOfAllLevels();

    public static void main(String[] args) {

        application.go();

    }
}
