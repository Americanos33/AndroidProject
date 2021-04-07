package com.example.andoidproject;

import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andoidproject.db.DatabaseClient;
import com.example.andoidproject.db.User;

import java.util.ArrayList;
import java.util.List;

public class ConnectionActivity extends AppCompatActivity {

    // DATA
    private DatabaseClient mDb;
    private MyAdapter adapter ;

    private ListView listUsers;

    private MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        // Definition contexte
        app = ((MyApplication) this.getApplication());

        // Récuperer les vues
        listUsers = findViewById(R.id.list_view);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Lier adapter au listView
        adapter = new MyAdapter(this, new ArrayList<User>());
        listUsers.setAdapter(adapter);

        // Ajout du onclick de la listview
        listUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Récupération du user cliquée à l'aide de l'adapter
                User user = adapter.getItem(position);
                Log.e("myTag", "user : " + user);


                // Définition du user
                app.setUser(user);

                // Envoi vers la vue appropriée
                Intent intent = new Intent(ConnectionActivity.this, CompteActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getUsers() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des users et de mettre à jour le listView de l'activité
        class getUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = mDb.getAppDatabase()
                        .userDao()
                        .getAll();
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);

                // Mettre à jour l'adapter avec la liste de users
                adapter.clear();
                adapter.addAll(users);

                // Now, notify the adapter of the change in source
                adapter.notifyDataSetChanged();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        // Création d'un objet de type GetTasks et execution de la demande asynchrone
        getUsers gt = new getUsers();
        gt.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des users
        getUsers();

    }

}
