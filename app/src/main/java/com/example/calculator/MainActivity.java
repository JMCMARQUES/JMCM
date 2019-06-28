package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator.Log.CalcLog;
import com.example.calculator.Operations.Core;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    private String operator;
    private Core core = new Core();
    private List<CalcLog> calcLogList = new ArrayList<>();
    private ArrayList<String> tempList = new ArrayList<>();

    private String operations;

    public static final String LOG_MESSAGE = "com.example.calculator.MESSAGE";
    public static final String SHARED_PREFS = "shared_prefs";
    public static final String OPERATIONS = "operations";

    //butterknife annotation to connect the EditText userInput to the activity_main.XML
    @BindView(R.id.writeHere)
    EditText userInput;

    //butterknife annotation to connect the TextView widget to the activity_main.XML
    @BindView(R.id.display)
    TextView resultDisplay;


    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //butterknife method to bind the annotated properties (@BindView) to activity_main.XML
        ButterKnife.bind(this);
        loadData();
    }


    /**
     * onClick annotation will link the method to a specific id target
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
     *
     */
    @OnClick(R.id.logs)
    public void logs() {
        //trasnforming the initial ArrayList of CalcLog objects into a  ArrayList of Strings
        for (CalcLog c : calcLogList) {
            tempList.add(c.getPrintInfo());
        }

        //new activity logsActivity
        Intent logsActivity = new Intent(this, LogsActivity.class);
        logsActivity.putStringArrayListExtra(LOG_MESSAGE, tempList);

        saveData(tempList);

        startActivity(logsActivity);
        calcLogList.clear();
    }


    /**
     * @param tempList
     */
    private void saveData(List<String> tempList) {
        //transforming the ArrayList<String> tempList data into a String to be saved using sharedPreferences
        String finalLog = "";
        for (String c : tempList) {
            finalLog += c + "\n";
        }

        //MODE_PRIVATE means that the saved data will not be accessed by other applications
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(OPERATIONS, finalLog);
        editor.apply();

        //message to be shown at the end of this method, with "Data Saved" indication
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }

    /**
     *
     */
    private void loadData() {
        //fetching the persisted data and treating it to be introduced back into the ArrayList<String> tempList
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        operations = sharedPreferences.getString(OPERATIONS, "");
        String[] operationsList = operations.split("\n");

        for (String c : operationsList) {
            tempList.add(c);
        }

        //message to be shown at the end of this method, with "Previous Data Loaded" indication
        Toast.makeText(this, "Previous Data Loaded", Toast.LENGTH_SHORT).show();
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

                //each operation will create an CalcLog object and will add it to the calcLogList ArrayList container
                CalcLog calcLog = new CalcLog(operator, oldNumber, introducedNumber, result);
                calcLogList.add(calcLog);


                String finalValue = String.valueOf(result);
                resultDisplay.setText(finalValue);
            }
        }
    }

}


