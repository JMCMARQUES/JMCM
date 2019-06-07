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

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        EditText editText = (EditText) findViewById(R.id.writeHere);
        String returnMessage;
        if (editText.getText().toString().equals("")) {
        } else {
            String message = editText.getText().toString();
            returnMessage = message.substring(0, message.length() - 1);
            editText.setText(returnMessage);
            editText.setSelection(returnMessage.length());
        }
    }

    /**
     * @param view
     */
    public void clearAll(View view) {
        EditText editText = findViewById(R.id.writeHere);
        editText.setText("");
    }

    /**
     * @param view
     */
    public void clearCalc(View view) {
        TextView textView = findViewById(R.id.display);
        textView.setText("0");
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

        EditText newNumber = (EditText) findViewById(R.id.writeHere);
        if (newNumber.getText().toString().equals("")) {
        } else {
            TextView existingNumber = (TextView) findViewById(R.id.display);
            double oldNumber = Double.parseDouble(existingNumber.getText().toString());
            double introducedNumber = Double.parseDouble(newNumber.getText().toString());
            double result;

            TextView textView = findViewById(R.id.display);
            if (oldNumber == 0 && operator != "%" && operator != "squareRoot" && operator != "pot" && operator != "inv" && operator != "tenPot" && operator != "log") {
                textView.setText(String.valueOf(introducedNumber));

            } else {
                result = core.calculate(operator, oldNumber, introducedNumber);
                String finalValue = String.valueOf(result);
                textView.setText(finalValue);
            }
        }
    }
}
