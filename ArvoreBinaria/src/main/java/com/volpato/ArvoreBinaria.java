package com.volpato;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArvoreBinaria {

    private Nodo raiz;
    private int nNodos;

    private enum profundidade {Pos, Pre, Central};

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
        // o pai não foi informado
        if(father==null)
            return false;
        Nodo pai = findNode(raiz, father);
        
        // significa que o pai informado não existe na árvore
        if(pai==null) 
            return false;

        // o filho a esquerda já existe
        if(pai.filhosDaEsquerda!=null) 
            return false;

        // nodo pode ser inserido com sucesso
        Nodo aux = new Nodo(e);
        pai.filhosDaEsquerda=aux;
        aux.pai=pai;
        nNodos++;

        return true;
    }

    private Nodo findNode(Nodo ref, int elemento){
        // Vou empregar o caminhamento em pre ordem

        //1o passo - garanto que o nodo não é nulo
        if(ref!=null){

        //2o passo - visito o nodo (comparo o valor dele com o valor buscado)
            if(ref.valor==elemento) return ref;

        //3o passo - visito o filho da esquerda
            Nodo filho=null;
            filho = findNode(ref.filhosDaEsquerda, elemento);
            if(filho!=null) return filho;
        
        //4o passo - visito o filho da direita
            filho = findNode(ref.filhosDaDireita, elemento);
            if(filho!=null) return filho;
        }
        return null;
    }
    
    public boolean addRight(Integer e, Integer father){
        // o pai não foi informado
        if(father==null)
            return false;
        Nodo pai = findNode(raiz, father);
        
        // significa que o pai informado não existe na árvore
        if(pai==null) 
            return false;

        // o filho a direita já existe
        if(pai.filhosDaDireita!=null) 
            return false;

        // nodo pode ser inserido com sucesso
        Nodo aux = new Nodo(e);
        pai.filhosDaDireita=aux;
        aux.pai=pai;
        nNodos++;

        return true;
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

        //preordem(raiz, resultado, 0);
        caminhamentoEmProfundidade(raiz, resultado, 0, profundidade.Pre);

        return resultado;
    }

    private int preordem(Nodo ref, Integer[] lst, int idx){

        if(ref!=null){
            // visito o nodo atual
            lst[idx]=ref.valor;
            idx++;
            // visito o filho a esquerda
            idx=preordem(ref.filhosDaEsquerda, lst, idx);
            // visito o filho a direita
            idx=preordem(ref.filhosDaDireita, lst, idx);
        }

        return idx;

    }
    
    public Integer[] positionsCentral(){
        if(nNodos==0) return null;

        Integer[] resultado = new Integer[nNodos];

        //central(raiz, resultado, 0);
        caminhamentoEmProfundidade(raiz, resultado, 0, profundidade.Central);

        return resultado;
    }

    private int central(Nodo ref, Integer[] lst, int idx){

        if(ref!=null){
            // visito o filho a esquerda
            idx=preordem(ref.filhosDaEsquerda, lst, idx);
            // visito o nodo atual
            lst[idx]=ref.valor;
            idx++;
            // visito o filho a direita
            idx=preordem(ref.filhosDaDireita, lst, idx);
        }

        return idx;

    }

    public Integer[] positionsPos(){
        if(nNodos==0) return null;

        Integer[] resultado = new Integer[nNodos];

        //posordem(raiz, resultado, 0);
        caminhamentoEmProfundidade(raiz, resultado, 0, profundidade.Pos);

        return resultado;
    }
 
    private int posordem(Nodo ref, Integer[] lst, int idx){

        if(ref!=null){
            // visito o filho a esquerda
            idx=preordem(ref.filhosDaEsquerda, lst, idx);
            // visito o filho a direita
            idx=preordem(ref.filhosDaDireita, lst, idx);
            // visito o nodo atual
            lst[idx]=ref.valor;
            idx++;
        }
        return idx;

    }
    private int caminhamentoEmProfundidade(Nodo ref, Integer[] lst, int idx, profundidade tipo){

        if(ref!=null){

            if(tipo==profundidade.Pre){
                // visito o nodo atual
                lst[idx]=ref.valor;
                idx++;
            }

            // visito o filho a esquerda
            idx=caminhamentoEmProfundidade(ref.filhosDaEsquerda, lst, idx, tipo);

            if(tipo==profundidade.Central){
                // visito o nodo atual
                lst[idx]=ref.valor;
                idx++;
            }

            // visito o filho a direita
            idx=caminhamentoEmProfundidade(ref.filhosDaDireita, lst, idx, tipo);

            if(tipo==profundidade.Pos){
                // visito o nodo atual
                lst[idx]=ref.valor;
                idx++;
            }
        }
        return idx;

    }
    
    public Integer[] positionsWidth(){
        if(nNodos==0) return null;
        Integer[] resultado;
        LinkedList<Nodo>    fila;
        resultado = new Integer[nNodos];
        int idx=0;

        fila = new LinkedList<Nodo>();
        fila.add(raiz);

        do{
            Nodo aux = fila.remove();

            if(aux.filhosDaEsquerda!=null) fila.add(aux.filhosDaEsquerda);
            if(aux.filhosDaDireita!=null)  fila.add(aux.filhosDaDireita);

            resultado[idx]=aux.valor;
            idx++;

        }while(! fila.isEmpty());

        return resultado;

    }

    public static void main(String[] args) {
        ArvoreBinaria ab = new ArvoreBinaria();

        ab.addRoot(1);

        ab.addLeft(2, 1);
        ab.addRight(3, 1);

        ab.addLeft(4,2);

        ab.addLeft(5, 3);

        ab.addRight(6, 3);

        ab.addRight(7,6);

        System.out.print("Pre ordem: ");
        printArray( ab.positionsPre());
        System.out.print("Pos ordem: ");
        printArray( ab.positionsPos());
        System.out.print("Central  : ");
        printArray( ab.positionsCentral());
        System.out.print("Largura  : ");
        printArray( ab.positionsWidth());
    }

    private static void printArray(Integer[] array){
        if(array==null) System.out.println("array vazio");
        else{
            System.out.print("[");
            for(int i=0; i<array.length-1; i++)
                System.out.print(array[i]+", ");
            System.out.println(array[array.length-1]+"]");
        }
    }
    
}