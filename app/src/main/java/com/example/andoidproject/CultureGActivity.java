package com.example.andoidproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CultureGActivity extends AppCompatActivity {

    // DATA
    private MyApplication app;

    // Buttons
    private Button espace, capitale, helpEspace, helpCapitale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_g);

        // Definition contexte
        app = ((MyApplication) this.getApplication());

        // Recuperation des bouttons
        espace = findViewById(R.id.button_quizzespace);
        capitale = findViewById(R.id.button_quizzcapitale);
        helpEspace = findViewById(R.id.button_help_espace);
        helpCapitale = findViewById(R.id.button_help_capitale);

        // Setting OnClickListner
        espace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Setting TAG courant
                app.setTag("CGES");

                // Redirection vue appropriée
                Intent intent = new Intent(CultureGActivity.this, QuizzvueActivity.class);
                startActivity(intent);
            }
        });

        // Setting OnClickListner
        capitale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Setting TAG courant
                app.setTag("CGCA");

                // Redirection vue appropriée
                Intent intent = new Intent(CultureGActivity.this, QuizzvueActivity.class);
                startActivity(intent);
            }
        });

        helpEspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(CultureGActivity.this)
                        .setMessage("Une suite de question concernant l'Espace")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

        helpCapitale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(CultureGActivity.this)
                        .setMessage("Une suite de question concernant les Capitales")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}