package com.example.andoidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andoidproject.modèle.TableOperation;

import java.util.ArrayList;

public class ExerciceCalculActivity extends AppCompatActivity {
    public static final String PARAMETERS="parameter_key";
    public static final String DIZAINES="dizaines_key";
    public static final String TIMER="timer_key";
    private ArrayList<Integer> reponses = new ArrayList<>();
    private TableOperation operation;
    private boolean istimer;
    int cnt;
    int cntrepj;
    CountDownTimer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);

        TextView timer = findViewById(R.id.timer);

         istimer = getIntent().getBooleanExtra(TIMER,false);
        int Maxop1 =getIntent().getIntegerArrayListExtra(DIZAINES).get(0);
        int Maxop2 =getIntent().getIntegerArrayListExtra(DIZAINES).get(1);
        if (istimer== true){
            operation = new TableOperation(getIntent().getStringArrayListExtra(PARAMETERS),Maxop1,Maxop2,true);
            t = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText( millisUntilFinished / 1000 + "secondes" );

            }

            public void onFinish() {
                Intent intent = new Intent(ExerciceCalculActivity.this, FelicitationExoActivity.class);
                intent.putExtra(FelicitationExoActivity.SCORE_KEY, cntrepj);
                startActivity(intent);
            }
        }.start();

        } else {
        operation = new TableOperation(getIntent().getStringArrayListExtra(PARAMETERS),Maxop1,Maxop2);
        }
        TextView calc = findViewById(R.id.calcul);
        Button btnp = findViewById(R.id.btnprec);
        TextView textcnt = findViewById(R.id.cnt);
        EditText resinp= findViewById(R.id.resinp);
        btnp.setText("Retour");
        cnt=0;
        calc.setText(operation.getOperations().get(0).getOp1() + operation.getOperations().get(0).getOperande() + operation.getOperations().get(0).getOp2());
        if (!istimer){
            textcnt.setText(cnt+1 +"/10");
        } else {
            textcnt.setText("");
        }

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
                if (!istimer){
                    textcnt.setText(cnt + 1 + "/10");
                }

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
                Intent intent = new Intent(ExerciceCalculActivity.this, FelicitationExoActivity.class);
                intent.putExtra(FelicitationExoActivity.SCORE_KEY, cntrepj);
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
            if (!istimer){
            textcnt.setText(cnt-1 +"/10");}
            cnt--;
        }
        else if (cnt == operation.getOperations().size()){
            calc.setText(operation.getOperations().get(cnt-2).getOp1() + operation.getOperations().get(cnt-1).getOperande() + operation.getOperations().get(cnt-2).getOp2());
            resinp.setText(String.valueOf(reponses.get(cnt-2)));
            cntrepj--; if (!istimer){
            textcnt.setText(cnt-1 +"/10");}
            cnt--;

        }
    }

    @Override
    public void onBackPressed(){
        // Reset du timer
        t.cancel();
        t = null;

        // Sortie de l'activite
        setResult(RESULT_OK);
        finish();
    }

}