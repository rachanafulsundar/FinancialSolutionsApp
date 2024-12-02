package com.example.dell.splash1;


        import android.content.Intent;
        import android.os.AsyncTask;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import org.json.JSONException;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.concurrent.ExecutionException;

public class MainActivity5 extends AppCompatActivity {

    Button b1;

    private final String URL_TO_HIT0 = "http://www.x-rates.com/table/?from=USD&amount=1";
    private final String URL_TO_HIT1 = "http://www.x-rates.com/table/?from=EUR&amount=1";
    private final String URL_TO_HIT2 = "http://www.x-rates.com/table/?from=GBP&amount=1";
    private final String URL_TO_HIT3 = "http://www.x-rates.com/table/?from=AUD&amount=1";
    private final String URL_TO_HIT4 = "http://www.x-rates.com/table/?from=CAD&amount=1";
    private final String URL_TO_HIT5 = "http://www.x-rates.com/table/?from=INR&amount=1";
    private TextView tvData;
    private Button button;

    int n=6;
    float[][] matrix = new float[n][n];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        tvData=(TextView)findViewById(R.id.textview);

                get_usd();
                get_eur();
                get_gbp();
                get_aud();
                get_cad();
                get_inr();
                print_matrix();
    }

    public void get_usd()
    {
        JSONTask d=new JSONTask();
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
        JSONTask d=new JSONTask();
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
        JSONTask d=new JSONTask();
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
        JSONTask d=new JSONTask();
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
        JSONTask d=new JSONTask();
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
        JSONTask d=new JSONTask();
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

    public void print_matrix()
    {
        tvData.setText("");
        tvData.append("\t\t\t\t\t\tUSD\t\t\t\t\t\tEUR\t\t\t\t\t\tGBP\t\t\t\t\t\tAUD\t\t\t\t\t\tCAD\t\t\t\t\t\tINR\t\t\t\t\t\t\t");
        for(int i=0;i<n;i++)
        {

            for(int j=0;j<n;j++)
            {
                String label=null;
                if(j==0)
                {
                    switch(i)
                    {
                        case 0:
                            label="\nUSD\t";
                            break;
                        case 1:
                            label="EUR\t";
                            break;
                        case 2:
                            label="GBP\t";
                            break;
                        case 3:
                            label="AUD\t";
                            break;
                        case 4:
                            label="CAD\t";
                            break;
                        case 5:
                            label="INR\t\t";
                            break;
                    }
                    tvData.append(label+"\t"+String.format("%.6f", matrix[i][j])+"\t");
                }
                else
                {
                    tvData.append("\t"+String.format("%.6f", matrix[i][j])+"\t");
                }
            }
            tvData.append("\n\n");
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


}
