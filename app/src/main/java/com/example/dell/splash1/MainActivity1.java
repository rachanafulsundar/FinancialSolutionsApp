package com.example.dell.splash1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.*;



public class MainActivity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Button b1;
    TextView text;
    EditText e1, e2, e3;
    private static SeekBar sb1, sb2;
    private static TextView t1, t2;
    int pv1 = 0, pv2 = 0,flag=0;
    public String item = "";
    private List<String> goal;

    String iamt, time, s;
    float ip_amt = 0, return_rate = 0, inflation_rate = 0, inflated_amt = 0, monthly_amt = 0, savings = 0, inflated_sav = 0;
    float reqd_amt = 0, saved_amt = 0, invested_amt = 0;
    int t = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main1);
        //


        b1 = (Button) findViewById(R.id.button);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        text = (TextView) findViewById(R.id.textView);

        Spinner msp1 = (Spinner) findViewById(R.id.spinner);

        goal = new ArrayList<String>();
        goal.add(" - - - Select Your Goal - - - ");
        goal.add("EDUCATION");
        goal.add("BUYING AN ASSET");
        goal.add("RESIDENCE");
        goal.add("MARRIAGE");
        goal.add("RETIREMENT PLAN");
        goal.add("FOREIGN TRIP");
        goal.add("OTHER");
        msp1.setOnItemSelectedListener(this);

        ArrayAdapter<String> ma1 = new ArrayAdapter<String>(MainActivity1.this, android.R.layout.simple_list_item_1, goal);
        ma1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        msp1.setAdapter(ma1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validation();
                if(flag==1)
                {
                    calculate();
                    flag=0;
                }



//                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
//                startActivity(i);
            }


        });

        seek_bar();

    }

    public void seek_bar() {
        sb1 = (SeekBar) findViewById(R.id.seekBar);
        t1 = (TextView) findViewById(R.id.textView4);
        t1.setText(sb1.getProgress() + " / " + sb1.getMax());

        sb2 = (SeekBar) findViewById(R.id.seekBar2);
        t2 = (TextView) findViewById(R.id.textView7);
        t2.setText(sb2.getProgress() + " / " + sb2.getMax());


        sb1.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {


                    @Override


                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        pv1 = i;
                        t1.setText(pv1 + " / " + sb1.getMax());

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        t1.setText(pv1 + " / " + sb1.getMax());

                    }
                }
        );


        sb2.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {


                    @Override


                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        pv2 = i;
                        t2.setText(pv2 + " / " + sb2.getMax());

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                        t2.setText(pv2 + " / " + sb2.getMax());

                    }
                }
        );

    }

    public void validation(){
        if(item.equals(" - - - Select Your Goal - - - "))
        {
            Toast.makeText(MainActivity1.this,"Please select your goal!",Toast.LENGTH_SHORT).show();
        }

        else if(e1.getText().toString().isEmpty() || e1.getText().toString().equals("0") )
        {
            Toast.makeText(MainActivity1.this,"Please enter valid goal amount!",Toast.LENGTH_SHORT).show();
        }
        else if(pv1==0)
        {
            Toast.makeText(MainActivity1.this,"Please enter valid Rate of Return!",Toast.LENGTH_SHORT).show();
        }
        else if(pv2==0)
        {
            Toast.makeText(MainActivity1.this,"Please enter valid Rate of Inflation!",Toast.LENGTH_SHORT).show();
        }
        else if(e2.getText().toString().isEmpty() || e2.getText().toString().equals("0"))
        {
            Toast.makeText(MainActivity1.this,"Please enter valid Time Period!",Toast.LENGTH_SHORT).show();
        }
        else if(e3.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity1.this,"Please enter valid initial savings amount!",Toast.LENGTH_SHORT).show();
        }

        else
        {
            flag=1;
        }



    }


    public void calculate() {
        Scanner sc = new Scanner(System.in);
        iamt = e1.getText().toString();
        ip_amt = Float.parseFloat(iamt);

        return_rate = pv1;

        inflation_rate = pv2;

        time = e2.getText().toString();
        t = Integer.parseInt(time);

        s = e3.getText().toString();
        savings = Float.parseFloat(s);

        float temp = (float) Math.pow(inflation_rate / 100 + 1, t);
        inflated_amt = ip_amt * temp;

        temp = (float) Math.pow(return_rate / 100 + 1, t);
        inflated_sav = savings * temp;
        reqd_amt = inflated_amt - inflated_sav;

        temp = (float) Math.pow(return_rate / 1200 + 1, 12 * t);
        monthly_amt = (reqd_amt * return_rate / 1200) / (temp - 1);

        saved_amt = inflated_amt - monthly_amt * 12 * 10 - savings;
        invested_amt = monthly_amt * 12 * 10 + savings;


        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("ga", ip_amt);
        i.putExtra("err", return_rate);
        i.putExtra("eri", inflation_rate);
        i.putExtra("tp", t);
        i.putExtra("is", savings);
        i.putExtra("ma", monthly_amt);
        i.putExtra("sa", saved_amt);
        i.putExtra("ia", inflated_amt);
        i.putExtra("item", item);
        this.startActivity(i);


        //System.out.println("\nYou will earn interest of Rs."+saved_amt+" over "+t+" years");
        //System.out.println("\nYou will invest Rs."+invested_amt+" over "+t+" years");


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        item = adapterView.getItemAtPosition(i).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


