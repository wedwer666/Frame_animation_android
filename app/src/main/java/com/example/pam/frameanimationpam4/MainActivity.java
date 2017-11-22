package com.example.pam.frameanimationpam4;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = (Button) findViewById(R.id.buttonstart);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ImageView girl = (ImageView)findViewById(R.id.imageViewgirl);
                girl.setImageResource(R.drawable.girlwalking);
                AnimationDrawable girlwalking = (AnimationDrawable)girl.getDrawable();
                girlwalking.start();
            }
        });
    }
}
