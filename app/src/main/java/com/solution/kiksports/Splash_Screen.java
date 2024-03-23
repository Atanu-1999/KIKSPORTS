package com.solution.kiksports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Objects;

public class Splash_Screen extends AppCompatActivity {

    TextView one,two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getWindow().getContext(), R.color.app_color));

        one = (TextView) findViewById(R.id.one);
        two = (TextView) findViewById(R.id.two);

        Animation anim_right = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_r);
        one.startAnimation(anim_right);

        Animation anim_left = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_l);
        two.startAnimation(anim_left);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_Screen.this, MainActivity.class));
                finish();
            }
        }, 3000);
    }
}