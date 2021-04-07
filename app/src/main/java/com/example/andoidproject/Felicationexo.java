package com.example.andoidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Felicationexo extends AppCompatActivity {
    public static final String ERREUR_KEY = "erreur_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicationexo);
        TextView nberr = findViewById(R.id.nberr);
        int erreur=getIntent().getIntExtra(ERREUR_KEY,0);
        nberr.setText(String.valueOf(erreur));
    }
    public void pagexo(View view){
        Intent intent = new Intent(this, Paramexo.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    public void pagemenu(View view){
        Intent intent = new Intent(this, Menuexo.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}