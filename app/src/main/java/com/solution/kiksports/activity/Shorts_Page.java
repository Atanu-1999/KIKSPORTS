package com.solution.kiksports.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.solution.kiksports.R;
import com.solution.kiksports.adapter.Short_Adapter;
import com.solution.kiksports.model.Short_Model;

import java.util.ArrayList;

public class Shorts_Page extends AppCompatActivity {

    ArrayList<Short_Model> shortModels = new ArrayList<>();
    ViewPager2 viewPager2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shorts_page);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getWindow().getContext(), R.color.app_color));

        Short_Model shortModel = new Short_Model("Title One","https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
        Short_Model shortModel1 = new Short_Model("Title Two","https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4");
        Short_Model shortModel2 = new Short_Model("Title Three","https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
        Short_Model shortModel3 = new Short_Model("Title Four","https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4");

        shortModels.add(shortModel);
        shortModels.add(shortModel1);
        shortModels.add(shortModel2);
        shortModels.add(shortModel3);

        viewPager2 = findViewById(R.id.view_short);
        Short_Adapter shortAdapter = new Short_Adapter(shortModels,getApplicationContext());
        viewPager2.setAdapter(shortAdapter);
    }
}