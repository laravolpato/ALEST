package com.volpato;

public class Fila {
    
    private int[] arranjo;
    private int fimDaFila;
    private int capacidade;

    public Fila(){
        arranjo = new int[10];
        fimDaFila = 0;
    }

    public Fila (int capacidade){
        arranjo = new int[capacidade];
        fimDaFila = 0;
    }

    //insere o elemento e no final da fila
    public boolean enqueue(int e) {
        if(fimDaFila>=arranjo.length){
            return false;
        }
        arranjo[fimDaFila]=e;
        fimDaFila++;
        return true;
    }

    //remove e retorna o elemento e do início da fila
    public int dequeue(){
        if(fimDaFila==0){
        throw new RuntimeException( "A fila está vazia.");
        }
        int elementoASerRetornado=arranjo[0];
        //processo de passinho a frente
        for(int idx=0; idx<fimDaFila; idx++){
          arranjo[idx]=arranjo[idx+1];
        }
          fimDaFila--;
          return elementoASerRetornado;

    }
}
