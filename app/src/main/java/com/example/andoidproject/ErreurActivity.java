package com.example.andoidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ErreurActivity extends AppCompatActivity {
    public static final String RES_KEY = "res_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur);
        int numtab =getIntent().getIntExtra(RES_KEY,0);
        TextView err = findViewById(R.id.nberr);
        err.setText(String.valueOf(numtab));
    }
    public void changer(View view){
        super.finish();
    }
    public void changertable(View view){
        Intent intent = new Intent(this, TableMultiplicationActivity2.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}