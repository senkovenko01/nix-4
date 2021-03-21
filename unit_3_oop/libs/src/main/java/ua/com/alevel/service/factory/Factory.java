package ua.com.alevel.service.factory;

import org.reflections.Reflections;
import ua.com.alevel.service.Calculator;
import ua.com.alevel.service.ConsoleHelper;

import java.util.Set;

public class Factory {
    private static Factory instance;
    private final Set<Class<? extends ConsoleHelper>> consoleHelpers;
    private final Set<Class<? extends Calculator>> calculators;

    private Factory() {
        Reflections reflections = new Reflections("ua.com.alevel");
        calculators = reflections.getSubTypesOf(Calculator.class);
        consoleHelpers = reflections.getSubTypesOf(ConsoleHelper.class);
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public Calculator getCalculator() {
        for (Class<? extends Calculator> calculator : calculators) {
            if (!calculator.isAnnotationPresent(Deprecated.class)) {
                try {
                    return calculator.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("RuntimeException");
                }
            }
        }
        throw new RuntimeException("RuntimeException");
    }

    public ConsoleHelper getConsoleHelper() {
        for (Class<? extends ConsoleHelper> consoleHelper : consoleHelpers) {
            if (!consoleHelper.isAnnotationPresent(Deprecated.class)) {
                try {
                    return consoleHelper.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("RuntimeException");
                }
            }
        }
        throw new RuntimeException("RuntimeException");
    }


}
