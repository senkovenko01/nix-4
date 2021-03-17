package ua.com.alevel.service.impl;

import ua.com.alevel.service.ConsoleHelper;

import java.util.Scanner;

public class DefaultConsoleHelper implements ConsoleHelper {
    @Override
    public Scanner input() {
        return new Scanner(System.in);}

    @Override
    public void output(Object out) {

        System.out.println(out);
    }
}
