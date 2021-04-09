package com.example.andoidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class calcul extends AppCompatActivity {
    public static final String PARAMETERS="parameter_key";
    public static final String DIZAINES="dizaines_key";
    private ArrayList<Integer> reponses = new ArrayList<>();
    private TableOperation operation;
    int cnt;
    int cntrepj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        int Maxop1 =getIntent().getIntegerArrayListExtra(DIZAINES).get(0);
        int Maxop2 =getIntent().getIntegerArrayListExtra(DIZAINES).get(1);
        operation = new TableOperation(getIntent().getStringArrayListExtra(PARAMETERS),Maxop1,Maxop2);
        TextView calc = findViewById(R.id.calcul);
        Button btnp = findViewById(R.id.btnprec);
        TextView textcnt = findViewById(R.id.cnt);
        EditText resinp= findViewById(R.id.resinp);
        btnp.setText("Retour");
        cnt=0;
        calc.setText(operation.getOperations().get(0).getOp1() + operation.getOperations().get(0).getOperande() + operation.getOperations().get(0).getOp2());
        textcnt.setText(cnt+1 +"/10");
        cnt++;



    }
    public void opesuiv(View view) {
        TextView calc = findViewById(R.id.calcul);
        EditText resinp= findViewById(R.id.resinp);
        Button btns = findViewById(R.id.btnsuiv);
        Button btnp = findViewById(R.id.btnprec);
        TextView textcnt = findViewById(R.id.cnt);

        if( String.valueOf(resinp.getText()).isEmpty()){
            Context context = getApplicationContext();
            CharSequence text = "Rentrez une valeur!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else {
            if (cnt == operation.getOperations().size() - 1) {
                btns.setText("Valider");
            }
            if (cnt < operation.getOperations().size()) {
                textcnt.setText(cnt + 1 + "/10");
                calc.setText(operation.getOperations().get(cnt).getOp1() + operation.getOperations().get(cnt).getOperande() + operation.getOperations().get(cnt).getOp2());
                    reponses.add(Integer.parseInt(String.valueOf(resinp.getText())));
                    reponses.set(cnt-1,Integer.parseInt(String.valueOf(resinp.getText())));
                if (reponses.get(cnt-1)==operation.getOperations().get(cnt - 1).resultat()){
                    cntrepj++;
                }
                resinp.setText("");

                btnp.setText("Precedent");
                cnt++;


            } else if (cnt == operation.getOperations().size()) {
                reponses.add(Integer.parseInt(String.valueOf(resinp.getText())));
                reponses.set(cnt-1,Integer.parseInt(String.valueOf(resinp.getText())));
                if (reponses.get(cnt-1)==operation.getOperations().get(cnt - 1).resultat()){
                    cntrepj++;
                }
                Intent intent = new Intent(calcul.this, Felicationexo.class);
                intent.putExtra(Felicationexo.ERREUR_KEY, cntrepj);
                startActivity(intent);
            }
        }
    }
    public void opeprec(View view){
        EditText resinp= findViewById(R.id.resinp);
        TextView calc = findViewById(R.id.calcul);
        Button btn = findViewById(R.id.btnprec);
        TextView textcnt = findViewById(R.id.cnt);
        if (cnt-1==0){
            reponses.clear();
            super.finish();
            cntrepj=0;
        }
        if (cnt == 1 ){
            btn.setText("Retour");
            if (cntrepj<=0){
               cntrepj=0;
            }else {
                cntrepj--;
            }

            cnt--;
        }
        else if (cnt > 1 && cnt!=operation.getOperations().size()){
            calc.setText(operation.getOperations().get(cnt-2).getOp1() + operation.getOperations().get(cnt-2).getOperande() + operation.getOperations().get(cnt-2).getOp2());
            resinp.setText(String.valueOf(reponses.get(cnt-2)));
            reponses.remove(reponses.get(reponses.size()-1));
            if (cntrepj<=0){
                cntrepj=0;
            }else {
                cntrepj--;
            }
            textcnt.setText(cnt-1 +"/10");
            cnt--;
        }
        else if (cnt == operation.getOperations().size()){
            calc.setText(operation.getOperations().get(cnt-2).getOp1() + operation.getOperations().get(cnt-1).getOperande() + operation.getOperations().get(cnt-2).getOp2());
            resinp.setText(String.valueOf(reponses.get(cnt-2)));
            cntrepj--;
            textcnt.setText(cnt-1 +"/10");
            cnt--;

        }
    }

}