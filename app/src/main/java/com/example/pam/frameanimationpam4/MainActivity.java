package com.example.pam.frameanimationpam4;

import android.app.ProgressDialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgressBar;
    private TextView mLoadingText;

    private int mProgressStatus = 0;


    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.buttonstart);
        Button stop = (Button) findViewById(R.id.buttonstop);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mLoadingText = (TextView) findViewById(R.id.LoadingCompleteTextView);
        ImageView girl = (ImageView) findViewById(R.id.imageViewgirl);

        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ImageView girl = (ImageView) findViewById(R.id.imageViewgirl);
                girl.setImageResource(R.drawable.girlwalking);
                AnimationDrawable girlwalking = (AnimationDrawable) girl.getDrawable();
                girlwalking.start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (mProgressStatus < 100) {
                            mProgressStatus++;
                            android.os.SystemClock.sleep(50);
                            mHandler.post(new Runnable() {

                                @Override
                                public void run() {
                                    mProgressBar.setProgress(mProgressStatus);
                                }
                            });
                        }
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mLoadingText.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                }).start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView girl = (ImageView) findViewById(R.id.imageViewgirl);
                girl.setImageResource(R.drawable.girlwalking);
                AnimationDrawable girlwalking = (AnimationDrawable) girl.getDrawable();
                girlwalking.stop();
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }
}