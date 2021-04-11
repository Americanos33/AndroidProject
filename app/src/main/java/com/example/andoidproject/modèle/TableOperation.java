package com.example.andoidproject.modèle;

import java.util.ArrayList;

public class TableOperation {
    private ArrayList<operation> operations = new ArrayList<>();
    private ArrayList<String> operandes;
    private boolean timer;
    private int maxop1;
    private int maxop2;


    public TableOperation( ArrayList<String> operandes,int maxop1,int maxop2) {
        this.maxop1= maxop1;
        this.maxop2= maxop2;
        this.operandes= operandes;
        init();
    }

    public TableOperation(ArrayList<String> operandes, int maxop1, int maxop2, boolean timer) {
        this.operandes = operandes;
        this.timer = timer;
        this.maxop1 = maxop1;
        this.maxop2 = maxop2;
        initwtimer();
    }

    public void setOperandes(ArrayList<String> operandes) {
        this.operandes = operandes;
    }

    public void initwtimer(){

        for (int i=0; i<200 ;i++){
            int randop1 =(int)(Math.random() * (maxop1 + 1));
            int randop2 =(int)(Math.random() * (maxop2 + 1));
            String randoperateur =operandes.get((int)(Math.random() * (operandes.size())));
            if (randoperateur.equals("-")) {

                while(randop1 < randop2){
                    randop1 =(int)(Math.random() * (maxop1 + 1));
                    randop2 =(int)(Math.random() * (maxop2 + 1));
                }
                operation operationcourante = new operation(randop1,randop2,randoperateur);
                this.operations.add(operationcourante);
            }else if(randoperateur.equals("÷")){
                while(randop1==0 || randop2==0){
                    randop1 =(int)(Math.random() * (maxop1 + 1));
                    randop2 =(int)(Math.random() * (maxop2 + 1));
                }
                operation operationcourante = new operation(randop1,randop2,randoperateur);
                this.operations.add(operationcourante);
            }else {
                operation operationcourante = new operation(randop1,randop2,randoperateur);
                this.operations.add(operationcourante);
            }
        }
    }

    public void init(){
        for (int i=0; i<10 ;i++){
            int randop1 =(int)(Math.random() * (maxop1 + 1));
            int randop2 =(int)(Math.random() * (maxop2 + 1));
            String randoperateur =operandes.get((int)(Math.random() * (operandes.size())));
            if (randoperateur.equals("-")) {

                while(randop1 < randop2){
                     randop1 =(int)(Math.random() * (maxop1 + 1));
                     randop2 =(int)(Math.random() * (maxop2 + 1));
                }
                operation operationcourante = new operation(randop1,randop2,randoperateur);
                this.operations.add(operationcourante);
            }else if(randoperateur.equals("÷")){
                while(randop1==0 || randop2==0){
                    randop1 =(int)(Math.random() * (maxop1 + 1));
                    randop2 =(int)(Math.random() * (maxop2 + 1));
                }
                operation operationcourante = new operation(randop1,randop2,randoperateur);
                this.operations.add(operationcourante);
            }else {
            operation operationcourante = new operation(randop1,randop2,randoperateur);
            this.operations.add(operationcourante);
            }
        }
    }

    public ArrayList<operation> getOperations() {
        return operations;
    }
}
