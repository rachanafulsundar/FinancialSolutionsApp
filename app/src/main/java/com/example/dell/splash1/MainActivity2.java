package com.example.dell.splash1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity2 extends AppCompatActivity {

    TextView t8, t11, t12;
    ImageView im1, im2, im3, im4, im5, im6, im7;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t8 = (TextView) findViewById(R.id.textView8);
        t11 = (TextView) findViewById(R.id.textView11);
        t12 = (TextView) findViewById(R.id.textView12);
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

        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button5);


        float amt = 0, err = 0, eri = 0, is = 0, ma = 0, sa = 0, ia = 0;
        int tp=0;
        String goal="SELECT GOAL";

        amt = getIntent().getFloatExtra("ga", 0);
        err = getIntent().getFloatExtra("err", 0);
        eri = getIntent().getFloatExtra("eri", 0);
        tp = getIntent().getIntExtra("tp", 0);
        is = getIntent().getFloatExtra("is", 0);
        ma = getIntent().getFloatExtra("ma", 0);
        sa = getIntent().getFloatExtra("sa", 0);
        ia = getIntent().getFloatExtra("ia", 0);

        String item1 = getIntent().getStringExtra("item");
        if (item1.equals("EDUCATION")) {
            im1.setVisibility(View.VISIBLE);
            goal="EDUCATION";

        }
        if (item1.equals("BUYING AN ASSET")) {
            im2.setVisibility(View.VISIBLE);
            goal="ASSET BUYING";
        }

        if (item1.equals("RESIDENCE")) {
            im3.setVisibility(View.VISIBLE);
            goal="RESIDENCE";
        }

        if (item1.equals("MARRIAGE")) {
            im4.setVisibility(View.VISIBLE);
            goal="MARRIAGE";
        }

        if (item1.equals("RETIREMENT PLAN")) {
            im5.setVisibility(View.VISIBLE);
            goal="RETIREMENT";
        }

        if (item1.equals("FOREIGN TRIP")) {
            im6.setVisibility(View.VISIBLE);
            goal="FOREIGN TRIP";
        }

        if (item1.equals("OTHER")) {
            im7.setVisibility(View.VISIBLE);
            goal="OTHER GOALS";
        }

        t12.setText("Rs." + ma);
        t8.setText("Rs." + ia + " after " + tp + " years.");
        t11.setText("for "+goal+" which will cost");



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i1);
            }
        });
    }

        public void exit(View view){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);

    }

        //t1.setText("Goal Amount : "+amt+"\nExpected Rate of Return : "+err+"\nExpected Rate of Inflation : "+eri+"\nTime Period(in years) : "+tp+"\nInitial Savings : "+is+"\nGoal : "+item1);




}
