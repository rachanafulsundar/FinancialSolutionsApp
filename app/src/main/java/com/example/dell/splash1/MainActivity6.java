package com.example.dell.splash1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Created by dell on 8/10/17.
 */

public class MainActivity6 extends AppCompatActivity {

    Button b1;
    int s,f;
    String item1,item2;
    private final String URL_TO_HIT0 = "http://www.x-rates.com/table/?from=USD&amount=1";
    private final String URL_TO_HIT1 = "http://www.x-rates.com/table/?from=EUR&amount=1";
    private final String URL_TO_HIT2 = "http://www.x-rates.com/table/?from=GBP&amount=1";
    private final String URL_TO_HIT3 = "http://www.x-rates.com/table/?from=AUD&amount=1";
    private final String URL_TO_HIT4 = "http://www.x-rates.com/table/?from=CAD&amount=1";
    private final String URL_TO_HIT5 = "http://www.x-rates.com/table/?from=INR&amount=1";
    private TextView tvData,t1,t2;
    private Button button;

    int n=6;
    float[][] matrix = new float[n][n];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        tvData=(TextView)findViewById(R.id.textView1);
        t1=(TextView)findViewById(R.id.textView2);
        t2=(TextView)findViewById(R.id.textView3);
        item1=getIntent().getStringExtra("item1");
        item2=getIntent().getStringExtra("item2");

//        ----------------starting currency---------------------------

        if(item1.equals("INR"))
        {
            s=1;
        }
        else if(item1.equals("USD"))
        {
            s=2;
        }
        else if(item1.equals("GBP"))
        {
            s=3;
        }
        else if(item1.equals("EUR"))
        {
            s=4;
        }
        else if(item1.equals("AUD"))
        {
            s=5;
        }
        else
        {
            s=6;
        }
//        -----------------final currency------------------

        if(item2.equals("INR"))
        {
            f=1;
        }
        else if(item2.equals("USD"))
        {
            f=2;
        }
        else if(item2.equals("GBP"))
        {
            f=3;
        }
        else if(item2.equals("EUR"))
        {
            f=4;
        }
        else if(item2.equals("AUD"))
        {
            f=5;
        }
        else
        {
            f=6;
        }

//        tvData.setText("item1"+s+"\nitem2"+f);

