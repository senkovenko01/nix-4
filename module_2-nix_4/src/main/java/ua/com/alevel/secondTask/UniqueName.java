package ua.com.alevel.secondTask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UniqueName {


    public static String findUniqueName(List<String> names) {
        Set<String> setOfNames = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (setOfNames.add(name))
                result.add(name);
            else result.remove(name);
        }
        System.out.println("THE RESULT OF FINDING FIRST UNIQUE NAME:  " + result.get(0));
        return result.get(0);
    }
}
