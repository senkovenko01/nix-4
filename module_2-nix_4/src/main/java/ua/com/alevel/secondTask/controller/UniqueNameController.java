package ua.com.alevel.secondTask.controller;

import ua.com.alevel.secondTask.UniqueName;
import ua.com.alevel.util.WriteAndReadFromFiles;

import java.util.Collections;
import java.util.List;

public class UniqueNameController {
    public static final String NAME_INPUT = "./src/main/resources/files/names/inputNames.txt";
    public static final String NAME_OUTPUT = "./src/main/resources/files/names/outputNames.txt";
    public void run(){
        System.out.println("        TASK NUMBER 2:      \n");
        System.out.println("````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````");
        System.out.println("Read input dates:");
        List<String> names = WriteAndReadFromFiles.readFromFile(NAME_INPUT);
        System.out.println(names);
        WriteAndReadFromFiles.writeToFile(Collections.singletonList(UniqueName.findUniqueName(names)),
                NAME_OUTPUT);
        System.out.print("Read output dates:");
        System.out.println(WriteAndReadFromFiles.readFromFile(NAME_OUTPUT));
        System.out.println();
        System.out.println("``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````");
    }
}
