package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LogsActivity extends AppCompatActivity {

    private String finalLog;

    @BindView(R.id.logsTextView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        ButterKnife.bind(this);

        showLog();
    }


    private void showLog(){
        //fetching the data (ArrayList<String>) from the MainActivity class
        Intent intent = getIntent();

        List<String> message = new ArrayList<>();
        message = intent.getStringArrayListExtra(MainActivity.LOG_MESSAGE);

        finalLog = "";
        for (String c : message) {
            finalLog += c + " \n";
        }

        textView = findViewById(R.id.logsTextView);
        textView.setText(finalLog);
    }



    //this action is incomplete - the action would need to clean the ArrayList<CalcLog> at MainActivity class
    //at the moment it only cleans the history present at this activity.
    @OnClick(R.id.clearLog)
    public void clearLog(){
        finalLog="";
        textView.setText("");
     }

}
