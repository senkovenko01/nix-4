package ua.com.alevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public final class ParseProperty {

    public <T> T create(Properties properties, Class<T> c) {
        try {
            Constructor<T> constructor = c.getConstructor();

            T target = constructor.newInstance();

            for (Field field : c.getFields()) {
                PropertyKey propertyKey = field.getAnnotation(PropertyKey.class);
                if (propertyKey == null) continue;
                String prop = properties.getProperty(propertyKey.value());
                if (prop == null) continue;

                Class<?> type = field.getType();
                if (type == String.class) {
                    field.set(target, prop);
                } else if (type == int.class || type == Integer.class) {
                    field.set(target, Integer.parseInt(prop));
                } else if (type == long.class || type == Long.class) {
                    field.set(target, Long.parseLong(prop));
                } else if (type == boolean.class || type == Boolean.class) {
                    field.set(target, Boolean.parseBoolean(prop));
                } else if (type == double.class || type == Double.class) {
                    field.set(target, Double.parseDouble(prop));
                } else throw new UnsupportedOperationException("UnsupportedOperation");
            }
            return target;

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }

}




























   /* public <T> T parse(Properties properties, Class<T> tClass) {

        try {
            Constructor<T> constructor = tClass.getConstructor();

            T target = constructor.newInstance();

            for (Field field : tClass.getFields()) {
                PropertyKey propertyKey = field.getAnnotation(PropertyKey.class);
                if (propertyKey == null) continue;
                String prop = properties.getProperty(propertyKey.value());
                if (prop == null) continue;

                Class<?> type = field.getType();
                if (type == String.class) {
                    field.set(target, prop);
                } else if (type == boolean.class) {
                    field.set(target, Boolean.parseBoolean(prop));
                } else if (type == int.class) {
                    field.set(target, Integer.parseInt(prop));
                } else if (type == long.class || type == Long.class) {
                    field.setLong(target, Long.parseLong(prop));
                } else if (type == double.class || type == Double.class) {
                    field.setDouble(target, Double.parseDouble(prop));
                } else {
                    throw new UnsupportedOperationException("Unsupported operation");
                }
            }

            return target;

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }*/