        get_usd();
        get_eur();
        get_gbp();
        get_aud();
        get_cad();
        get_inr();
        calculate();
    }

    public void get_usd()
    {
        MainActivity6.JSONTask d=new MainActivity6.JSONTask();
        d.execute(URL_TO_HIT0);
        try
        {
            String result=d.get();
            int st = 0,i=0;
            String line = null;
            float usd = 0, eur = 0, gbp = 0, aud = 0, cad = 0,inr=0;

            st = result.indexOf("EUR'");
            line = result.substring(st + 5, st + 13);
            eur = Float.parseFloat(line);

            st = result.indexOf("GBP'");
            line = result.substring(st + 5, st + 13);
            gbp = Float.parseFloat(line);

            st = result.indexOf("INR'");
            line = result.substring(st + 5, st + 13);
            inr = Float.parseFloat(line);

            st = result.indexOf("AUD'");
            line = result.substring(st + 5, st + 13);
            aud = Float.parseFloat(line);

            st = result.indexOf("CAD'");
            line = result.substring(st + 5, st + 13);
            cad = Float.parseFloat(line);

            matrix[i][0]=1;
            matrix[i][1]=eur;
            matrix[i][2]=gbp;
            matrix[i][3]=aud;
            matrix[i][4]=cad;
            matrix[i][5]=inr;


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public void get_eur()
    {
        MainActivity6.JSONTask d=new MainActivity6.JSONTask();
        d.execute(URL_TO_HIT1);
        try
        {
            String result=d.get();
            int st = 0,i=1;
            String line = null;
            float usd = 0, eur = 0, gbp = 0, aud = 0, cad = 0,inr=0;

            st=result.indexOf("USD'");
            line=result.substring(st+5,st+13);
            usd=Float.parseFloat(line);

            st = result.indexOf("GBP'");
            line = result.substring(st + 5, st + 13);
            gbp = Float.parseFloat(line);

            st = result.indexOf("INR'");
            line = result.substring(st + 5, st + 13);
            inr = Float.parseFloat(line);

            st = result.indexOf("AUD'");
            line = result.substring(st + 5, st + 13);
            aud = Float.parseFloat(line);

            st = result.indexOf("CAD'");
            line = result.substring(st + 5, st + 13);
            cad = Float.parseFloat(line);

            matrix[i][0]=usd;
            matrix[i][1]=1;
            matrix[i][2]=gbp;
            matrix[i][3]=aud;
            matrix[i][4]=cad;
            matrix[i][5]=inr;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public void get_aud()
    {
        MainActivity6.JSONTask d=new MainActivity6.JSONTask();
        d.execute(URL_TO_HIT3);
        try
        {
            String result=d.get();
            int st = 0,i=3;
            String line = null;
            float usd = 0, eur = 0, gbp = 0, aud = 0, cad = 0,inr=0;

            st=result.indexOf("USD'");
            line=result.substring(st+5,st+13);
            usd=Float.parseFloat(line);

            st = result.indexOf("EUR'");
            line = result.substring(st + 5, st + 13);
            eur = Float.parseFloat(line);

            st = result.indexOf("GBP'");
            line = result.substring(st + 5, st + 13);
            gbp = Float.parseFloat(line);

            st = result.indexOf("INR'");
            line = result.substring(st + 5, st + 13);
            inr = Float.parseFloat(line);

            st = result.indexOf("CAD'");
            line = result.substring(st + 5, st + 13);
            cad = Float.parseFloat(line);

            matrix[i][0]=usd;
            matrix[i][1]=eur;
            matrix[i][2]=gbp;
            matrix[i][3]=1;
            matrix[i][4]=cad;
            matrix[i][5]=inr;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public void get_gbp()
    {
        MainActivity6.JSONTask d=new MainActivity6.JSONTask();
        d.execute(URL_TO_HIT2);
        try
        {
            String result=d.get();
            int st = 0,i=2;
            String line = null;
            float usd = 0, eur = 0, gbp = 0, aud = 0, cad = 0,inr=0;

            st=result.indexOf("USD'");
            line=result.substring(st+5,st+13);
            usd=Float.parseFloat(line);

            st = result.indexOf("EUR'");
            line = result.substring(st + 5, st + 13);
            eur = Float.parseFloat(line);

            st = result.indexOf("INR'");
            line = result.substring(st + 5, st + 13);
            inr = Float.parseFloat(line);

            st = result.indexOf("AUD'");
            line = result.substring(st + 5, st + 13);
            aud = Float.parseFloat(line);

            st = result.indexOf("CAD'");
            line = result.substring(st + 5, st + 13);
            cad = Float.parseFloat(line);

            matrix[i][0]=usd;
            matrix[i][1]=eur;
            matrix[i][2]=1;
            matrix[i][3]=aud;
            matrix[i][4]=cad;
            matrix[i][5]=inr;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public void get_cad()
    {
        MainActivity6.JSONTask d=new MainActivity6.JSONTask();
        d.execute(URL_TO_HIT4);
        try
        {
            String result=d.get();
            int st = 0,i=4;
            String line = null;
            float usd = 0, eur = 0, gbp = 0, aud = 0, cad = 0,inr=0;

            st=result.indexOf("USD'");
            line=result.substring(st+5,st+13);
            usd=Float.parseFloat(line);

            st = result.indexOf("EUR'");
            line = result.substring(st + 5, st + 13);
            eur = Float.parseFloat(line);

            st = result.indexOf("GBP'");
            line = result.substring(st + 5, st + 13);
            gbp = Float.parseFloat(line);

            st = result.indexOf("INR'");
            line = result.substring(st + 5, st + 13);
            inr = Float.parseFloat(line);

            st = result.indexOf("AUD'");
            line = result.substring(st + 5, st + 13);
            aud = Float.parseFloat(line);

            matrix[i][0]=usd;
            matrix[i][1]=eur;
            matrix[i][2]=gbp;
            matrix[i][3]=aud;
            matrix[i][4]=1;
            matrix[i][5]=inr;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public void get_inr()
    {
        MainActivity6.JSONTask d=new MainActivity6.JSONTask();
        d.execute(URL_TO_HIT5);
        try
        {
            String result=d.get();
            int st=0,i=5;
            String line=null;
            float usd=0,eur=0,gbp=0,aud=0,cad=0;

            st=result.indexOf("USD'");
            line=result.substring(st+5,st+13);
            usd=Float.parseFloat(line);

            st=result.indexOf("EUR'");
            line=result.substring(st+5,st+13);
            eur=Float.parseFloat(line);

            st=result.indexOf("GBP'");
            line=result.substring(st+5,st+13);
            gbp=Float.parseFloat(line);

            st=result.indexOf("AUD'");
            line=result.substring(st+5,st+13);
            aud=Float.parseFloat(line);

            st=result.indexOf("CAD'");
            line=result.substring(st+5,st+13);
            cad=Float.parseFloat(line);

            matrix[i][0]=usd;
            matrix[i][1]=eur;
            matrix[i][2]=gbp;
            matrix[i][3]=aud;
            matrix[i][4]=cad;
            matrix[i][5]=1;

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

//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            //String sub=s.substring(10,100);
//            tvData.setText(s);
//        }
    }
    public void calculate()
    {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = 6; m = 20;
//            s = sc.nextInt();
//            f = sc.nextInt();

        //double a[][] = new double[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = (float) 0.0;
                } else {
                    matrix[i][j] = matrix[i][j] * 1000000;
                    matrix[i][j] = (int) matrix[i][j];
                    matrix[i][j] = matrix[i][j] / 1000000;
                }

            }
        }
        matrix[0][0] = (float) 0.0;

        float vv[][] = new float[m+1][n];
        int pp[][] = new int[m+1][n];
        for (int i = 0; i < n; i++)
            vv[1][i] = matrix[s][i];

        float[] fin = new float[n];
        for (int w = 2; w <= m; w++)
        {
            for (int i = 0; i < n; i++)
            {
                int k = -1;
                vv[w][i] = 0;

                for (int j = 0; j < n; j++)
                {
                    if(vv[w][i]  <  (vv[w-1][j]*matrix[j][i]))
                    {
                        vv[w][i] = vv[w-1][j] * matrix[j][i];
                        pp[w][i] = j;
                    }
                }

            }
            if (w == m)
                fin = vv[w];
        }
        //System.out.println(fin[f]);
        sc.close();

        tvData.setText(item1+" can be\n\nmaximised to ");
        t1.setText(String.format("%.6f", fin[f]));
        t2.setText(""+item2+" dollars");


//            int bck = f;
//            int m1[] = new int[6];
//            int j = m-1;
//            for(int i = m;i>=2;i--)
//            {
//                //System.out.println(bck + "  " + vv[i][bck]);
//                m1[j] = bck;
//                bck = pp[i][bck];
//                j--;
//            }

//            for(int i=2;i<m;i++)
//            {
//                tvData.append("\n" + Integer.toString(m1[i]));
//            }

    }

}
