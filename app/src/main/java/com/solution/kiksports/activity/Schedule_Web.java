package com.solution.kiksports.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.solution.kiksports.R;

public class Schedule_Web extends AppCompatActivity {

    ImageView back;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_web);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getWindow().getContext(), R.color.app_color));

        back = findViewById(R.id.back);
        videoView = findViewById(R.id.videoView);

        // Specify the URL of the video
        String videoUrl = "https://kiksports.in/ratdin/embed.html";

        // Set the video URI
        Uri videoUri = Uri.parse(videoUrl);
        videoView.setVideoURI(videoUri);

        // Add media controller
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        // Start playing the video
        videoView.start();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}