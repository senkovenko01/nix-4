package ua.com.alevel.service.impl;

import ua.com.alevel.service.Calculator;

import java.math.BigInteger;

public class DefaultCalculator implements Calculator {

    @Override
    public BigInteger sum(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    @Override
    public BigInteger multiply(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    @Override
    public BigInteger subtract(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }
}
