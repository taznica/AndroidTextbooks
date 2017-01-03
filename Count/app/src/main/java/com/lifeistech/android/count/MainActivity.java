package com.lifeistech.android.count;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.textView);
        text.setText("0");
    }

    public void plus(View view) {
        number += 1;

        if(number == 10) {
            text.setTextColor(Color.RED);
        }

        text.setText(String.valueOf(number));
    }

    public void minus(View view) {
        number -= 1;

        if(number == 9) {
            text.setTextColor(Color.BLACK);
        }

        text.setText(String.valueOf(number));
    }

    public void clear(View view) {
        number = 0;
        text.setTextColor(Color.BLACK);
        text.setText(String.valueOf(number));

    }
}
