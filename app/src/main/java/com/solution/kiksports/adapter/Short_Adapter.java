package com.solution.kiksports.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.solution.kiksports.R;
import com.solution.kiksports.model.Short_Model;

import java.util.ArrayList;

public class Short_Adapter extends RecyclerView.Adapter<Short_Adapter.ViewHolder> {
    ArrayList<Short_Model> shortList;
    Context context;

    public Short_Adapter(ArrayList<Short_Model> shortList, Context context) {
        this.shortList = shortList;
        this.context = context;
    }

    @NonNull
    @Override
    public Short_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.short_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Short_Adapter.ViewHolder holder, int position) {
        holder.videoView.setVideoURI(Uri.parse(shortList.get(position).getUrl()));
        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                holder.short_progress.setVisibility(View.GONE);
                mp.start();
                float videoRatio = mp.getVideoWidth()/(float)mp.getVideoHeight();
                float ScreenRatio = holder.videoView.getWidth()/(float)holder.videoView.getHeight();
                float scale = videoRatio/ScreenRatio;

                if (scale >= 1){
                    holder.videoView.setScaleX(scale);
                }
                else {
                    holder.videoView.setScaleY(1f/scale);
                }
            }
        });
        holder.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        holder.txt_title.setText(shortList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return shortList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_title, txt_count;
        VideoView videoView;
        ProgressBar short_progress;
        ImageView share_image,react_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_count = itemView.findViewById(R.id.txt_count);
            videoView = itemView.findViewById(R.id.videoView);
            short_progress = itemView.findViewById(R.id.short_progress);
            share_image = itemView.findViewById(R.id.share_image);
            react_image = itemView.findViewById(R.id.react_image);
        }
    }
}
