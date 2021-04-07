package com.example.andoidproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andoidproject.db.DatabaseClient;
import com.example.andoidproject.db.User;

public class InscriptionActivity extends AppCompatActivity {

    // DATA
    private DatabaseClient mDb;

    // VIEW
    private EditText editTextPrenomView;
    private EditText editTextNomView;
    private EditText editTextAgeView;
    private EditText editTextSexeView;
    private Button saveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        editTextPrenomView = findViewById(R.id.editTextPrenom);
        editTextNomView = findViewById(R.id.editTextNom);
        editTextAgeView = findViewById(R.id.editTextAge);
        editTextSexeView = findViewById(R.id.editTextSexe);
        saveView = findViewById(R.id.button_save);

        // Associer un événement au bouton save
        saveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser();
            }
        });
    }

    private void saveUser() {

        // Récupérer les informations contenues dans les vues
        final String sPrenom = editTextPrenomView.getText().toString().trim();
        final String sNom = editTextNomView.getText().toString().trim();
        final String sAge = editTextAgeView.getText().toString().trim();
        final String sSexe = editTextSexeView.getText().toString().trim();


        // Vérifier les informations fournies par l'utilisateur
        if (sPrenom.isEmpty()) {
            editTextPrenomView.setError("Task required");
            editTextPrenomView.requestFocus();
            return;
        }

        if (sNom.isEmpty()) {
            editTextNomView.setError("Desc required");
            editTextNomView.requestFocus();
            return;
        }

        if (sAge.isEmpty()) {
            editTextAgeView.setError("Task required");
            editTextAgeView.requestFocus();
            return;
        }

        if (sSexe.isEmpty()) {
            editTextSexeView.setError("Task required");
            editTextSexeView.requestFocus();
            return;
        }

        /**
         * Création d'une classe asynchrone pour sauvegarder la tache donnée par l'utilisateur
         */
        class SaveUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                // creating a task
                User user = new User();
                user.setPrenom(sPrenom);
                user.setNom(sNom);
                user.setAge(sAge);
                user.setSexe(sSexe);

                // adding to database
                mDb.getAppDatabase()
                        .userDao()
                        .insert(user);

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                // Quand la tache est créée, on arrête l'activité AddTaskActivity (on l'enleve de la pile d'activités)
                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        SaveUser st = new SaveUser();
        st.execute();

        Intent intent = new Intent(this, ConnectionActivity.class);
        startActivity(intent);
    }
}
