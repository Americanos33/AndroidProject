package com.example.andoidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andoidproject.db.DatabaseClient;
import com.example.andoidproject.db.Question;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Quizzvue extends AppCompatActivity {

    // DATA
    private DatabaseClient mDb;

    private MyApplication app;

    private ArrayList<String> seenQuestionsList;

    private RadioButton b1, b2, b3;
    private RadioGroup radioGroup;
    private Button goNext;

    private String tag, mauvaiseRep1, mauvaiseRep2;

    private TextView questionText, compteur;

    private Integer score, pos, nbquestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzvue);

        // Definition contexte
        app = ((MyApplication) this.getApplication());
        tag = app.getTag();
        seenQuestionsList = new ArrayList<>();
        nbquestions = 1;
        score = 0;

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Recupération des elements de la vue
        b1 = findViewById(R.id.Porthos1);
        b2 = findViewById(R.id.Athos2);
        b3 = findViewById(R.id.Aramis3);
        questionText = findViewById(R.id.Question);
        goNext = findViewById(R.id.exercice1_suivant);
        radioGroup = findViewById(R.id.radio_group);
        compteur = findViewById(R.id.cnt);
        compteur.setText("1/10");

        // Binding OnClick to method CreationQuestion
        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Boolean de verification
                Boolean verif = true;

                // Verification des reponses
                if (b1.isChecked()){
                    if (pos == 1){
                        score += 1;
                    }
                } else if (b2.isChecked()){
                    if (pos == 2){
                        score += 1;
                    }
                } else if (b3.isChecked()){
                    if (pos == 3){
                        score += 1;
                    }
                } else {
                    verif = false;
                }

                if (!verif) {
                    Toast.makeText(Quizzvue.this, "Il faut choisir une réponse !", Toast.LENGTH_SHORT).show();
                } else if (nbquestions < 11 ){
                        // Setting du texte du compteur
                        compteur.setText(nbquestions + "/10");

                        // Uncheck des radio bouttons
                        radioGroup.clearCheck();

                        // Nouvelle question
                        CreationQuestion();
                } else {
                    Intent intent = new Intent(Quizzvue.this, Felicationexo.class);
                    intent.putExtra(Felicationexo.SCORE_KEY, score);
                    startActivity(intent);
                }
            }
        });

        // Lancement du set up pour chaque question
        CreationQuestion();

    }

    private void CreationQuestion(){
        // Recupération d'une Question Random
        nouvelleQuestion();

        // Incrémentation du nombre de question
        nbquestions += 1;
    }

    private void nouvelleQuestion(){
        // class asynchrone
        class nouvelleQuestion extends AsyncTask<Void, Void, Question> {

            @Override
            protected Question doInBackground(Void... voids) {
                // Creating new question
                Question q = mDb.getAppDatabase()
                        .questionDao()
                        .getQuestionRandomByTag(tag, seenQuestionsList);

                // Setting the seenQuestionList with the question
                seenQuestionsList.add(q.getQuestiontext());

                // Modifying the view with the question settings
                questionText.setText(q.getQuestiontext());

                mauvaisesRep(q);

                return q;
            }

            @Override
            protected void onPostExecute(Question question) {
                super.onPostExecute(question);
            }
        }

        nouvelleQuestion nv = new nouvelleQuestion();
        nv.execute();
    }

    private void mauvaisesRep(Question q){
        // classe asynchrone
        class mauvaisesRep extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                // recuperation tag courant
                String tag = app.getTag();

                // recuperation de deux mauvaises reponses
                mauvaiseRep1 = mDb.getAppDatabase().questionDao().getFalseAnswersByQuestion(q.getQuestiontext(), tag, "");
                mauvaiseRep2 = mDb.getAppDatabase().questionDao().getFalseAnswersByQuestion(q.getQuestiontext(), tag, mauvaiseRep1);

                // Random entre 1 et 3 pour determiner l'emplacement de la bonne reponse
                int i = ThreadLocalRandom.current().nextInt(1, 4);

                // Definition des reponses
                if (i == 1){
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            // placement de la bonne reponse + setting de sa position
                            b1.setText(q.getReponse());
                            pos = 1;

                            // placement des autres reponses
                            b2.setText(mauvaiseRep1);
                            b3.setText(mauvaiseRep2);

                        }
                    });
                } else if (i == 2){
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            // placement de la bonne reponse + setting de sa position
                            b2.setText(q.getReponse());
                            pos = 2;

                            // placement des autres reponses
                            b1.setText(mauvaiseRep1);
                            b3.setText(mauvaiseRep2);

                        }
                    });
                } else if (i == 3){
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            // placement de la bonne reponse + setting de sa position
                            b3.setText(q.getReponse());
                            pos = 3;

                            // placement des autres reponses
                            b1.setText(mauvaiseRep1);
                            b2.setText(mauvaiseRep2);

                        }
                    });
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void v) {
                super.onPostExecute(v);
            }
        }

        mauvaisesRep mr = new mauvaisesRep();
        mr.execute();
    }
}