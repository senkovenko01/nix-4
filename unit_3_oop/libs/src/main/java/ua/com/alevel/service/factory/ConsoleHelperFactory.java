package ua.com.alevel.service.factory;

import org.reflections.Reflections;
import ua.com.alevel.service.ConsoleHelper;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConsoleHelperFactory {
    public static ConsoleHelperFactory instance;
    private Reflections reflections;
    private Set<Class<? extends ConsoleHelper>> consoleHelpers;
    private Map<Class<? extends ConsoleHelper>, Object> maps = new ConcurrentHashMap<>();

    private ConsoleHelperFactory() {
        reflections = new Reflections("ua.com.alevel");
        consoleHelpers = reflections.getSubTypesOf(ConsoleHelper.class);
    }

    public static ConsoleHelperFactory getInstance() {
        if (instance == null) {
            instance = new ConsoleHelperFactory();
        }
        return instance;
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
