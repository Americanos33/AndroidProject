package com.example.andoidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void MATH(View view) {
        Intent intent = new Intent(MenuActivity.this, MenuexoActivity.class);
        startActivity(intent);
    }
    public void CULTUREG(View view) {
        Intent intent = new Intent(MenuActivity.this, CultureGActivity.class);
        startActivity(intent);
    }

}
