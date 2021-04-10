package com.example.andoidproject.db;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class DatabaseClient {

    // Instance unique permettant de faire le lien avec la base de données
    private static DatabaseClient instance;

    // Objet représentant la base de données de votre application
    private AppDatabase appDatabase;

    // Constructeur
    private DatabaseClient(final Context context) {

        // Créer l'objet représentant la base de données de votre application
        // à l'aide du "Room database builder"
        // MyToDos est le nom de la base de données
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "MyUsers").addCallback(roomDatabaseCallback).build();

        ////////// REMPLIR LA BD à la première création à l'aide de l'objet roomDatabaseCallback
        // Ajout de la méthode addCallback permettant de populate (remplir) la base de données à sa création
        //appDatabase = Room.databaseBuilder(context, AppDatabase.class, "MyToDos").addCallback(roomDatabaseCallback).build();
    }

    // Méthode statique
    // Retourne l'instance de l'objet DatabaseClient
    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    // Retourne l'objet représentant la base de données de votre application
    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    // Objet permettant de populate (remplir) la base de données à sa création
    RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {

        // Called when the database is created for the first time.
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // Definition des questions

            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGES\",\"Quelle planète surnomme-t-on la planète rouge ?\",\"Mars\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGES\",\"Laquelle de ces planètes est plus petite que la Terre ?\",\"Pluton\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGES\",\"Quelle planète surnomme-t-on la planète la plus proche du soleil ?\",\"Mercure\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGES\",\"Laquelle de ces planètes possède des anneaux ?\",\"Saturne\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGES\",\"Quelle est la plus grosse planète du système solaire ?\",\"Jupiter\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGES\",\"Quelle planète surnomme-t-on la planète bleu ?\",\"La Terre\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGES\",\"Qui n'est pas une planète ?\",\"La Lune\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGES\",\"Quelle planète est aussi grosse que la Terre ?  ?\",\"Vénus\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGES\",\"Quelle planète prends 164 ans pour tourner autour du Soleil ?\",\"Neptune\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGES\",\"Quelle planète est incliné à 90° sur son axe de rotation ?\",\"Uranus\");");

            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGCA\",\"Quelle est la capitale de Japon ?\",\"Tokyo\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGCA\",\"Quelle est la capitale de la Russie ?\",\"Moscou\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGCA\",\"Quelle est la capitale de la France ?\",\"Paris\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGCA\",\"Quelle est la capitale du l'Angleterre ?\",\"Londres\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGCA\",\"Quelle est la capitale des États-Unis ?\",\"Washington\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGCA\",\"Quelle est la capitale du Viêt Nam ?\",\"Hanoi\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGCA\",\"Quelle est la capitale de l'Espagne ?\",\"Madrid\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGCA\",\"Quelle est la capitale de  l'Australie ?\",\"Canberra\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGCA\",\"Quelle est la capitale de l'Argentine ?\",\"Buenos Aires\");");
            db.execSQL("INSERT INTO question (tag, questiontext, reponse) VALUES(\"CGCA\",\"Quelle est la capitale de l'Égypte ?\",\"Le Caire\");");



        }

    };
}
