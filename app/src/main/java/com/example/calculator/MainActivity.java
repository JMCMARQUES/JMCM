package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.calculator.operationsPackage.Core;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.calculator.MESSAGE";
    private int operationId;
    private Core core;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sum(View view) {
        core.fetchNumberAndCalc("+");
        clearAll(view);
    }

    public void minus(View view) {
        core.fetchNumberAndCalc("-");
        clearAll(view);
    }

    public void multiply(View view) {
        core.fetchNumberAndCalc("*");
        clearAll(view);
    }

    public void divide(View view) {
        core.fetchNumberAndCalc("/");
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

}
