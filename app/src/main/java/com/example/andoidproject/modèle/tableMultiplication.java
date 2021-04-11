package com.example.andoidproject.modèle;

import java.util.ArrayList;

public class tableMultiplication {
    private ArrayList<Multiplication> multiplications= new ArrayList<Multiplication>();
    private int table;

    public tableMultiplication(int table) {
        this.table = table;
        initable();
    }

    public void initable(){
        for (int i=1; i<10 ;i++){
            Multiplication multiple = new Multiplication(i,table);
            this.multiplications.add(multiple);
        }

    }

    public ArrayList<Multiplication> getMultiplications() {
        return multiplications;
    }
}
