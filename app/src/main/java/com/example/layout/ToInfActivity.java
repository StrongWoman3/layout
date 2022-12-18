package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ToInfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_inf);

        tv = (TextView) findViewById(R.id.tv);
        String str = getIntent().getStringExtra("et");
    }
}