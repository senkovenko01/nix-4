package ua.com.alevel.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class WriteAndReadFromFiles {

    public static List<String> readFromFile (String pathName){
        List <String> list = new ArrayList<>();
        File file = new File(pathName);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("INVALID FILE PATH");
        }
        return list;
    }

    public static void writeToFile (List<String> list, String pathName){
        try {
        FileWriter writer = new FileWriter(pathName);
        for(String l : list){
            writer.write(l + "\n");
        }
        writer.close();
        } catch (IOException e) {
            System.out.println( "INVALID FILE PATH");
        }
    }
}
