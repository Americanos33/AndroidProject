package com.example.andoidproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuexoActivity extends AppCompatActivity {

    // DATA
    private MyApplication app;

    // Buttons
    private Button helpMultiplication, helpCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuexo);

        // Definition contexte
        app = ((MyApplication) this.getApplication());

        // Recuperation des elements de la vue
        helpMultiplication = findViewById(R.id.button_help_multiplication);
        helpCalcul = findViewById(R.id.button_help_calcul);

        // Definition des OnClickListener
        helpMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MenuexoActivity.this)
                        .setMessage("Une suite de question concernant les multiplications")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

        helpCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MenuexoActivity.this)
                        .setMessage("Une suite de question concernant des calculs, avec vos paramètres")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

    }
    public void exomult(View view) {
        // Definition du tag de l'exercice
        app.setTag("MAMU");

        Intent intent = new Intent(MenuexoActivity.this, ExerciceMultiplicationActivity.class);
        startActivity(intent);
    }
    public void exocalcul(View view) {
        // Definition du tag de l'exercice
        app.setTag("MACA");

        Intent intent = new Intent(MenuexoActivity.this, ParamexoActivity.class);
        startActivity(intent);
    }

}