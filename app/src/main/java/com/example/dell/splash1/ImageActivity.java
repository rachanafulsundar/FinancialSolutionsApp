package com.example.dell.splash1;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class ImageActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        viewPager =(ViewPager)findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),5000,9000);
    }

    public class MyTimerTask extends TimerTask{

        @Override
        public void run() {

            ImageActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    }
                    else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }
                    else if(viewPager.getCurrentItem() == 2){
                        viewPager.setCurrentItem(3);
                    }
                    else if(viewPager.getCurrentItem() == 3){
                        viewPager.setCurrentItem(4);
                    }
                    else if(viewPager.getCurrentItem() == 4){
                        viewPager.setCurrentItem(5);
                    }
                    else if(viewPager.getCurrentItem() == 5){
                        viewPager.setCurrentItem(6);
                    }
                    else if(viewPager.getCurrentItem() == 6){
                        viewPager.setCurrentItem(7);
                    }
                    else if(viewPager.getCurrentItem() == 7){
                        viewPager.setCurrentItem(8);
                    }
                    else if(viewPager.getCurrentItem() == 8){
                        viewPager.setCurrentItem(9);
                    }
                    else{
                        viewPager.setCurrentItem(0);

                    }

                }
            });

        }
    }
}

