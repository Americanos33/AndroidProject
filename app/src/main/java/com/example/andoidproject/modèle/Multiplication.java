package com.example.andoidproject.modèle;

public class Multiplication {
    private int ope1;
    private int ope2;

    public Multiplication(int ope1, int ope2) {
        this.ope1 = ope1;
        this.ope2 = ope2;
    }

    public int getOpe1() {
        return ope1;
    }

    public int getOpe2() {
        return ope2;
    }
    public int résultat(){
        return ope1*ope2;

    }
}
