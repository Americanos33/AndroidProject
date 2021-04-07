package com.example.andoidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.andoidproject.db.DatabaseClient;
import com.example.andoidproject.db.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // DATA
    private DatabaseClient mDb;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Continuer(View view) {
        Intent intent = new Intent(MainActivity.this, AcceuilActivity.class);
        startActivity(intent);
    }

}