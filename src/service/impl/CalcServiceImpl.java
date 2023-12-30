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

    @Override
    public int device(int numberOne, int numberTwo) {
        boolean isTrue = true;
        try {
            if (numberTwo == 0 || numberOne ==0){
                isTrue = false;
                throw new ArithmeticException("Not device for 0 ");

            }
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
        if (isTrue){
            return numberOne / numberTwo;
        }else return 0;
    }

    @Override
    public int add(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }
}
