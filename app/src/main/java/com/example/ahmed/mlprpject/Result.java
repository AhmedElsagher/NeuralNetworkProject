package com.example.ahmed.mlprpject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    private float w1, w2, theta;
    private TextView weight1;
    private TextView weight2;
    private TextView thetaTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        weight1 = (TextView) findViewById(R.id.we1);
        weight2 = (TextView) findViewById(R.id.we2);
        thetaTV = (TextView) findViewById(R.id.thta);
        Intent intent = getIntent();
        w1 = intent.getFloatExtra("w1", 0);
        w2 = intent.getFloatExtra("w2", 0);
        theta = intent.getFloatExtra("theta", 0);
        weight1.append(" " + w1);
        weight2.append(" " + w2);
        thetaTV.append(" " + theta);


    }
}
