package com.volpato;

import java.util.ArrayList;

//implementação de uma pilha para armazenamento de inteiros

public class Pilha {

    private int [] arranjo;
    private int topo;
    
    public Pilha(){
        this.arranjo = new int[10];
    }

    public Pilha(int capacidade) {
        this.arranjo = new int[capacidade];
        this.topo=0;
    }

    //insere o elemento e no topo da pilha
    public boolean push(int e) {
        arranjo[topo]=e;
        topo++;
        return true;
    }

    

}