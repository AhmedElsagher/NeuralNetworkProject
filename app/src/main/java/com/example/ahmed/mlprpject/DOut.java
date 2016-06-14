package com.example.ahmed.mlprpject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class DOut extends AppCompatActivity {

    private EditText out1;
    private EditText out2;
    private EditText out3;
    private EditText out4;
    private float  numOfiterInteger,learnRateInteger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dout);
        out1= (EditText) findViewById(R.id.out1);
        out2= (EditText) findViewById(R.id.out2);
        out3= (EditText) findViewById(R.id.out3);
        out4= (EditText) findViewById(R.id.out4);

        Intent intent=getIntent();
        String numOdIteration=intent.getStringExtra("numOfIteration");
        String learnRate=intent.getStringExtra("learnRate");
        numOfiterInteger=Integer.valueOf(numOdIteration);
         learnRateInteger=Float.valueOf(learnRate);





    }
    public void getResult(View v){
        int[] out={
                Integer.valueOf(out1.getText().toString()),
                Integer.valueOf(out2.getText().toString()),
                Integer.valueOf(out3.getText().toString()),
                Integer.valueOf(out4.getText().toString()),
        };
        Random random=new Random();
        float w1=random.nextFloat()*(1-Float.MIN_VALUE)+.00001f;
        float w2=random.nextFloat()*(1-Float.MIN_VALUE)+.00001f;
        float theta=random.nextFloat()*(1-Float.MIN_VALUE)+.00001f;
        float summation;
        float[]y=new float[4];
        float[]e=new float[4];
        int []x2={0,0,1,1};
        int []x1={0,1,0,1};
        for (int i = 0; i < numOfiterInteger; i++) {
            for (int j = 0; j < 4; j++) {

                summation = ((x2[j]) * w2 + (x1[j]) * w1) - theta;
                if (summation >= 0) {
                    y[j] = 1;
                } else {
                    y[j] = 0;
                }
                e[j] = (out[j] - y[j]);
                if (e[j] != 0) {
                    w1 = w1 + learnRateInteger * e[j] * x1[j];
                    w2 = w2 + learnRateInteger * e[j] * x2[j];
                    theta=theta - learnRateInteger * e[j];
                }

            }

        } Toast.makeText(this,w1+ " "+w2, Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this,Result.class);
        intent.putExtra("w1",w1);
        intent.putExtra("w2",w2);
        intent.putExtra("theta",theta);
        startActivity(intent);
    }
}
