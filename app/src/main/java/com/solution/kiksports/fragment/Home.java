package com.solution.kiksports.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.solution.kiksports.R;
import com.solution.kiksports.adapter.ImageAdapter;
import com.solution.kiksports.model.Slider_Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends Fragment {

    private ViewPager viewPager;
    private ImageAdapter sliderAdapter;
    private int[] images = {R.drawable.banner, R.drawable.banner_one, R.drawable.banner};
    TextView highlights;
    private Handler handler;
    private int[] rainbowColors;
    private int currentColorIndex = 0;
    private boolean isBlinking = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View home =  inflater.inflate(R.layout.fragment_home, container, false);
        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity().getWindow().getContext(), R.color.app_color));

        viewPager = home.findViewById(R.id.viewPager);
        sliderAdapter = new ImageAdapter(getContext(), images);
        viewPager.setAdapter(sliderAdapter);
        highlights = home.findViewById(R.id.highlights);
        handler = new Handler();

        // Rainbow colors
        rainbowColors = new int[]{
                Color.RED,
                Color.YELLOW,
                Color.GREEN,
                Color.CYAN,
                Color.BLUE,
                Color.MAGENTA
        };

        // Start changing text color and blinking after 1 second
        handler.postDelayed(colorChangeRunnable, 1000);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);

        return home;
    }
    private Runnable colorChangeRunnable = new Runnable() {
        @Override
        public void run() {
            if (isBlinking) {
                highlights.setVisibility(View.VISIBLE);
            } else {
                highlights.setVisibility(View.INVISIBLE);
            }
            highlights.setTextColor(rainbowColors[currentColorIndex]);
            currentColorIndex = (currentColorIndex + 1) % rainbowColors.length;
            isBlinking = !isBlinking;
            handler.postDelayed(this, 1000); // Change color every 1 second
        }
    };
    @Override
    public void onDestroy() {
        super.onDestroy();
        // Remove callbacks to prevent memory leaks
        handler.removeCallbacks(colorChangeRunnable);
    }
    private class SliderTimer extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < images.length - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
        private void runOnUiThread(Runnable runnable) {

        }
    }
}