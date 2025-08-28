package com.volpato;

// Implementação de um pilha para armazenamento de inteiros

public class Pilha{

    private int [] arranjo;
    private int topo;

    public Pilha(){
        this.arranjo = new int[10];
        this.topo=0;
    }

    public Pilha(int capacidade){
        this.arranjo = new int[capacidade];
        this.topo=0;
    }

    //insere o elemento e no topo da pilha
    public boolean push(int e){
        if(topo>=arranjo.length)
            return false;

        arranjo[topo]=e;
        topo++;
        return true;
    }
    //remove e retorna o elemento do topo da pilha 
    //  (erro se a pilha estiver vazia) //complexidade: constante
    public int pop(){ 
        if(topo>0){
            topo--;
            return arranjo[topo];
        }
        throw new RuntimeException("Stack underflow. A Pilha está vazia");
    }

    //retorna, mas não remove, o elemento do topo da pilha 
    // (erro se a pilha estiver vazia) //complexidade: constante
    public int top(){    
        //se a pilha estiver vazia
        if(topo == 0) {
            throw new RuntimeException("A pilha está vazia"); 
        }
            return arranjo[topo-1]; //topo-1 porque o vetor tem 6 posições mas começa em 0
    }

    //retorna o número de elementos da pilha //complexidade: constante
    public int size(){        
        return topo;
    }

    //retorna true se a pilha estiver vazia, e false caso contrário //complexidade: constante
    public boolean isEmpty(){        
        return (topo==0);
    }

    //esvazia a pilha //complexidade: constante
    public void clear(){    
        topo=0;    
    }

    public String toString(){ //append adiciona no final //complexidade: linear
        StringBuilder sb = new StringBuilder();
        sb.append("0->[");
        for(int i=0; i<topo; i++){
            sb.append(arranjo[i]);
            if(i!=topo-1)
                sb.append(",");
        }
        sb.append("]<-"+topo+"..."+arranjo.length);
        sb.append("\n");
        return sb.toString();
    }
}