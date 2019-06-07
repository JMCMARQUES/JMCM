package com.example.calculator.operationsPackage;

public class Core {


    /**
     * @param operator
     * @param oldNumber
     * @param introducedN
     * @return
     */
    public double calculate(String operator, double oldNumber, double introducedN) {
        double result;

        if (operator.equals("+")) {
            result = oldNumber + introducedN;
        } else if (operator.equals("-")) {
            result = oldNumber - introducedN;
        } else if (operator.equals("*")) {
            result = oldNumber * introducedN;
        } else if (operator.equals("/")) {
            result = oldNumber / introducedN;
        } else {
            result = 000000;
        }

        return result;
    }
}
