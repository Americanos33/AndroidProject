package com.example.andoidproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andoidproject.modèle.Multiplication;
import com.example.andoidproject.modèle.tableMultiplication;

public class TableMultiplicationActivity extends AppCompatActivity {
    public static final String TAB_KEY = "table_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication2);
        int numtab =getIntent().getIntExtra(TAB_KEY,0);
        LinearLayout linear = findViewById(R.id.videdeluxe);
        tableMultiplication tablemutiplication = new tableMultiplication(numtab);
        for(Multiplication multiplication: tablemutiplication.getMultiplications()){
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul,null);

            TextView calcul =(TextView) linearTMP.findViewById(R.id.template_calcul);
            calcul.setText(multiplication.getOpe1()+"x"+multiplication.getOpe2());
            EditText resultat = (EditText) linearTMP.findViewById(R.id.template_resultat);
            resultat.setInputType(InputType.TYPE_CLASS_NUMBER);
            //resultat.setText(Integer.toString(multiplication.getOpe1()*multiplication.getOpe2()));


            linear.addView(linearTMP);
        }

    }
    public void tabvalider(View view){
        LinearLayout linear=findViewById(R.id.videdeluxe);
        int numtab =getIntent().getIntExtra(TAB_KEY,0);
        int cnt =0;
        boolean chk = false;
        tableMultiplication tablemutiplication = new tableMultiplication(numtab);

       for (int i=0; i<8 ;i++){
           LinearLayout lntmp = (LinearLayout) linear.getChildAt(i);
           EditText editmp =(EditText) lntmp.findViewById(R.id.template_resultat);
           Multiplication multiplication= new Multiplication(i+1,numtab);
           try{
           if (Integer.parseInt(editmp.getText().toString()) != multiplication.résultat()){
               cnt++;
           }}
           catch (NumberFormatException n){
               Context context = getApplicationContext();
               CharSequence text = "Remplissez tous les champs!";
               int duration = Toast.LENGTH_SHORT;

               Toast toast = Toast.makeText(context, text, duration);
               toast.show();
               chk=true;
               break;
               
           }
       }
       if (chk==false){
       if (cnt>0){
           Intent intent = new Intent(this, ErreurActivity.class);
           intent.putExtra(ErreurActivity.RES_KEY, cnt);
           startActivity(intent);
       }
       else {
           Intent intent = new Intent(this, FelicitationActivity.class);
           startActivity(intent);
       }

    }}


}