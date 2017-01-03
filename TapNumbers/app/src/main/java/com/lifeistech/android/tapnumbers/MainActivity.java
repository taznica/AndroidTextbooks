package com.lifeistech.android.tapnumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] array;
    String problem;
    int answer;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);

        start();
    }

    public void start() {
        array = new int[4];
        Random r = new Random();
        problem = "";

        for(int i = 0; i < 4; i++) {
            array[i] = r.nextInt(4) + 1;
            problem += Integer.toString(array[i]);
        }

        textView.setText(problem);
        answer = 0;
    }

    public void number1(View view) {
        if(array[answer] == 1) {
            problem = problem.substring(1);
            textView.setText(problem);
            answer += 1;

            if(answer == 4) {
                start();
            }
        }
        else {
            Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
        }


    }

    public void number2(View view) {
        if(array[answer] == 2) {
            problem = problem.substring(1);
            textView.setText(problem);
            answer += 1;

            if(answer == 4) {
                start();
            }
        }
        else {
            Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void number3(View view) {
        if(array[answer] == 3) {
            problem = problem.substring(1);
            textView.setText(problem);
            answer += 1;

            if(answer == 4) {
                start();
            }
        }
        else {
            Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void number4(View view) {
        if(array[answer] == 4) {
            problem = problem.substring(1);
            textView.setText(problem);
            answer += 1;

            if(answer == 4) {
                start();
            }
        }
        else {
            Toast.makeText(this, "wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
