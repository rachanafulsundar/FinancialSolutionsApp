package com.example.dell.splash1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class stock extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private final String URL_TO_HIT0 = "https://finance.google.com/finance?q=NSE%3AINFY&ei=UZLfWcG1A8GEugTvz4qIAQ";
    private final String URL_TO_HIT1 = "https://finance.google.com/finance?q=NSE%3ASUZLON&ei=-fzgWbDGDYfZugTT6YXwBA";
    private final String URL_TO_HIT2 = "https://finance.google.com/finance?q=NSE%3ARELIANCE&ei=jQnhWZjID5XruATz_pmoAg";
    private List<String> list;
    String select="";
    TextView t1;
    Button b1,map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        t1=(TextView)findViewById(R.id.textView5);
        b1=(Button)findViewById(R.id.button3);
        map=(Button)findViewById(R.id.button4);

        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        list=new ArrayList<String>();
        list.add("--SELECT COMPANY--");
        list.add("INFOSYS");
        list.add("SUZLON");
        list.add("RELIANCE");

        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(stock.this,android.R.layout.simple_list_item_1,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Stock_analysis.class);
                i.putExtra("str",select);
                startActivity(i);
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("loc_str",select);
                startActivity(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        select=parent.getItemAtPosition(position).toString();
        if(select.equals("INFOSYS"))
        {
            get_infy();
        }
        if(select.equals("SUZLON"))
        {
            get_suzlon();
        }
        if(select.equals("RELIANCE"))
        {
            get_reliance();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    void get_infy()
    {
        JSONTask d=new JSONTask();
        d.execute(URL_TO_HIT0);
        try
        {
            String result=d.get();
            int st,st1;
            String line = null,sym=null,name=null,chg=null,chgp=null;
            String val=null,stex=null,vol=null,mkcap=null;

            st = result.indexOf("\"INFY\",\"I");
            line = result.substring(st, st +84);
            //t1.setText(line);
            t1.setText("Today's value:");
            st=line.indexOf("\"");
            st1=line.indexOf("\"",st+1);
            sym=line.substring(st+1,st1);
            t1.append("\nSymbol: "+sym);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            name=line.substring(st+1,st1);
            t1.append("\nCompany: "+name);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            val=line.substring(st+1,st1);
            t1.append("\nValue: "+val);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            chg=line.substring(st+1,st1);
            t1.append("\nChange: "+chg);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            chgp=line.substring(st+1,st1);
            t1.append("\nChange %: "+chgp);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            mkcap=line.substring(st+1,st1);
            t1.append("\nMarket Cap: "+mkcap);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            stex=line.substring(st+1,st1);
            t1.append("\nStock Exchange: "+stex);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            vol=line.substring(st+1,st1);
            t1.append("\nVolume Traded: "+vol);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    void get_reliance()
    {
        JSONTask d=new JSONTask();
        d.execute(URL_TO_HIT2);
        try
        {
            String result=d.get();
            int st,st1;
            String line = null,sym=null,name=null,chg=null,chgp=null;
            String val=null,stex=null,vol=null,mkcap=null;

            st = result.indexOf("\"RELIANCE\",\"R");
            line = result.substring(st, st +100);
            //t1.setText(line);
            t1.setText("Today's value:");
            st=line.indexOf("\"");
            st1=line.indexOf("\"",st+1);
            sym=line.substring(st+1,st1);
            t1.append("\nSymbol: "+sym);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            name=line.substring(st+1,st1);
            t1.append("\nCompany: "+name);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            val=line.substring(st+1,st1);
            t1.append("\nValue: "+val);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            chg=line.substring(st+1,st1);
            t1.append("\nChange: "+chg);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            chgp=line.substring(st+1,st1);
            t1.append("\nChange %: "+chgp);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            mkcap=line.substring(st+1,st1);
            t1.append("\nMarket Cap: "+mkcap);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            stex=line.substring(st+1,st1);
            t1.append("\nStock Exchange: "+stex);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            vol=line.substring(st+1,st1);
            t1.append("\nVolume Traded: "+vol);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    void get_suzlon()
    {
        JSONTask d=new JSONTask();
        d.execute(URL_TO_HIT1);
        try
        {
            String result=d.get();
            int st,st1;
            String line = null,sym=null,name=null,chg=null,chgp=null;
            String val=null,stex=null,vol=null,mkcap=null;

            st = result.indexOf("\"SUZLON\",\"S");
            line = result.substring(st, st +96);
            //t1.setText(line);
            t1.setText("Today's value:");
            st=line.indexOf("\"");
            st1=line.indexOf("\"",st+1);
            sym=line.substring(st+1,st1);
            t1.append("\nSymbol: "+sym);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            name=line.substring(st+1,st1);
            t1.append("\nCompany: "+name);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            val=line.substring(st+1,st1);
            t1.append("\nValue: "+val);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            chg=line.substring(st+1,st1);
            t1.append("\nChange: "+chg);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            chgp=line.substring(st+1,st1);
            t1.append("\nChange %: "+chgp);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            mkcap=line.substring(st+1,st1);
            t1.append("\nMarket Cap: "+mkcap);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            stex=line.substring(st+1,st1);
            t1.append("\nStock Exchange: "+stex);
            st=line.indexOf("\"",st1+1);
            st1=line.indexOf("\"",st+1);
            vol=line.substring(st+1,st1);
            t1.append("\nVolume Traded: "+vol);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public class JSONTask extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

}

//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.Spinner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class stock extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
//
//    Button b1,b2;
//    private List<String> select_company;
//    String item1="";
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_stock);
//
//        Spinner msp1 = (Spinner) findViewById(R.id.spinner);
//
//        select_company = new ArrayList<String>();
//        select_company.add(" - - - - - - ");
//        select_company.add("INFOSIS");
//        select_company.add("SUZLON");
//        msp1.setOnItemSelectedListener(this);
//
//        ArrayAdapter<String> ma1 = new ArrayAdapter<String>(stock.this, android.R.layout.simple_list_item_1, select_company);
//        ma1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        msp1.setAdapter(ma1);
//
//        b1 = (Button) findViewById(R.id.button);
//        b2 = (Button) findViewById(R.id.button2);
//
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i=new Intent(getApplicationContext(),analysis.class);
//                i.putExtra("cmp",item1);
//                startActivity(i);
//            }
//
//
//        });
//
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i=new Intent(getApplicationContext(),location.class);
//                startActivity(i);
//            }
//
//
//        });
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        item1 = adapterView.getItemAtPosition(i).toString();
//
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
//}
