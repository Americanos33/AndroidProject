package com.example.andoidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciceMultiplicationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice5);
        NumberPicker numpck = findViewById(R.id.numpick);
        numpck.setMaxValue(9);
        numpck.setMinValue(1);
    }
    public void tabvalider(View view){
        NumberPicker numpck = findViewById(R.id.numpick);
        int table = numpck.getValue();

        setResult(RESULT_OK);
        finish();

        Intent intent = new Intent(this, TableMultiplicationActivity.class);
        intent.putExtra(TableMultiplicationActivity.TAB_KEY, table);
        startActivity(intent);
    }
}
