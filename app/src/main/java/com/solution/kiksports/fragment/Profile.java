package com.solution.kiksports.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solution.kiksports.ContactUs;
import com.solution.kiksports.HelpDesk;
import com.solution.kiksports.R;
import com.solution.kiksports.WebActivity;

public class Profile extends Fragment {

    LinearLayout contact_us,help_desk,about_layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View profile = inflater.inflate(R.layout.fragment_blank, container, false);

        contact_us = profile.findViewById(R.id.contact_us);
        help_desk = profile.findViewById(R.id.help_desk);
        about_layout = profile.findViewById(R.id.about_layout);
        help_desk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HelpDesk.class));
            }
        });
        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ContactUs.class));
            }
        });
        about_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("urls", "https://www.youtube.com/");
                Intent intent = new Intent(getContext(), WebActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

                startActivity(intent);
            }
        });

        return profile;
    }
}