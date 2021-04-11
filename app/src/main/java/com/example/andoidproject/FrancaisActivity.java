package com.example.andoidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FrancaisActivity extends AppCompatActivity {

    // DATA
    private MyApplication app;

    // Buttons
    private Button grammaire, conjugaison, helpGrammaire, helpConjugaison;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_francais);

        // Definition du contexte
        app = ((MyApplication) this.getApplication());

        // Recuperation des elements de la vue
        grammaire = findViewById(R.id.button_quizzgrammaire);
        conjugaison = findViewById(R.id.button_quizzconjugaison);
        helpGrammaire = findViewById(R.id.button_help_grammaire);
        helpConjugaison = findViewById(R.id.button_help_conjugaison);

        // Setting des OnClickListener
        grammaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Definition du tag courant
                app.setTag("FRGR");

                // Redirection vers la vue appropirée
                Intent intent = new Intent(FrancaisActivity.this, QuizzvueActivity.class);
                startActivity(intent);
            }
        });

        conjugaison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Definition du tag courant
                app.setTag("FRCO");

                // Redirection vers la vue appropirée
                Intent intent = new Intent(FrancaisActivity.this, QuizzvueActivity.class);
                startActivity(intent);
            }
        });

        helpGrammaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(FrancaisActivity.this)
                        .setMessage("Une suite de question concernant la grammaire")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

        helpConjugaison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(FrancaisActivity.this)
                        .setMessage("Une suite de question concernant la conjugaison")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}
