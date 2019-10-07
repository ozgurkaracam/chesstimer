package com.example.chesstimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CountDownTimer timerWhite,timerBlack;
    TextView textViewWhite,textViewBlack;
    Button buttonWhite,buttonBlack;
    long kalanBeyaz=1000*60*10;
    long kalanSiyah=1000*60*10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewWhite=findViewById(R.id.textViewWhite);
        textViewBlack=findViewById(R.id.textViewBlack);
        buttonWhite=findViewById(R.id.buttonWhite);
        buttonBlack=findViewById(R.id.buttonBlack);

        timerBlack=new CountDownTimer(kalanSiyah,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewBlack.setText(String.valueOf(millisUntilFinished));
                kalanSiyah=millisUntilFinished;

            }

            @Override
            public void onFinish() {

            }
        }.start();


        buttonWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerWhite.cancel();
                buttonWhite.setEnabled(false);
                buttonBlack.setEnabled(true);
                timerBlack=new CountDownTimer(kalanSiyah,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        textViewBlack.setText(millistostring(millisUntilFinished));
                        kalanSiyah=millisUntilFinished;

                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();

            }
        });
        buttonBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonBlack.setEnabled(false);
                buttonWhite.setEnabled(true);
                timerBlack.cancel();
                timerWhite=new CountDownTimer(kalanBeyaz,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        kalanBeyaz=millisUntilFinished;
                        textViewWhite.setText(millistostring(millisUntilFinished));
                    }

                    @Override
                    public void onFinish() {

                    }
                }.start();

            }
        });

    }
    private String millistostring(long millis){
        int saniye =(int) (millis/1000)%60;
        int dakika=(int) (millis/1000/60);
        String str;
        str=String.valueOf(dakika)+":"+String.valueOf(saniye);
        return str;
    }
}
