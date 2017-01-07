package com.example.elad.android5777.controller;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.elad.android5777.R;

public class BusinessOrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_or);

        Button plus = (Button) findViewById(R.id.business_button);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName compName = new ComponentName (BusinessOrActivity.this, businessList.class );
                Intent myIntent = new Intent();
                myIntent.setComponent(compName);
                startActivity(myIntent);
            }
        });
    }
}
