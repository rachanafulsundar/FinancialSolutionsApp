package com.example.dell.splash1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

import static android.R.attr.x;

public class Stock_analysis extends AppCompatActivity
{
    double[] x1 = new double[1000];
    double[] y1 = new double[1000];

    String com_name="SUZLON";
    RadioGroup rg;
    RadioButton rb;
    Button b1,b2;
    TextView tx;
    LineGraphSeries<DataPoint> series;
    public ArrayList<Float> slist = new ArrayList<>();
    String rbstr=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_analysis);

        com_name= getIntent().getStringExtra("str");

        tx=(TextView)findViewById(R.id.textView);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        rg=(RadioGroup)findViewById(R.id.radioGroup);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int rb_id=rg.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(rb_id);
                rbstr=rb.getText().toString();
                try {
                    readClassData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(rbstr.equals("Past week")) {
                    week_graph();
                }
                else if(rbstr.equals("Past month"))
                {
                    month_graph();
                }
                else if(rbstr.equals("Past year"))
                {
                    year_graph();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rb_id=rg.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(rb_id);
                rbstr=rb.getText().toString();
                Intent i=new Intent(getApplicationContext(),Regression_line.class);
                i.putExtra("str",rbstr);
                i.putExtra("com_str",com_name);
                startActivity(i);
            }
        });

    }

    private void displaydata()
    {
        tx = (TextView)findViewById(R.id.textView);
        String m = "";
        for(int i=0;i<slist.size();i++)
        {
            m = m + slist.get(i) + "\n";
        }
        tx.setText(m);
    }


    private void readClassData() throws IOException {
        InputStream is = null;
        if(com_name.equals("INFOSYS")){
            is = getResources().openRawResource(R.raw.infosys1);
        }
        else if(com_name.equals("SUZLON")){
            is = getResources().openRawResource(R.raw.suzlon1);
        }
        else if(com_name.equals("RELIANCE")){
            is = getResources().openRawResource(R.raw.reliance1);
        }
        BufferedReader reader = new BufferedReader( new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try
        {
            //reader.readLine();
            while((line = reader.readLine())!= null)
            {
                // split by commas
                String[] tokens = line.split(",");

                // read the data
                slist.add(Float.parseFloat(tokens[0]));

                Log.d("MyActivity", "Just Created" + "aa");

            }
        }
        catch(IOException E)
        {
            Log.wtf("MyActivity", "Error reading data file" + line, E);
            E.printStackTrace();
        }


    }

    void week_graph()
    {
        double x,y;
        int n=7;

        double min=10000,max=0;

        int size=slist.size()-n;

        for(int i=0;i<n;i++)
        {
            y1[i]=slist.get(size);
            size++;
            x1[i]=i+1;
            if(max<y1[i])
            {
                max=y1[i];
            }
            if(min>y1[i])
            {
                min=y1[i];
            }
        }
        max=max+20;
        min=min-20;
        int maxi= ((int) max);
        int mini= ((int) min);

        GraphView g1=(GraphView)findViewById(R.id.graph);
        g1.removeAllSeries();
        series=new LineGraphSeries<DataPoint>();
        for(int i=0;i<n;i++)
        {
            x=x1[i];
            y=y1[i];
            series.appendData(new DataPoint(x,y),true,n);
        }
        g1.addSeries(series);

        g1.getViewport().setMinX(0);
        g1.getViewport().setMaxX(n+1);
        g1.getViewport().setMinY(mini);
        g1.getViewport().setMaxY(maxi);

        g1.getViewport().setYAxisBoundsManual(true);
        g1.getViewport().setXAxisBoundsManual(true);
    }

    void month_graph()
    {
        double x,y;
        int n=30;

        double min=10000,max=0;

        int size=slist.size()-n;

        for(int i=0;i<n;i++)
        {
            y1[i]=slist.get(size);
            size++;
            x1[i]=i+1;
            if(max<y1[i])
            {
                max=y1[i];
            }
            if(min>y1[i])
            {
                min=y1[i];
            }
        }
        max=max+20;
        min=min-20;
        int maxi= ((int) max);
        int mini= ((int) min);

        GraphView g1=(GraphView)findViewById(R.id.graph);
        g1.removeAllSeries();
        series=new LineGraphSeries<DataPoint>();
        for(int i=0;i<n;i++)
        {
            x=x1[i];
            y=y1[i];
            series.appendData(new DataPoint(x,y),true,n);
        }
        g1.addSeries(series);

        g1.getViewport().setMinX(0);
        g1.getViewport().setMaxX(n+1);
        g1.getViewport().setMinY(mini);
        g1.getViewport().setMaxY(maxi);

        g1.getViewport().setYAxisBoundsManual(true);
        g1.getViewport().setXAxisBoundsManual(true);
    }

    void year_graph()
    {
        double x,y;
        int n=350;

        double min=10000,max=0;

        int size=slist.size()-n;

        for(int i=0;i<n;i++)
        {
            y1[i]=slist.get(size);
            size++;
            x1[i]=i+1;
            if(max<y1[i])
            {
                max=y1[i];
            }
            if(min>y1[i])
            {
                min=y1[i];
            }
        }
        max=max+20;
        min=min-20;
        int maxi= ((int) max);
        int mini= ((int) min);

        GraphView g1=(GraphView)findViewById(R.id.graph);
        g1.removeAllSeries();
        series=new LineGraphSeries<DataPoint>();
        for(int i=0;i<n;i++)
        {
            x=x1[i];
            y=y1[i];
            series.appendData(new DataPoint(x,y),true,n);
        }
        g1.addSeries(series);

        g1.getViewport().setMinX(0);
        g1.getViewport().setMaxX(n+1);
        g1.getViewport().setMinY(mini);
        g1.getViewport().setMaxY(maxi);

        g1.getViewport().setYAxisBoundsManual(true);
        g1.getViewport().setXAxisBoundsManual(true);
    }



}
