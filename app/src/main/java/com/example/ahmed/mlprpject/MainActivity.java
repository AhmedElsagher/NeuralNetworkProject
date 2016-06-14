package com.example.ahmed.mlprpject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText numOfIteration;
    private EditText numOfInput;
    private EditText learningRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numOfInput= (EditText) findViewById(R.id.input);
        numOfIteration= (EditText) findViewById(R.id.iter);
        learningRate= (EditText) findViewById(R.id.rate);

    }
    public void next(View v){
        Intent intent =new Intent(this,DOut.class);
        intent.putExtra("numOfInput",numOfInput.getText().toString());
        intent.putExtra("numOfIteration",numOfIteration.getText().toString());
        intent.putExtra("learnRate",learningRate.getText().toString());
        startActivity(intent);


    }
}
