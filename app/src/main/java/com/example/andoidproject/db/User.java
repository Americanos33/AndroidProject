package com.example.andoidproject.db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "prenom")
    private String prenom;

    @ColumnInfo(name = "nom")
    private String nom;

    @ColumnInfo(name = "age")
    private String age;

    @ColumnInfo(name = "sexe")
    private String sexe;

    /*@ColumnInfo(name = "high_scores")
    private String[] high_scores;*/

    /*
     * Getters and Setters
     * */

    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getAge() {
        return age;
    }

    public String getSexe() {
        return sexe;
    }

    /*public String[] getHigh_scores() {
        return high_scores;
    }*/

    public void setId(int id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /*public void setHigh_scores(String[] high_scores) {
        this.high_scores = high_scores;
    }*/
}