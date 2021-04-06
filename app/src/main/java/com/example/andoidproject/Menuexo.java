package com.example.andoidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menuexo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuexo);
    }
    public void exomult(View view) {
        Intent intent = new Intent(Menuexo.this, Exercice5Activity.class);
        startActivity(intent);
    }
    public void exocalcul(View view) {
        Intent intent = new Intent(Menuexo.this, Paramexo.class);
        startActivity(intent);
    }

}