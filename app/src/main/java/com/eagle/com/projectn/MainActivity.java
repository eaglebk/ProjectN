package com.eagle.com.projectn;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int iChislo;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.textView);
        etInput = (EditText) findViewById(R.id.editText);
        bControl = (Button) findViewById(R.id.button);

        Random rand = new Random();
        gameFinished = false;
        iChislo = 0;
        iChislo = rand.nextInt(100);
        //guess = (int)(Math.random()*100);


    }

    public void onClick(View v) {
        if (!gameFinished) {
            int inp = Integer.parseInt(etInput.getText().toString());
            if (inp > iChislo)
                tvInfo.setText(getResources().getString(R.string.ahead));
            if (inp < iChislo)
                tvInfo.setText(getResources().getString(R.string.behind));
            if (inp == iChislo) {
                tvInfo.setText(getResources().getString(R.string.hit));
                bControl.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
            }
        } else {
            iChislo = (int) (Math.random() * 100);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
        etInput.setText("");
    }
}

