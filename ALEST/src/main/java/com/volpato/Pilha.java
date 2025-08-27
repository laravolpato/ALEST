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
    //  (erro se a pilha estiver vazia)
    public int pop(){
        if(topo>0){
            topo--;
            return arranjo[topo];
        }
        throw new RuntimeException("Stack underflow. A Pilha está vazia");
    }

    //retorna, mas não remove, o elemento do topo da pilha 
    // (erro se a pilha estiver vazia)
    public int top(){        
        return 0;
    }

    //retorna o número de elementos da pilha
    public int size(){        
        return 0;
    }

    //retorna true se a pilha estiver vazia, e false caso contrário
    public boolean isEmpty(){        
        return false;
    }

    //esvazia a pilha
    public void clear(){        
    }

    public String toString(){
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