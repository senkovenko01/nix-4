package ua.com.alevel.firstTask.controller;

import ua.com.alevel.firstTask.DatesFormat;
import ua.com.alevel.util.WriteAndReadFromFiles;

import java.util.List;

public class DatesFormatController {
    public static final String DATE_INPUT = "./src/main/resources/files/dates/inputDates.txt";
    public static final String DATE_OUTPUT = "./src/main/resources/files/dates/outputDates.txt";

    public void run(){
        System.out.println("        TASK NUMBER 1:      \n");
        System.out.println("````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````");
        System.out.println("Read input dates:");
        List<String> dates = WriteAndReadFromFiles.readFromFile(DATE_INPUT);
        System.out.println(dates);
        WriteAndReadFromFiles.writeToFile(DatesFormat.findCorrectDate(dates),
                DATE_OUTPUT);
        System.out.print("Read output dates:");
        System.out.println(WriteAndReadFromFiles.readFromFile(DATE_OUTPUT));
        System.out.println("````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````");
    }
}
