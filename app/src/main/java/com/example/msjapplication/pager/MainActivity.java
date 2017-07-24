package com.example.msjapplication.pager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void newClick (View view){
        Intent intent = new Intent(getApplicationContext() , Notes_Activity.class);
        startActivity(intent);
    }

    public void oldClick (View view){
        Intent intent = new Intent(getApplicationContext() , Galery_Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
