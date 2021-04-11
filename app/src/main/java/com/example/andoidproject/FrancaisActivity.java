package com.example.andoidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FrancaisActivity extends AppCompatActivity {

    // DATA
    private MyApplication app;

    // Buttons
    private Button grammaire, conjugaison;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_francais);

        // Definition du contexte
        app = ((MyApplication) this.getApplication());

        // Recuperation des elements de la vue
        grammaire = findViewById(R.id.button_quizzgrammaire);
        conjugaison = findViewById(R.id.button_quizzconjugaison);

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
    }
}
