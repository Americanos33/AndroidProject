package com.example.andoidproject;

import java.util.ArrayList;
import java.util.Random;

public class TableOperation {
    private ArrayList<operation> operations = new ArrayList<>();
    private ArrayList<String> operandes = new ArrayList<>();
    private int maxop1;
    private int maxop2;


    public TableOperation( ArrayList<String> operandes,int maxop1,int maxop2) {
        this.maxop1= maxop1;
        this.maxop2= maxop2;
        this.operandes= operandes;
        init();
    }

    public void setOperandes(ArrayList<String> operandes) {
        this.operandes = operandes;
    }

    public void init(){
        for (int i=0; i<10 ;i++){
            int randop1 =(int)(Math.random() * (maxop1 + 1));
            int randop2 =(int)(Math.random() * (maxop2 + 1));
            String randoperateur =operandes.get((int)(Math.random() * (operandes.size())));
            operation operationcourante = new operation(randop1,randop2,randoperateur);
            this.operations.add(operationcourante);
        }
    }

    public ArrayList<operation> getOperations() {
        return operations;
    }
}