package com.example.countdown;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends Activity {
    private static final long startTime = 600000;
    private TextView mTextViewTimer;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;
    private boolean timerRunning = false;

    private long timeLeft = startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewTimer = findViewById(R.id.tvTimer);

        mButtonStartPause = findViewById(R.id.btnStart);
        mButtonReset = findViewById(R.id.btnReset);

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timerRunning)
                    startTimer();
                else {
                    pauseTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountText();
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                updateCountText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();
        timerRunning = true;
        mButtonStartPause.setText("Pause");
        mButtonStartPause.setTextColor(Color.parseColor("#FF0000"));
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        timerRunning = false;

        if (timeLeft < startTime) {
            mButtonStartPause.setText("Resume");
            mButtonStartPause.setTextColor(Color.parseColor("#00CC00"));
        } else {
            mButtonStartPause.setText("Start");
            mButtonStartPause.setTextColor(Color.parseColor("#FF0000"));
        }

        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        timeLeft = startTime;
        updateCountText();
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountText() {
        int minutes = (int) timeLeft / 1000 / 60;
        int seconds = (int) timeLeft / 1000 % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewTimer.setText(timeLeftFormatted);
    }
}
