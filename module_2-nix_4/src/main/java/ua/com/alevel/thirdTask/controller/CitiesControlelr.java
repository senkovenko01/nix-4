package ua.com.alevel.thirdTask.controller;

import ua.com.alevel.thirdTask.Cities;
import ua.com.alevel.util.WriteAndReadFromFiles;

public class CitiesControlelr {

    public void run() {
        System.out.println("        TASK NUMBER 3:      \n");
        System.out.println("````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````");
        Cities.run();
        System.out.print("Read output dates:");
        System.out.println(WriteAndReadFromFiles.readFromFile(Cities.CITY_OUTPUT));
        System.out.println();
        System.out.println("````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````");

    }
}
