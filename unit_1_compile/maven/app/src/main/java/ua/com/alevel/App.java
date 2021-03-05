package ua.com.alevel;

import ua.com.alevel.test.Example;
import ua.com.alevel.test.Test;

public class App {
    public static void main(String[] args) {
        Test test = new Test();
        Example example = new Example();
        test.print();
        example.count();
    }
}
