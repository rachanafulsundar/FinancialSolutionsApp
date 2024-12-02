package com.example.dell.splash1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by dell on 8/10/17.
 */

public class MainActivity4 extends AppCompatActivity{

    private List<String> starting_curr;
    private List<String> final_curr;

    String item1="";
    String item2="";
    Button b1,b2;
    int n=6,flag=0;
    float[][] matrix = new float[n][n];


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Spinner msp1 = (Spinner) findViewById(R.id.spinner);

        starting_curr = new ArrayList<String>();
        starting_curr.add("- - - - -");
        starting_curr.add("INR");
        starting_curr.add("USD");
        starting_curr.add("GBP");
        starting_curr.add("EUR");
        starting_curr.add("AUD");
        starting_curr.add("CAD");

        ArrayAdapter<String> ma1 = new ArrayAdapter<String>(MainActivity4.this, android.R.layout.simple_list_item_1,starting_curr);
        ma1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        msp1.setAdapter(ma1);
        msp1.setOnItemSelectedListener(new ScurrClass());




        Spinner msp2 = (Spinner) findViewById(R.id.spinner2);

        final_curr = new ArrayList<String>();
        final_curr.add("- - - - -");
        final_curr.add("INR");
        final_curr.add("USD");
        final_curr.add("GBP");
        final_curr.add("EUR");
        final_curr.add("AUD");
        final_curr.add("CAD");

        ArrayAdapter<String> ma2 = new ArrayAdapter<String>(MainActivity4.this, android.R.layout.simple_list_item_1,final_curr);
        ma2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        msp2.setAdapter(ma2);
        msp2.setOnItemSelectedListener(new FcurrClass());

        b1 = (Button) findViewById(R.id.button3);
        b2 = (Button) findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),MainActivity5.class);
                startActivity(i);
            }


        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validation();
                if(flag==1)
                {
                    send_curr();
                    flag=0;
                }


            }


        });
    }

    class  ScurrClass implements AdapterView.OnItemSelectedListener
    {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            item1 = adapterView.getItemAtPosition(i).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    class FcurrClass implements AdapterView.OnItemSelectedListener
    {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            item2 = adapterView.getItemAtPosition(i).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    public void validation(){
        if(item1.equals("- - - - -"))
        {
            Toast.makeText(MainActivity4.this,"Please select starting currency!",Toast.LENGTH_SHORT).show();
        }
        else if(item2.equals("- - - - -"))
        {
            Toast.makeText(MainActivity4.this,"Please select final currency!",Toast.LENGTH_SHORT).show();
        }

        else
        {
            flag=1;
        }



    }

    public void send_curr(){
        Intent i = new Intent(this, MainActivity6.class);
        i.putExtra("item1", item1);
        i.putExtra("item2", item2);
        this.startActivity(i);
    }
}
