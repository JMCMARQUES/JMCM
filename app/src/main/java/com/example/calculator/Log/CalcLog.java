package com.example.calculator.Log;

import java.util.LinkedList;

public class CalcLog {

    private Double oldNumber;
    private Double newNumber;
    private Double result;
    private String operation;
    private LinkedList<String> logList = new LinkedList<>();


    public CalcLog(String operation, Double oldNumber, Double newNumber, Double result) {
        this.operation = operation;
        this.oldNumber = oldNumber;
        this.newNumber = newNumber;
        this.result = result;
    }

    public String getPrintInfo()
    {
        return oldNumber+operation+newNumber+" = "+result;
    }

    public void printData(){
        System.err.println(oldNumber+operation+newNumber+" = "+result);
    }

}
