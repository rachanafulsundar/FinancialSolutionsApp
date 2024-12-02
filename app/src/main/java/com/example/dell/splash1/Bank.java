package com.example.dell.splash1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Bank extends AppCompatActivity {

    ImageButton b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        b1=(ImageButton)findViewById(R.id.imageButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(),Fdrd.class);
                i1.putExtra("bno",1);
                startActivity(i1);
            }
        });

        b2=(ImageButton)findViewById(R.id.imageButton2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(getApplicationContext(),Fdrd.class);
                i2.putExtra("bno",2);
                startActivity(i2);
            }
        });

        b3=(ImageButton)findViewById(R.id.imageButton3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(getApplicationContext(),Fdrd.class);
                i3.putExtra("bno",3);
                startActivity(i3);
            }
        });

        b4=(ImageButton)findViewById(R.id.imageButton4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4=new Intent(getApplicationContext(),Fdrd.class);
                i4.putExtra("bno",4);
                startActivity(i4);
            }
        });
        b5=(ImageButton)findViewById(R.id.imageButton5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5=new Intent(getApplicationContext(),Fdrd.class);
                i5.putExtra("bno",5);
                startActivity(i5);
            }
        });
    }
}
