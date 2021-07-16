package ua.com.alevel.util;

import ua.com.alevel.model.entity.Student;

import java.util.List;

public class TheBestGroupFinder {
    public double calculateMedianMark(List<Student> students){
        if(students.size()%2!=0) return students.get(students.size()/2).getMark().getMark();
        else return (students.get(students.size()/2-1).getMark().getMark()
                + students.get(students.size()/2 +1).getMark().getMark())/2;
    }
}
