package com.example.dell.splash1;

/**
 * Created by dell on 13/10/17.
 */
public class YoutubeVideo {

    String videoUrl;

    public YoutubeVideo(){

    }

    public YoutubeVideo(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
