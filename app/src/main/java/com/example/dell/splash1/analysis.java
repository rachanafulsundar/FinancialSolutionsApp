package com.example.dell.splash1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class analysis extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        String item1 = getIntent().getStringExtra("cmp");
        t1=(TextView)findViewById(R.id.textView);
        t1.setText(" "+item1);

    }
}
