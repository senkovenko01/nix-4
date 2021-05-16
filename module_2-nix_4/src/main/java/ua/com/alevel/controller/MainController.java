package ua.com.alevel.controller;

import ua.com.alevel.firstTask.controller.DatesFormatController;
import ua.com.alevel.secondTask.controller.UniqueNameController;
import ua.com.alevel.thirdTask.controller.CitiesControlelr;

import java.io.IOException;

public class MainController {

//    public static final String DATE_INPUT = "./src/main/resources/files//inputDates.txt";
//    public static final String DATE_OUTPUT = "./src/main/resources/files/listOfDates/outputDates.txt";
//    public static final String NAME_INPUT = "./src/main/resources/files/listOfNames/inputNames.txt";
//    public static final String NAME_OUTPUT = "./src/main/resources/files/listOfNames/outputNames.txt";
//    public static final String CITY_INPUT = "./src/main/resources/files/listOfCities/inputCities.txt";
//    public static final String CITY_OUTPUT = "./src/main/resources/files/listOfCities/outputCities.txt";
public static CitiesControlelr t3 = new CitiesControlelr();
public static UniqueNameController s = new UniqueNameController();
public static DatesFormatController f = new DatesFormatController();
    public void run() throws IOException {

        f.run();

        s.run();

        t3.run();
    }
}
