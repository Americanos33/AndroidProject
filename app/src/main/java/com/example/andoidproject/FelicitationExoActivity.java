package com.example.andoidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FelicitationExoActivity extends AppCompatActivity {

    public static final String SCORE_KEY = "bonnerep_key";

    private MyApplication myapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Creation du contexte
        myapp = ((MyApplication) this.getApplication());

        // Initialisation de la vue
        setContentView(R.layout.activity_felicationexo);

        // Recuperation des elements de la vue
        TextView nberr = findViewById(R.id.nberr);

        // Recuperation du score
        int bonnesrep=getIntent().getIntExtra(SCORE_KEY,0);

        // Defintion du texte correspondant
        nberr.setText(String.valueOf(bonnesrep));
    }
    public void pagexo(View view){

        if (myapp.getTag() == "CGES" || myapp.getTag() == "CGCA" || myapp.getTag() == "FRCO" || myapp.getTag() == "FRGR") {
            Intent intent = new Intent(this, QuizzvueActivity.class);
            startActivity(intent);
        } else if (myapp.getTag() == "MAMU" || myapp.getTag() == "MACA") {
            Intent intent = new Intent(this, ParamexoActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
    public void pagemenu(View view){

        if (myapp.getTag() == "CGES" || myapp.getTag() == "CGCA" || myapp.getTag() == "FRCO" || myapp.getTag() == "FRGR") {
            Intent intent = new Intent(this, CultureGActivity.class);
            startActivity(intent);
        } else if (myapp.getTag() == "MAMU" || myapp.getTag() == "MACA") {
            Intent intent = new Intent(this, MenuexoActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    public void pagetheme(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}