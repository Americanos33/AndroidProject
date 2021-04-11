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
    private Button PPF, BA, helpPPF, helpBA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_francais);

        // Definition du contexte
        app = ((MyApplication) this.getApplication());

        // Recuperation des elements de la vue
        PPF = findViewById(R.id.button_quizzPPF);
        BA = findViewById(R.id.button_quizzBA);
        helpPPF = findViewById(R.id.button_help_PPF);
        helpBA = findViewById(R.id.button_help_BA);

        // Setting des OnClickListener
        PPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Definition du tag courant
                app.setTag("FRGR");

                // Redirection vers la vue appropirée
                Intent intent = new Intent(FrancaisActivity.this, QuizzvueActivity.class);
                startActivity(intent);
            }
        });

        BA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Definition du tag courant
                app.setTag("FRCO");

                // Redirection vers la vue appropirée
                Intent intent = new Intent(FrancaisActivity.this, QuizzvueActivity.class);
                startActivity(intent);
            }
        });

        helpPPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(FrancaisActivity.this)
                        .setMessage("Une suite de question concernant les temps de conjugaison")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

        helpBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(FrancaisActivity.this)
                        .setMessage("Une suite de question concernant les adjectifs")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
}
