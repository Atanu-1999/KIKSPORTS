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
import android.view.animation.TranslateAnimation;
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

        // Animation from middle to right
        Animation animationRight = new TranslateAnimation(0, 1000, 0, 0); // Adjust the value 200 as per your requirement
        animationRight.setDuration(1000); // Set duration for animation in milliseconds
        animationRight.setFillAfter(true); // Keep the final state of the animation
        one.startAnimation(animationRight);

        // Animation from middle to left
        Animation animationLeft = new TranslateAnimation(0, -1000, 0, 0); // Adjust the value -200 as per your requirement
        animationLeft.setDuration(1000); // Set duration for animation in milliseconds
        animationLeft.setFillAfter(true); // Keep the final state of the animation
        two.startAnimation(animationLeft);

//        Animation anim_right = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_r);
//        one.startAnimation(anim_right);
//
//        Animation anim_left = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_l);
//        two.startAnimation(anim_left);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_Screen.this, MainActivity.class));
                finish();
            }
        }, 2000);
    }
}