package com.example.elad.android5777;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.elad.android5777.model.datasource.customContentProvider;
import com.example.elad.android5777.model.sharedPreference.SharedPreferencesClass;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customContentProvider myProvider = new customContentProvider();
        ContentValues tempCP = new ContentValues();
        tempCP.put("id", 15);
        tempCP.put("name", "David");
        tempCP.put("password", "123456");
        myProvider.onCreate();
        SharedPreferencesClass sp = new SharedPreferencesClass();
        //String name = sp.getName();
        //String pass = sp.getPass();
        //if(name == "ERROR" || pass == "ERROR")

        //int userName = R.id.userName;
        EditText e = (EditText)findViewById(R.id.userName);
        String name = e.getText().toString();
        e.setText("Elad");
        //sp.add("David","123456");
        //String name = sp.getName();
        //String pass = sp.getPass();
        //myProvider.insert(Uri.parse("content://com.example.elad.android5777/User"), tempCP);


        // last change: 456123456
    }
}