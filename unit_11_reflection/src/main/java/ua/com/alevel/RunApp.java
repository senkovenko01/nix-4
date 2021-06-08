package ua.com.alevel;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class RunApp {

    public static void main(String[] args) {

        Properties properties = ParseProperty.loadProp("/app.properties");
        ParseProperty parseProperty = new ParseProperty();
        AppProperties appProperties = parseProperty.create(properties, AppProperties.class);

        System.out.println("appProperties = " + appProperties.url);
        System.out.println("appProperties = " + appProperties.name);
        System.out.println("appProperties = " + appProperties.pinCode);
        System.out.println("appProperties = " + appProperties.isActive);
    }
}
