package com.example.uas13256;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainFirebaseNilai extends AppCompatActivity {
    RecyclerView recyclerViewNilai;
    DatabaseReference dbr;
    ArrayList<ModelNilai> modelNilaiArrayList=new ArrayList<>();
    ModelNilai modelNilai;
    FloatingActionButton tombolTambah;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_firebase_nilai);

        tombolTambah = findViewById(R.id.tmboltambah);

        recyclerViewNilai = findViewById(R.id.rv_nilai);

        dbr = FirebaseDatabase.getInstance().getReference();

        tampil_nilai();
        recyclerViewNilai.setLayoutManager(new LinearLayoutManager(this));

        tombolTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainFirebaseNilai.this, Beranda.class);
                startActivity(intent);
            }
        });
    }

    private void tampil_nilai() {
        dbr.child("Nilai").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    ModelNilai modelNilai=dataSnapshot.getValue(ModelNilai.class);
                    modelNilai.setKey(dataSnapshot.getKey());
                    modelNilaiArrayList.add(modelNilai);
                }

                AdapterNilai adapterNilai=new AdapterNilai(MainFirebaseNilai.this,modelNilaiArrayList);
                recyclerViewNilai.setAdapter(adapterNilai);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void kembali(View view) {
        Intent intent  = new Intent(MainFirebaseNilai.this, MainActivity.class);
        startActivity(intent);
    }
}