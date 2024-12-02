package com.example.dell.splash1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.DashPathEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Regression_line extends AppCompatActivity {

    String com_name="SUZLON";

    ArrayList<Float> slist = new ArrayList<>();

    double[] x1 = new double[1000];
    double[] y1 = new double[1000];

    double bet1,bet2;
    String istr;
    LineGraphSeries<DataPoint> series;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regression_line);

        istr= getIntent().getStringExtra("str");
        com_name=getIntent().getStringExtra("com_str");

        t1= (TextView) findViewById(R.id.textView2);
        try {
            readClassData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(istr.equals("Past week")) {
            week_graph();
            week_reg();
        }
        else if(istr.equals("Past month")) {
            month_graph();
            month_reg();
        }
        else if(istr.equals("Past year")) {
            year_graph();
            year_reg();
        }
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

        GraphView g1=(GraphView)findViewById(R.id.graph1);
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

    void week_reg()
    {
        double x,y;
        int max=7,n=0;

        double sumx=0.0;
        double sumx2=0.0;
        double sumy=0.0;

        for(int i=0;i<max;i++)
        {
            sumx  += x1[n];
            sumx2 += x1[n] * x1[n];
            sumy  += y1[n];
            n++;
        }
        double xbar = sumx / n;
        double ybar = sumy / n;

        // second pass: compute summary statistics
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x1[i] - xbar) * (x1[i] - xbar);
            yybar += (y1[i] - ybar) * (y1[i] - ybar);
            xybar += (x1[i] - xbar) * (y1[i] - ybar);
        }
        double beta1 = xybar / xxbar;
        double beta0 = ybar - beta1 * xbar;

        //t1.setText("y   = " + beta1 + " * x + " + beta0);

        // analyze results
        int df = n - 2;
        double rss = 0.0;      // residual sum of squares
        double ssr = 0.0;      // regression sum of squares
        for (int i = 0; i < n; i++) {
            double fit = beta1*x1[i] + beta0;
            rss += (fit - y1[i]) * (fit - y1[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }
        double R2    = ssr / yybar;
        double svar  = rss / df;
        double svar1 = svar / xxbar;
        double svar0 = svar/n + xbar*xbar*svar1;

        System.out.println("R^2                 = " + R2);
        System.out.println("std error of beta_1 = " + Math.sqrt(svar1));
        System.out.println("std error of beta_0 = " + Math.sqrt(svar0));
        svar0 = svar * sumx2 / (n * xxbar);
        System.out.println("std error of beta_0 = " + Math.sqrt(svar0));

        System.out.println("SSTO = " + yybar);
        System.out.println("SSE  = " + rss);
        System.out.println("SSR  = " + ssr);

        //double[] rx = new double[max];
        double[] ry = new double[max];
        for(int i=0;i<n;i++)
        {
            ry[i]=x1[i]*beta1+beta0;
        }

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        paint.setPathEffect(new DashPathEffect(new float[]{5, 15}, 0));
        GraphView g1=(GraphView)findViewById(R.id.graph1);
        series=new LineGraphSeries<DataPoint>();
        series.setCustomPaint(paint);
        for(int i=0;i<n;i++)
        {
            x=x1[i];
            y=ry[i];
            series.appendData(new DataPoint(x,y),true,n);
        }
        g1.addSeries(series);

        double val=(x1[n]+1)*beta1+beta0;
        t1.setText("Equation: y = "+String.format("%.2f", beta1)+" * x +"+String.format("%.2f", beta0));
        t1.append("\n\nR-square value(R^2): "+String.format("%.2f", R2));
        t1.append("\n\nThe next value predicted by regression line: "+String.format("%.2f",val));

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

        GraphView g1=(GraphView)findViewById(R.id.graph1);
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

    void month_reg()
    {
        double x,y;
        int max=30,n=0;

        double sumx=0.0;
        double sumx2=0.0;
        double sumy=0.0;

        for(int i=0;i<max;i++)
        {
            sumx  += x1[n];
            sumx2 += x1[n] * x1[n];
            sumy  += y1[n];
            n++;
        }
        double xbar = sumx / n;
        double ybar = sumy / n;

        // second pass: compute summary statistics
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x1[i] - xbar) * (x1[i] - xbar);
            yybar += (y1[i] - ybar) * (y1[i] - ybar);
            xybar += (x1[i] - xbar) * (y1[i] - ybar);
        }
        double beta1 = xybar / xxbar;
        double beta0 = ybar - beta1 * xbar;

        // analyze results
        int df = n - 2;
        double rss = 0.0;      // residual sum of squares
        double ssr = 0.0;      // regression sum of squares
        for (int i = 0; i < n; i++) {
            double fit = beta1*x1[i] + beta0;
            rss += (fit - y1[i]) * (fit - y1[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }
        double R2    = ssr / yybar;
        double svar  = rss / df;
        double svar1 = svar / xxbar;
        double svar0 = svar/n + xbar*xbar*svar1;

        System.out.println("R^2                 = " + R2);
        System.out.println("std error of beta_1 = " + Math.sqrt(svar1));
        System.out.println("std error of beta_0 = " + Math.sqrt(svar0));
        svar0 = svar * sumx2 / (n * xxbar);
        System.out.println("std error of beta_0 = " + Math.sqrt(svar0));

        System.out.println("SSTO = " + yybar);
        System.out.println("SSE  = " + rss);
        System.out.println("SSR  = " + ssr);

        //double[] rx = new double[max];
        double[] ry = new double[max];
        for(int i=0;i<n;i++)
        {
            ry[i]=x1[i]*beta1+beta0;
        }

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        paint.setPathEffect(new DashPathEffect(new float[]{5, 15}, 0));
        GraphView g1=(GraphView)findViewById(R.id.graph1);
        series=new LineGraphSeries<DataPoint>();
        series.setCustomPaint(paint);
        for(int i=0;i<n;i++)
        {
            x=x1[i];
            y=ry[i];
            series.appendData(new DataPoint(x,y),true,n);
        }
        g1.addSeries(series);

        double val=(x1[n]+1)*beta1+beta0;
        t1.setText("Equation: y = "+String.format("%.2f", beta1)+" * x +"+String.format("%.2f", beta0));
        t1.append("\n\nR-square value(R^2): "+String.format("%.2f", R2));
        t1.append("\n\nThe next value predicted by regression line: "+String.format("%.2f",val));
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

        GraphView g1=(GraphView)findViewById(R.id.graph1);
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

    void year_reg()
    {
        double x,y;
        int max=350,n=0;

        double sumx=0.0;
        double sumx2=0.0;
        double sumy=0.0;

        for(int i=0;i<max;i++)
        {
            sumx  += x1[n];
            sumx2 += x1[n] * x1[n];
            sumy  += y1[n];
            n++;
        }
        double xbar = sumx / n;
        double ybar = sumy / n;

        // second pass: compute summary statistics
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        for (int i = 0; i < n; i++) {
            xxbar += (x1[i] - xbar) * (x1[i] - xbar);
            yybar += (y1[i] - ybar) * (y1[i] - ybar);
            xybar += (x1[i] - xbar) * (y1[i] - ybar);
        }
        double beta1 = xybar / xxbar;
        double beta0 = ybar - beta1 * xbar;

        // analyze results
        int df = n - 2;
        double rss = 0.0;      // residual sum of squares
        double ssr = 0.0;      // regression sum of squares
        for (int i = 0; i < n; i++) {
            double fit = beta1*x1[i] + beta0;
            rss += (fit - y1[i]) * (fit - y1[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }
        double R2    = ssr / yybar;
        double svar  = rss / df;
        double svar1 = svar / xxbar;
        double svar0 = svar/n + xbar*xbar*svar1;

        System.out.println("R^2                 = " + R2);
        System.out.println("std error of beta_1 = " + Math.sqrt(svar1));
        System.out.println("std error of beta_0 = " + Math.sqrt(svar0));
        svar0 = svar * sumx2 / (n * xxbar);
        System.out.println("std error of beta_0 = " + Math.sqrt(svar0));

        System.out.println("SSTO = " + yybar);
        System.out.println("SSE  = " + rss);
        System.out.println("SSR  = " + ssr);

        //double[] rx = new double[max];
        double[] ry = new double[max];
        for(int i=0;i<n;i++)
        {
            ry[i]=x1[i]*beta1+beta0;
        }

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        paint.setPathEffect(new DashPathEffect(new float[]{5, 15}, 0));
        GraphView g1=(GraphView)findViewById(R.id.graph1);
        series=new LineGraphSeries<DataPoint>();
        series.setCustomPaint(paint);
        for(int i=0;i<n;i++)
        {
            x=x1[i];
            y=ry[i];
            series.appendData(new DataPoint(x,y),true,n);
        }
        g1.addSeries(series);

        double val=(x1[n]+1)*beta1+beta0;
        t1.setText("Equation: y = "+String.format("%.2f", beta1)+" * x +"+String.format("%.2f", beta0));
        t1.append("\n\nR-square value(R^2): "+String.format("%.2f", R2));
        t1.append("\n\nThe next value predicted by regression line: "+String.format("%.2f",val));
    }
}
