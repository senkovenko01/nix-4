package ua.com.alevel.util;

import ua.com.alevel.annotation.UserCsv;
import ua.com.alevel.model.CsvData;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class CsvMapper {

    public static <T> List<T> map(Class<T> tClass, CsvData csvData) {
        List<T> result = new ArrayList<>();

        try {
            for (int i = 0; i < csvData.size(); i++) {
                Constructor<T> constructor = tClass.getConstructor();
                T target = constructor.newInstance();

                for (Field field : target.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(UserCsv.class)) {
                        UserCsv userCsv = field.getAnnotation(UserCsv.class);
                        String header = userCsv.value();

                        if (field.getType() == Integer.class || field.getType() == int.class) {
                            field.set(target, Integer.parseInt(csvData.getUsersByRowNumberAndNameOfColumn(i, header)));
                        } else if (field.getType() == String.class) {
                            field.set(target, csvData.getUsersByRowNumberAndNameOfColumn(i, header));
                        } else if (field.getType() == Long.class || field.getType() == long.class) {
                            field.set(target, Long.parseLong(csvData.getUsersByRowNumberAndNameOfColumn(i, header)));
                        } else if (field.getType() == Float.class || field.getType() == float.class) {
                            field.set(target, Float.parseFloat(csvData.getUsersByRowNumberAndNameOfColumn(i, header)));
                        } else if (field.getType() == Double.class || field.getType() == double.class) {
                            field.set(target, Double.parseDouble(csvData.getUsersByRowNumberAndNameOfColumn(i, header)));
                        } else if (field.getType() == Boolean.class || field.getType() == boolean.class) {
                            field.set(target, Boolean.parseBoolean(csvData.getUsersByRowNumberAndNameOfColumn(i, header)));
                        } else throw new UnsupportedOperationException("Unsupported type!");
                    }
                }
                result.add(target);
            }


        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
