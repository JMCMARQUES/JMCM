package com.example.calculator.operationsPackage;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.calculator.R;

public class Core extends AppCompatImageView {


    public Core(Context context) {
        super(context);
    }

    public void fetchNumberAndCalc(String operator) {

        TextView introducedNumber = (TextView) findViewById(R.id.display);
        double oldNumber = Integer.parseInt(introducedNumber.getText().toString());

        EditText newNumber = (EditText) findViewById(R.id.writeHere);
        double introducedN = Integer.parseInt(newNumber.getText().toString());

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
