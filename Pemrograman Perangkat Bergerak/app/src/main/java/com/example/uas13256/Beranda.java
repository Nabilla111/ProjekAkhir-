package com.example.uas13256;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Beranda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
    }

    public void entryNilai(View view) {
        Intent intent=new Intent(Beranda.this, MainActivity.class);
        startActivity(intent);
    }

    public void tampilNilai(View view) {
        Intent intent=new Intent(Beranda.this, MainFirebaseNilai.class);
        startActivity(intent);
    }
}