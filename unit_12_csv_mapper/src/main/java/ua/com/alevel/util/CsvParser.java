package ua.com.alevel.util;

import ua.com.alevel.model.CsvData;

import java.io.InputStream;
import java.util.Scanner;

public class CsvParser {

    public static CsvData parse(InputStream stream) {
        CsvData res = new CsvData();

        Scanner scanner;

        scanner = new Scanner(stream);

        while (scanner.hasNext()) {
            res.add(scanner.nextLine().split(","));
        }
        return res;
    }
}
