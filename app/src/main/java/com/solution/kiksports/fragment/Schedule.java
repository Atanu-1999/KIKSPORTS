package com.solution.kiksports.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.solution.kiksports.R;
import com.solution.kiksports.activity.Schedule_Web;

public class Schedule extends Fragment {

    LinearLayout btn_live;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View schedule =  inflater.inflate(R.layout.fragment_schedule, container, false);

        btn_live = schedule.findViewById(R.id.btn_live);
        btn_live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Schedule_Web.class));
            }
        });

        return schedule;
    }
}