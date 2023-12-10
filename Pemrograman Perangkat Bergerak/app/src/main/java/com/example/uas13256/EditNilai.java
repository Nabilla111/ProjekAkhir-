package com.example.uas13256;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditNilai extends AppCompatActivity {
    EditText ekode,ematkul,esks,enangka,enhuruf,epredikat;
    Button updatetombol,hapustombol;

    DatabaseReference dbr;
    ModelNilai modelNilai;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nilai);

        ekode=findViewById(R.id.editkode);
        ematkul=findViewById(R.id.editMatkul);
        esks=findViewById(R.id.editsks);
        enangka=findViewById(R.id.editangka);
        enhuruf=findViewById(R.id.edithuruf);
        epredikat=findViewById(R.id.editpredikat);

        dbr= FirebaseDatabase.getInstance().getReference();
        modelNilai=new ModelNilai();

        Bundle bundle=getIntent().getExtras();
        ekode.setText(bundle.getString("kode"));
        ematkul.setText(bundle.getString("matkul"));
        esks.setText(bundle.getString("sks"));
        enangka.setText(bundle.getString("nangka"));
        enhuruf.setText(bundle.getString("nhuruf"));
        epredikat.setText(bundle.getString("predikat"));

        updatetombol=findViewById(R.id.buttonsimpan);
        hapustombol=findViewById(R.id.buttondelete);

        updatetombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modelNilai.setKode(ekode.getText().toString());
                modelNilai.setMata_kuliah(ematkul.getText().toString());
                modelNilai.setSks(esks.getText().toString());
                modelNilai.setN_angka(enangka.getText().toString());
                modelNilai.setN_huruf(enhuruf.getText().toString());
                modelNilai.setPredikat(epredikat.getText().toString());
                Intent intent=new Intent(EditNilai.this, MainFirebaseNilai.class);
                startActivity(intent);
                String kunci=(bundle.getString("kunci"));
                dbr.child("Nilai").child(kunci).setValue(modelNilai).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(EditNilai.this, "Update sukses", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        hapustombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}