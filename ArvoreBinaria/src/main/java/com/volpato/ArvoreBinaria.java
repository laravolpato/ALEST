package com.volpato;

import java.util.LinkedList;
import java.util.List;

public class ArvoreBinaria {

    private Nodo raiz;
    private int nNodos;

    private class Nodo {
        public Nodo pai;
        public int valor;
        public Nodo filhosDaEsquerda;
        public Nodo filhosDaDireita;

        public Nodo(int v) {
            pai=filhosDaEsquerda=filhosDaDireita=null;            
            this.valor=v;
        }
    }

    public ArvoreBinaria() {
        raiz=null;
        nNodos=0;
    }

    public boolean addRoot(Integer e){
        if(raiz!=null)
            return false;
        
        raiz=new Nodo(e);
        nNodos++;
        return true;
    }
    
    public boolean addLeft(Integer e, Integer father){
        return false;
    }
    
    public boolean addRight(Integer e, Integer father){
        return false;
    }

    public boolean hasRight(Integer element){
        return false;
    }
    
    public boolean hasLeft(Integer element){
        return false;
    }
    
    public Integer getParent(Integer e){
        return 0;
    }
    
    public boolean isInternal(Integer e){
        return false;
    }

    public boolean isExternal(Integer e){
        return false;
    }
    
    public boolean removeBranch(Integer e){
        return false;
    }
    
    public boolean contains(Integer e){
        return false;
    }
    
    public boolean isEmpty(){
        return (raiz==null);
        //return (nNodos==0);
    }
    
    public void clear(){
        raiz=null;
        nNodos=0;
    }
    
    public int size(){
        return nNodos;
    }
    
    public Integer getRoot(){
        if(raiz!=null) return raiz.valor;
        else return null;
    }
    
    public void setRoot(Integer e){
        if(raiz!=null)
          raiz.valor=e;
    }
    
    public Integer getLeft(Integer e){
        return 0;
    }

    public Integer getRight(Integer e){
        return 0;
    }
    
    public Integer[] positionsPre(){
        if(nNodos==0) return null;

        Integer[] resultado = new Integer[nNodos];

        preordem(raiz, resultado, 0);

        return resultado;
    }

    private int preordem(Nodo ref, Integer[] lst, int idx){

        if(ref!=null){
            lst[idx]=ref.valor;
            idx++;

            idx=preordem(ref.filhosDaEsquerda, lst, idx);
            idx=preordem(ref.filhosDaDireita, lst, idx);
        }

        return idx;

    }
    
    public Integer[] positionsCentral(){
        return null;
    }
    
    public Integer[] positionsPos(){
        return null;
    }
    
    public Integer[] positionsWidth(){
         if(nNodos==0) return null;

        ArrayList<Integer> resultado;
        LinkedList<Nodo>    fila;
        resultado = new ArrayList<Integer> (nNodos);
        int idx = 0;

        fila = new LinkedList<Nodo> (nNodos);

        return null;
    }
    
}