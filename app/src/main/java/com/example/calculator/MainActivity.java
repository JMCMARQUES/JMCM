package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.calculator.MESSAGE";
    private int operationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sum(View view) {
        fetchNumberAndCalc("+");
        clearAll(view);
    }

    public void minus(View view) {
        fetchNumberAndCalc("-");
        clearAll(view);
    }

    public void multiply(View view) {
        fetchNumberAndCalc("*");
        clearAll(view);
    }

    public void divide(View view) {
        fetchNumberAndCalc("/");
        clearAll(view);
    }

    public void clearLast(View view) {
        EditText editText = (EditText) findViewById(R.id.writeHere);
        String message = editText.getText().toString();
        String returnMessage=message.substring(0,message.length()-1);

        editText.setText(returnMessage);
    }

    public void clearAll(View view) {
        EditText editText = findViewById(R.id.writeHere);
        editText.setText("0");
    }

    public void result(View view) {

        clearAll(view);
    }


    /**
     * @param
     */
    private void fetchNumberAndCalc(String operator) {

        TextView introducedNumber = (TextView) findViewById(R.id.display);
        double oldNumber = Double.parseDouble(introducedNumber.getText().toString());

        EditText newNumber = (EditText) findViewById(R.id.writeHere);
        double introducedN = Double.parseDouble(newNumber.getText().toString());

        TextView textView = findViewById(R.id.display);
        double result;

        if (oldNumber == 0) {
            textView.setText(String.valueOf(introducedN));

        } else {
            if (operator.equals("+")) {
                result = oldNumber + introducedN;
            } else if (operator.equals("-")) {
                result = oldNumber - introducedN;
            } else if (operator.equals("*")) {
                result = oldNumber * introducedN;
            } else if (operator.equals("/")) {
                result = oldNumber / introducedN;
            } else {
                result = 0;
            }
            String finalValue = String.valueOf(result);
            textView.setText(finalValue);
        }
    }
}
