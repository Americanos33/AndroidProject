package com.example.andoidproject;

import java.util.Random;

public class operation {
    private int op1;
    private int op2;
    private String operande;

    public operation(int op1, int op2, String operande) {
        this.op1 = op1;
        this.op2 = op2;
        this.operande = operande;
    }

    public int getOp1() {
        return op1;
    }

    public int getOp2() {
        return op2;
    }

    public String getOperande() {
        return operande;
    }

    public int resultat(){
        int res= 0;
        switch (operande){
            case "×":
                res= op1*op2;
                break;
            case "÷":
                res= op1/op2;
                break;
            case "+":
                res= op1+op2;
                break;
            case "-":
                res= op1-op2;
                break;
            default:
                res= 0;
        }
        return res;
    }


}
