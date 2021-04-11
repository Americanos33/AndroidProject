package com.example.andoidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menuexo extends AppCompatActivity {

    // DATA
    private MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuexo);

        // Definition contexte
        app = ((MyApplication) this.getApplication());
    }
    public void exomult(View view) {
        // Definition du tag de l'exercice
        app.setTag("MAMU");

        Intent intent = new Intent(Menuexo.this, Exercice5Activity.class);
        startActivity(intent);
    }
    public void exocalcul(View view) {
        // Definition du tag de l'exercice
        app.setTag("MACA");

        Intent intent = new Intent(Menuexo.this, Paramexo.class);
        startActivity(intent);
    }

}