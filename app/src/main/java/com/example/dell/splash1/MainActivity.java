package com.example.dell.splash1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1=(ImageButton)findViewById(R.id.imageButton10);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity1.class);
                startActivity(i);
            }
        });

        b2=(ImageButton)findViewById(R.id.imageButton9);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(i);
            }
        });

        b3=(ImageButton)findViewById(R.id.imageButton8);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),stock.class);
                startActivity(i);
            }
        });

        b4=(ImageButton)findViewById(R.id.imageButton11);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Bank.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.commonmenus,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==R.id.menuguide)
        {
            Toast.makeText(this,"Guide menu is selected!",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Guide.class));
        }

        if(id==R.id.menugallery)
        {
            Toast.makeText(this,"Gallery menu is selected!",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Gallery.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
