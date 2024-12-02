package com.example.dell.splash1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Vector;

public class VideoActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    //Vector for video URL
    Vector<YoutubeVideo> youtubeVideos = new Vector<YoutubeVideo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //load video list

        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/F3QpgXBtDeo\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/7Qo_f7Gzqds\" frameborder=\"0\" allowfullscreen></iframe>"));

        VideoAdapter videoAdapter=new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);
    }
}
