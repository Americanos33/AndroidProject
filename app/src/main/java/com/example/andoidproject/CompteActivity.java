package com.example.andoidproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Update;

import com.example.andoidproject.db.DatabaseClient;
import com.example.andoidproject.db.User;

import org.w3c.dom.Text;

import java.util.List;

public class CompteActivity extends AppCompatActivity {

    // DATA
    private DatabaseClient mDb;

    private MyApplication app;

    private User user;

    private EditText Nom, Prenom, Age, Sexe;
    private Button button_suppr, button_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compte);

        // Definition contexte
        app = ((MyApplication) this.getApplication());

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Recuperation des view afin de modifier le texte
        Nom = findViewById(R.id.CompteViewNom);
        Prenom = findViewById(R.id.CompteViewPrenom);
        Age = findViewById(R.id.CompteViewAge);
        Sexe = findViewById(R.id.CompteViewSexe);
        button_suppr = findViewById(R.id.button_supprimer);
        button_edit = findViewById(R.id.button_edit);

        // Recuperation du user
        user = ((MyApplication) CompteActivity.this.getApplication()).getUser();
        Toast.makeText(CompteActivity.this, "user : " + user, Toast.LENGTH_SHORT).show();

        // Modification du texte
        Nom.setText(user.getNom());
        Prenom.setText(user.getPrenom());
        Age.setText(user.getAge());
        Sexe.setText(user.getSexe());

        // Empecher l'utilisateur de modifier le texte immediatement
        Nom.setEnabled(false);
        Prenom.setEnabled(false);
        Age.setEnabled(false);
        Sexe.setEnabled(false);

        // Set du OnClick
        button_suppr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SupprimerUser();
            }
        });

    }

    public void Jouer(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void Edit(View view) {
        Nom.setEnabled(true);
        Prenom.setEnabled(true);
        Age.setEnabled(true);
        Sexe.setEnabled(true);

        button_edit.setText("Update");
        button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nom.setEnabled(false);
                Prenom.setEnabled(false);
                Age.setEnabled(false);
                Sexe.setEnabled(false);
                UpdateUser();
            }
        });
    }

    private void SupprimerUser(){
        // Class asynchrone
        class SupprimerUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                // getting the current user
                User user = app.getUser();

                // deleting it from the database
                mDb.getAppDatabase()
                        .userDao()
                        .delete(user);

                return null;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                // Quand la tache est créée, on arrête l'activité AddTaskActivity (on l'enleve de la pile d'activités)
                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        SupprimerUser supprU = new SupprimerUser();
        supprU.execute();

        Intent intent = new Intent(this, ConnectionActivity.class);
        startActivity(intent);

    }

    private void UpdateUser(){
        // classe asynchrone
        class UpdateUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                // getting the current user
                User user = app.getUser();

                // Updating the infos
                user.setNom(String.valueOf(Nom.getText()));
                user.setPrenom(String.valueOf(Prenom.getText()));
                user.setAge(String.valueOf(Age.getText()));
                user.setSexe(String.valueOf(Sexe.getText()));

                // Updating it in the database
                mDb.getAppDatabase()
                        .userDao()
                        .update(user);

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                // Quand la tache est créée, on arrête l'activité AddTaskActivity (on l'enleve de la pile d'activités)
                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        UpdateUser updateUser = new UpdateUser();
        updateUser.execute();

        Intent intent = new Intent(this, CompteActivity.class);
        startActivity(intent);
    }
}
