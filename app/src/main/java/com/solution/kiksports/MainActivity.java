package com.solution.kiksports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.solution.kiksports.fragment.Channel_Fragment;
import com.solution.kiksports.fragment.Home;
import com.solution.kiksports.fragment.Profile;
import com.solution.kiksports.fragment.Schedule;
import com.solution.kiksports.fragment.Shorts;

public class MainActivity extends AppCompatActivity {

    LinearLayout scroll_layout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getWindow().getContext(), R.color.app_color));

        scroll_layout = findViewById(R.id.scroll_layout);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        // Display the default fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new Home()).commit();
        scroll_layout.setVisibility(View.VISIBLE);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.navigation_home) {
                    selectedFragment = new Home();
                    scroll_layout.setVisibility(View.VISIBLE);
                }
                else if (item.getItemId() == R.id.navigation_schedule) {
                    selectedFragment = new Schedule();
                    scroll_layout.setVisibility(View.VISIBLE);
                }
                else if (item.getItemId() == R.id.navigation_channel) {
                    selectedFragment = new Channel_Fragment();
                    scroll_layout.setVisibility(View.GONE);
                }
                else if (item.getItemId() == R.id.navigation_shorts) {
                    selectedFragment = new Shorts();
                    scroll_layout.setVisibility(View.GONE);
                }
                else if (item.getItemId() == R.id.navigation_profile) {
                    selectedFragment = new Profile();
                    scroll_layout.setVisibility(View.GONE);
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                } else {
                    return false;
                }
            }
        });
    }
}