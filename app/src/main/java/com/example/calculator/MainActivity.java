package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculator.operationsPackage.Core;

public class MainActivity extends AppCompatActivity {

    private String operator;
    private Core core = new Core();

    private EditText userInput;
    private TextView resultDisplay;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.writeHere);
        resultDisplay = findViewById(R.id.display);
    }

    /**
     * @param view
     */
    public void sum(View view) {
        operator = "+";
        fetchSendNumber(operator);
        clearAll(view);
    }

    /**
     * @param view
     */
    public void minus(View view) {
        operator = "-";
        fetchSendNumber(operator);
        clearAll(view);
    }

    /**
     * @param view
     */
    public void multiply(View view) {
        operator = "*";
        fetchSendNumber(operator);
        clearAll(view);
    }

    /**
     * @param view
     */
    public void divide(View view) {
        operator = "/";
        fetchSendNumber(operator);
        clearAll(view);
    }

    /**
     * @param view
     */
    public void clearLast(View view) {
        String returnMessage;
        if (! userInput.getText().toString().equals("")) {
            String message = userInput.getText().toString();
            returnMessage = message.substring(0, message.length() - 1);
            userInput.setText(returnMessage);
            userInput.setSelection(returnMessage.length());
        }
    }

    /**
     * @param view
     */
    public void clearAll(View view) {
        userInput.setText("");
    }

    /**
     * @param view
     */
    public void clearCalc(View view) {
        resultDisplay.setText("0");
    }

    /**
     * @param view
     */
    public void result(View view) {
        if (operator == null) {
        } else {
            fetchSendNumber(operator);
        }
        clearAll(view);
    }

    /**
     * @param view
     */
    public void percentage(View view) {
        operator = "%";
        fetchSendNumber(operator);
        clearAll(view);
    }

    /**
     * @param view
     */
    public void rootSq(View view) {
        operator = "squareRoot";
        fetchSendNumber(operator);
        clearAll(view);
    }

    /**
     * @param view
     */
    public void pot(View view) {
        operator = "pot";
        fetchSendNumber(operator);
        clearAll(view);
    }

    /**
     * @param view
     */
    public void inverse(View view) {
        operator = "inv";
        fetchSendNumber(operator);
        clearAll(view);
    }

    /**
     * @param view
     */
    public void tenPot(View view) {
        operator = "tenPot";
        fetchSendNumber(operator);
        clearAll(view);
    }

    /**
     * @param view
     */
    public void log(View view) {
        operator = "log";
        fetchSendNumber(operator);
        clearAll(view);
    }

    /**
     * @param operator
     */
    private void fetchSendNumber(String operator) {

        if (!userInput.getText().toString().equals("")) {
            double oldNumber = Double.parseDouble(resultDisplay.getText().toString());
            double introducedNumber = Double.parseDouble(userInput.getText().toString());

            if (oldNumber == 0 && !operator.equals("%") && !operator.equals("squareRoot") && !operator.equals("pot") && !operator.equals("inv") && !operator.equals("tenPot") && !operator.equals("log")) {
                resultDisplay.setText(String.valueOf(introducedNumber));
            } else {
                double result = core.calculate(operator, oldNumber, introducedNumber);
                String finalValue = String.valueOf(result);
                resultDisplay.setText(finalValue);
            }
        }
    }
}
