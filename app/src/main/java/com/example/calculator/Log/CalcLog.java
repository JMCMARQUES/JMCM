package com.example.calculator.Log;

public class CalcLog {

    private Double oldNumber;
    private Double newNumber;
    private Double result;
    private String operation;


    public CalcLog(String operation, Double oldNumber, Double newNumber, Double result) {
        this.operation = operation;
        this.oldNumber = oldNumber;
        this.newNumber = newNumber;
        this.result = result;
    }

    public String getPrintInfo() {
        return oldNumber + operation + newNumber + "=" + result;
    }

}
