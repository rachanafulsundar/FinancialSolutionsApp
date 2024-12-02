package com.example.dell.splash1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Fdrd extends AppCompatActivity {

    Button b1;
    ImageView im1, im2, im3, im4, im5,im6,im7,im8,im9,im10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdrd);
//        t1=(TextView)findViewById(R.id.textView);

        final int bno1 = getIntent().getIntExtra("bno", 0);
//        t1.setText("hello"+bno1);

        im1 = (ImageView) findViewById(R.id.imageView);
        im1.setVisibility(View.INVISIBLE);

        im2 = (ImageView) findViewById(R.id.imageView2);
        im2.setVisibility(View.INVISIBLE);

        im3 = (ImageView) findViewById(R.id.imageView3);
        im3.setVisibility(View.INVISIBLE);

        im4 = (ImageView) findViewById(R.id.imageView4);
        im4.setVisibility(View.INVISIBLE);

        im5 = (ImageView) findViewById(R.id.imageView5);
        im5.setVisibility(View.INVISIBLE);

        im6 = (ImageView) findViewById(R.id.imageView6);
        im6.setVisibility(View.INVISIBLE);

        im7 = (ImageView) findViewById(R.id.imageView7);
        im7.setVisibility(View.INVISIBLE);

        im8 = (ImageView) findViewById(R.id.imageView8);
        im8.setVisibility(View.INVISIBLE);

        im9 = (ImageView) findViewById(R.id.imageView9);
        im9.setVisibility(View.INVISIBLE);

        im10 = (ImageView) findViewById(R.id.imageView10);
        im10.setVisibility(View.INVISIBLE);
        if (bno1==1) {
            im1.setVisibility(View.VISIBLE);
            im6.setVisibility(View.VISIBLE);
        }
        if (bno1==2) {
            im2.setVisibility(View.VISIBLE);
            im7.setVisibility(View.VISIBLE);
        }
        if (bno1==3) {
            im3.setVisibility(View.VISIBLE);
            im8.setVisibility(View.VISIBLE);
        }
        if (bno1==4) {
            im4.setVisibility(View.VISIBLE);
            im9.setVisibility(View.VISIBLE);
        }
        if (bno1==5) {
            im5.setVisibility(View.VISIBLE);
            im10.setVisibility(View.VISIBLE);
        }

    }
}
