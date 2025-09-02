package com.volpato;
   
public class Fila {

    private int[] arranjo;
    private int fimDafila;

    public Fila() {
        arranjo = new int[10];
        fimDafila = 0;
    }

    public Fila(int capacidade) {
        arranjo = new int[capacidade];
        fimDafila=0;
    }

    //insere o elemento e no final da fila
    public boolean enqueue(int e){
        if(fimDafila>=arranjo.length)
            return false;
        arranjo[fimDafila]=e;
        fimDafila++;
        return true;
    }

    //remove e retorna o elemento e do início da fila, e dá erro se a fila estiver vazia
    public int dequeue(){
        if(fimDafila==0)
            throw new RuntimeException("A fila está vazia");
        
        int elementoASerRetornado=arranjo[0];
        // processo de "passinho a frente"
        for(int idx=0; idx<fimDafila; idx++)
            arranjo[idx]=arranjo[idx+1];
        fimDafila--;
        return elementoASerRetornado;
    }

    //retorna, mas não remove, o primeiro elemento da fila, e dá erro se a fila estiver vazia
    public int head(){
        if(fimDafila==0)
            throw new RuntimeException("A fila está vazia");
        
        return arranjo[0];
    }
    
    //retorna o número de elementos da fila
    public int size(){
        return fimDafila;
    }
    
    //retorna true se a fila estiver vazia, e false caso contrário
    public boolean isEmpty(){
        return (fimDafila==0);
    }

    //esvazia a fila
    public void clear(){
        fimDafila=0;
    }

    public String toString(){   //complexidade n
        if(fimDafila==0)
        return "A fila está vazia";

        StringBuilder sb = new StringBuilder();
        sb.append("<-:0:[");
        for(int idx=0; idx<fimDafila-1; idx++) 
           sb.append(arranjo[idx]+",");
        sb.append(arranjo[fimDafila-1]);
        sb.append("]<-:"+(fimDafila-1)+":"+(arranjo.length-1));

        return sb.toString();
    }
}