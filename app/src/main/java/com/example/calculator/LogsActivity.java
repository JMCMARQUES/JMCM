package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class LogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        Intent intent = getIntent();
        ArrayList<String> message = intent.getStringArrayListExtra(MainActivity.LOG_MESSAGE);

        String finalMessage="";

        for (String c: message) {
            finalMessage += c + "\n";

        }

        TextView textView = findViewById(R.id.textView);
        textView.setText(finalMessage);

    }






}
