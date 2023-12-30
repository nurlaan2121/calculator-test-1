package service.impl;

import service.CalcService;

public class CalcServiceImpl implements CalcService {


    @Override
    public int toFold(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    @Override
    public int subtraction(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }
}
