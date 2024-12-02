package com.example.dell.splash1;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Guide extends AppCompatActivity {
    Button b1,g1,c1;
    Button b2,g2,c2;
    Button b3,g3,c3;
    Button b4,g4,c4;
    Dialog d1,d2,d3,d4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCustomAlertDialogue1();

            }
        });

        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCustomAlertDialogue2();

            }
        });

        b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCustomAlertDialogue3();

            }
        });

        b4=(Button)findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCustomAlertDialogue4();

            }
        });

    }

    public void MyCustomAlertDialogue1(){

        d1=new Dialog(Guide.this);
        d1.setContentView(R.layout.customdialogue);
        d1.setTitle("Stock Analysis");

        g1=(Button)d1.findViewById(R.id.button5);
        c1=(Button)d1.findViewById(R.id.button6);

        g1.setEnabled(true);
        c1.setEnabled(true);

        g1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),stock.class);
                startActivity(i);
            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d1.cancel();
            }
        });

        d1.show();
    }

    public void MyCustomAlertDialogue2(){

        d2=new Dialog(Guide.this);
        d2.setContentView(R.layout.customdialogue2);
        d2.setTitle("Currency Maximiser");

        g2=(Button)d2.findViewById(R.id.button5);
        c2=(Button)d2.findViewById(R.id.button6);

        g2.setEnabled(true);
        c2.setEnabled(true);

        g2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(i);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d2.cancel();
            }
        });

        d2.show();
    }

    public void MyCustomAlertDialogue3(){

        d3=new Dialog(Guide.this);
        d3.setContentView(R.layout.customdialogue3);
        d3.setTitle("Goal Calculator");

        g3=(Button)d3.findViewById(R.id.button5);
        c3=(Button)d3.findViewById(R.id.button6);

        g3.setEnabled(true);
        c3.setEnabled(true);

        g3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity1.class);
                startActivity(i);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d3.cancel();
            }
        });

        d3.show();
    }

    public void MyCustomAlertDialogue4(){

        d4=new Dialog(Guide.this);
        d4.setContentView(R.layout.customdialogue4);
        d4.setTitle("Bank Module");

        g4=(Button)d4.findViewById(R.id.button5);
        c4=(Button)d4.findViewById(R.id.button6);

        g4.setEnabled(true);
        c4.setEnabled(true);

        g4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Bank.class);
                startActivity(i);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d4.cancel();
            }
        });

        d4.show();
    }
}

