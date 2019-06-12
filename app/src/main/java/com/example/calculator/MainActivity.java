package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculator.operationsPackage.Core;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private String operator;
    private Core core = new Core();

    @BindView(R.id.writeHere)
    EditText userInput;

    @BindView(R.id.display)
    TextView resultDisplay;


    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }


    /**
     *
     */
    @OnClick(R.id.plus)
    public void sum() {
        operator = "+";
        fetchSendNumber(operator);
        userInput.setText("");
    }

    /**
     *
     */
    @OnClick(R.id.minus)
    public void minus() {
        operator = "-";
        fetchSendNumber(operator);
        userInput.setText("");
    }

    /**
     *
     */
    @OnClick(R.id.multip)
    public void multiply() {
        operator = "*";
        fetchSendNumber(operator);
        userInput.setText("");
    }

    /**
     *
     */
    @OnClick(R.id.divide)
    public void divide() {
        operator = "/";
        fetchSendNumber(operator);
        userInput.setText("");
    }

    /**
     *
     */
    @OnClick(R.id.clrLast)
    public void clearLast() {
        String returnMessage;
        if (!userInput.getText().toString().equals("")) {
            String message = userInput.getText().toString();
            returnMessage = message.substring(0, message.length() - 1);
            userInput.setText(returnMessage);
            userInput.setSelection(returnMessage.length());
        }
    }

    /**
     *
     */
    @OnClick(R.id.clrAll)
    public void clearAll() {
        userInput.setText("");
    }

    /**
     *
     */
    @OnClick(R.id.clearCalc)
    public void clearCalc() {
        resultDisplay.setText("0");
    }

    /**
     *
     */
    @OnClick(R.id.equals)
    public void result() {
        if (operator == null) {
        } else {
            fetchSendNumber(operator);
        }
        userInput.setText("");
    }

    /**
     *
     */
    @OnClick(R.id.percent)
    public void percentage() {
        operator = "%";
        fetchSendNumber(operator);
        userInput.setText("");
    }

    /**
     *
     */
    @OnClick(R.id.rSquare)
    public void rootSq() {
        operator = "squareRoot";
        fetchSendNumber(operator);
        userInput.setText("");
    }

    /**
     *
     */
    @OnClick(R.id.poten2)
    public void pot() {
        operator = "pot";
        fetchSendNumber(operator);
        userInput.setText("");
    }

    /**
     *
     */
    @OnClick(R.id.inverse)
    public void inverse() {
        operator = "inv";
        fetchSendNumber(operator);
        userInput.setText("");
    }

    /**
     *
     */
    @OnClick(R.id.tenPot)
    public void tenPot() {
        operator = "tenPot";
        fetchSendNumber(operator);
        userInput.setText("");
    }

    /**
     *
     */
    @OnClick(R.id.log)
    public void log() {
        operator = "log";
        fetchSendNumber(operator);
        userInput.setText("");
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
