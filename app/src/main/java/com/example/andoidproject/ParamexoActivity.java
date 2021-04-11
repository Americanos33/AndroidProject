package com.example.andoidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class ParamexoActivity extends AppCompatActivity {
    private ArrayList<String> listoperateurs = new ArrayList<>();
    private ArrayList<Integer> dizaines = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paramexo);
        CheckBox unit1 =findViewById(R.id.unite1);
        unit1.setChecked(true);
        unit1.setClickable(false);
        CheckBox unit2 =findViewById(R.id.unite2);
        unit2.setChecked(true);
        unit2.setClickable(false);
        dizaines.clear();

    }
    public void retour(View view){
        super.finish();

    }

    public void coherentchckbox(View view){
        CheckBox dizaine1= findViewById(R.id.dizaine1);
        CheckBox dizaine2= findViewById(R.id.dizaine2);
        CheckBox centaine1= findViewById(R.id.centaine1);
        CheckBox centaine2= findViewById(R.id.centaine2);

        if(centaine1.isChecked()){
            dizaine1.setChecked(true);
        }
        if(centaine2.isChecked()){
            dizaine2.setChecked(true);
        }


    }
    public void continuercalcul(View view) {
        listoperateurs.clear();
        boolean timer=false;
        //Les boutons des operateurs
        ToggleButton plsbtn = findViewById(R.id.pls);
        ToggleButton minbtn = findViewById(R.id.min);
        ToggleButton divbtn = findViewById(R.id.div);
        ToggleButton mltbtn = findViewById(R.id.mult);
        //boutons des dizaines
        CheckBox dizaine1= findViewById(R.id.dizaine1);
        CheckBox dizaine2= findViewById(R.id.dizaine2);
        CheckBox centaine1= findViewById(R.id.centaine1);
        CheckBox centaine2= findViewById(R.id.centaine2);
        //timer
        ToggleButton timeon = findViewById(R.id.timeon);
        if (timeon.isChecked()){
            timer=true;
        }


        if (dizaine1.isChecked()  && !centaine1.isChecked()){
            dizaines.add(99);
        }
        if (dizaine2.isChecked() && !centaine2.isChecked()){
            dizaines.add(99);
        }
        if (centaine1.isChecked()){
            dizaines.add(999);
        }
        if (centaine2.isChecked()){
            dizaines.add(999);
        }
        if (plsbtn.isChecked()){
            listoperateurs.add(plsbtn.getTextOn().toString());
        }
        if (minbtn.isChecked()){
            listoperateurs.add(minbtn.getTextOn().toString());
        }
        if (mltbtn.isChecked()){
            listoperateurs.add(mltbtn.getTextOn().toString());
        }
        if (divbtn.isChecked()){
            listoperateurs.add(divbtn.getTextOn().toString());
        }

        if (listoperateurs.isEmpty()){
            Context context = getApplicationContext();
            CharSequence text = "Choissisez un operateur!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if(dizaines.isEmpty()){
                dizaines.add(9);
                dizaines.add(9);
                            }
        Intent intent = new Intent(ParamexoActivity.this, ExerciceCalculActivity.class);
        intent.putExtra(ExerciceCalculActivity.PARAMETERS,listoperateurs);
        intent.putExtra(ExerciceCalculActivity.DIZAINES,dizaines);
        intent.putExtra(ExerciceCalculActivity.TIMER,timer);
        startActivity(intent);}
    }

    //step 1:get all the parameters we want to pass ou
    //Step 2:create a new table of operations
    //Step 3:display all of the table one by one

}