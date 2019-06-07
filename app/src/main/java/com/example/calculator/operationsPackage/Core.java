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

        } else if (operator.equals("%")) {
            result = introducedN / 100;

        } else if (operator.equals("squareRoot")) {
            result = Math.sqrt(introducedN);

        } else if (operator.equals("pot")) {
            result = introducedN * introducedN;

        } else if (operator.equals("inv")) {
            result = 1 / introducedN;

        } else {
            result = 000000;
        }

        return result;
    }
}
