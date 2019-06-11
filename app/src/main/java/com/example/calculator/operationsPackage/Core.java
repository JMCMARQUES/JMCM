package com.example.calculator.operationsPackage;

public class Core {

    /**
     * @param operator
     * @param oldNumber
     * @param introducedN
     * @return
     */
    public double calculate(String operator, double oldNumber, double introducedN) {

        switch (operator) {
            case "+":
                return sum(oldNumber, introducedN);
            case "-":
                return minus(oldNumber, introducedN);
            case "*":
                return multiply(oldNumber, introducedN);
            case "/":
                return divide(oldNumber, introducedN);
            case "%":
                return percentage(introducedN);
            case "squareRoot":
                return squareRoot(introducedN);
            case "pot":
                return pot(introducedN);
            case "inv":
                return inverse(introducedN);
            case "tenPot":
                return powTen(introducedN);
            case "log":
                return log(introducedN);
            default:
                return -1;
        }
    }


    private double sum(double oldNumber, double newNumber) {
        return oldNumber + newNumber;
    }

    private double minus(double oldNumber, double newNumber) {
        return oldNumber - newNumber;
    }

    private double multiply(double oldNumber, double newNumber) {
        return oldNumber * newNumber;
    }

    private double divide(double oldNumber, double newNumber) {
        return oldNumber / newNumber;
    }

    private double percentage(double introducedN) {
        return introducedN / 100;
    }

    private double squareRoot(double introducedN) {
        return Math.sqrt(introducedN);
    }

    private double pot(double intoducedN) {
        return intoducedN * intoducedN;
    }

    private double powTen(double introducedN) {
        return Math.pow(10, introducedN);
    }

    private double inverse(double introducedN) {
        return 1 / introducedN;
    }

    private double log(double introducedN) {
        return Math.log10(introducedN);
    }

}
