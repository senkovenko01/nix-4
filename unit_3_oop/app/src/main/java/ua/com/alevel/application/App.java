package ua.com.alevel.application;

import ua.com.alevel.service.Calculator;
import ua.com.alevel.service.ConsoleHelper;
import ua.com.alevel.service.factory.Factory;

import java.math.BigInteger;

public class App {
    private final Calculator calculator = Factory.getInstance().getCalculator();
    private final ConsoleHelper consoleHelper = Factory.getInstance().getConsoleHelper();


    public void console() {
        consoleHelper.output("Write two numbers");
        BigInteger a = consoleHelper.input().nextBigInteger();
        BigInteger b = consoleHelper.input().nextBigInteger();
        consoleHelper.output("Select operation:\n" +
                " \"1\" if you want calculate the sum\n" +
                " \"2\" if you want calculate the multiply\n" +
                "\"3\" if you want calculate the subtract");
        int check = consoleHelper.input().nextInt();
        switch (check) {

            case 1:
                consoleHelper.output("Result: " + calculator.sum(a, b));
                break;
            case 2:
                consoleHelper.output("Result: " + calculator.multiply(a, b));
                break;
            case 3:
                consoleHelper.output("Result: " + calculator.subtract(a, b));
                break;
            default:
                throw new RuntimeException("Incorrect variant!!!");
        }

    }
}
