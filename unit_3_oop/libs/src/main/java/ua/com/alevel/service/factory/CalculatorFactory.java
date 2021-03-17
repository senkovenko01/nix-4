package ua.com.alevel.service.factory;


import org.reflections.Reflections;
import ua.com.alevel.service.Calculator;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CalculatorFactory {

    private static CalculatorFactory instance;
    private Reflections reflections;
    private Set<Class<? extends Calculator>> calculators;
    private Map<Class<? extends Calculator>, Object> maps = new ConcurrentHashMap<>();

    private CalculatorFactory() {
        reflections = new Reflections("ua.com.alevel");
        calculators = reflections.getSubTypesOf(Calculator.class);
    }

    public static CalculatorFactory getInstance() {
        if (instance == null) {
            instance = new CalculatorFactory();
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
}
