package ua.com.alevel.application;

import ua.com.alevel.service.Calculator;
import ua.com.alevel.service.ConsoleHelper;
import ua.com.alevel.service.factory.CalculatorFactory;
import ua.com.alevel.service.factory.ConsoleHelperFactory;

import java.math.BigInteger;

public class App {
    private final Calculator calculator = CalculatorFactory.getInstance().getCalculator();
    private final ConsoleHelper consoleHelper = ConsoleHelperFactory.getInstance().getConsoleHelper();


    public void console(){
        BigInteger a = consoleHelper.input().nextBigInteger();
        BigInteger b = consoleHelper.input().nextBigInteger();
        BigInteger res = calculator.sum(a,b);

        consoleHelper.output(res);
    }
}
