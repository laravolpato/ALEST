package com.volpato;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArvoreBinariaPesquisa {

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

    public ArvoreBinariaPesquisa() {
        raiz=null;
        nNodos=0;
    }

    public void add(Integer e){
        Nodo aux = new Nodo(e);
        if(nNodos==0)
            raiz=aux;
        else{
            Nodo pai = findFather(raiz, e);
            aux.pai=pai;
            // 10 >= 17 
            if(aux.valor<=pai.valor)
                pai.filhosDaEsquerda=aux;
            else
                pai.filhosDaDireita=aux;
        }
        nNodos++;
    }

    private Nodo findFather(Nodo ref, Integer e){

        if(e<=ref.valor){
            // seguir a esquerda
            if(ref.filhosDaEsquerda!=null)
                return findFather(ref.filhosDaEsquerda, e);
            else // filho da esquerda é nulo
                return ref;
        }            
        else{
            // seguir a direita
            if(ref.filhosDaDireita!=null)
                return findFather(ref.filhosDaDireita, e);
            else // filho da direita é nulo
                return ref;
        }

    }

    private Nodo findNode(Nodo ref, Integer e){
    if(ref == null) return null;
    if(ref.valor == e) return ref;
    else if(e < ref.valor)
        return findNode(ref.filhosDaEsquerda, e);
    else
        return findNode(ref.filhosDaDireita, e);
}


    public boolean isInternal(Integer e){
        Nodo n = findNode(raiz, e);
        if(n == null) return false;
        return (n.filhosDaEsquerda != null || n.filhosDaDireita != null);
    }

    public boolean isExternal(Integer e){
         Nodo n = findNode(raiz, e);
         if(n == null) return false; 
         return (n.filhosDaEsquerda == null && n.filhosDaDireita == null);
    }
    
    public boolean contains(Integer e){
        return (findNode(raiz, e) != null);

    }

    public Integer getLeft(Integer e){
        Nodo n = findNode(raiz, e);
        if(n == null || n.filhosDaEsquerda == null) return null;
        return n.filhosDaEsquerda.valor;
    }

    public Integer getRight(Integer e){
        Nodo n = findNode(raiz, e);
        if(n == null || n.filhosDaDireita == null) return null;
        return n.filhosDaDireita.valor;
    }

    public boolean hasRight(Integer element){
        Nodo n = findNode(raiz, element);
        if(n == null) return false;
        return (n.filhosDaDireita != null);
    }
    
    public boolean hasLeft(Integer element){
        Nodo n = findNode(raiz, element);
        if(n == null) return false;
        return (n.filhosDaEsquerda != null);
    }
    
    public Integer getParent(Integer e){
        Nodo n = findNode(raiz, e);
        if(n == null || n.pai == null) return null;
        return n.pai.valor;
    }    
    
    // Nao precisa ser implementado

    private Nodo findNode(Nodo ref, int e){
        if(ref!=null){
            if(ref.valor==e) return ref;

            if(e<=ref.valor) 
                return findNode(ref.filhosDaEsquerda, e);
            else
                return findNode(ref.filhosDaDireita, e);
        }
        return null;
    }

    public int level(Integer e){
        if(e==null) return -1;
        
        Nodo aux = findNode(raiz, e);
        if(aux==null) return -1;

        int nivel=0;

        while(aux.pai!=null){
            nivel++;
            aux=aux.pai;
        }

        return nivel;
    }

    private int navegaPelosNodos1(Nodo ref, int altura){ //custo nlogn

        if(ref!=null) {

            if((ref.filhosDaEsquerda==null)&&(ref.filhosDaDireita==null)){
                int nvl=0;
                Nodo aux=ref;
                while(aux.pai!=null){
                    nvl++;
                    aux=aux.pai;
                }

                if(nvl>altura) return nvl;
            }

            else{
                int nvlfilho = navegaPelosNodos1(ref.filhosDaEsquerda, altura);
                nvlfilho =  navegaPelosNodos1(ref.filhosDaDireita, nvlfilho);
                return nvlfilho;
            }
        }
        return altura;
    }

    public int height(){
        //navega em preordem
        return navegaPelosNodos1(raiz, -1);
    }

    public boolean removeBranch(Integer e){
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
    
    
    public Integer[] positionsPre(){
        if(nNodos==0) return null;

        Integer[] resultado = new Integer[nNodos];

        //preordem(raiz, resultado, 0);
        caminhamentoEmProfundidade(raiz, resultado, 0, profundidade.Pre);

        return resultado;
    }
    
    public Integer[] positionsCentral(){
        if(nNodos==0) return null;

        Integer[] resultado = new Integer[nNodos];

        //central(raiz, resultado, 0);
        caminhamentoEmProfundidade(raiz, resultado, 0, profundidade.Central);

        return resultado;
    }

    public Integer[] positionsPos(){
        if(nNodos==0) return null;

        Integer[] resultado = new Integer[nNodos];

        //posordem(raiz, resultado, 0);
        caminhamentoEmProfundidade(raiz, resultado, 0, profundidade.Pos);

        return resultado;
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

        } while(! fila.isEmpty());

        return resultado;

    }

    public static void main(String[] args) {
        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa();


        abp.add(4);
        abp.add(2);
        abp.add(1);
        abp.add(3);
        abp.add(6);
        abp.add(7);
        abp.add(5);

        System.out.print("Pre ordem: ");
        printArray( abp.positionsPre());
        System.out.print("Pos ordem: ");
        printArray( abp.positionsPos());
        System.out.print("Central  : ");
        printArray( abp.positionsCentral());
        System.out.print("Largura  : ");
        printArray( abp.positionsWidth());














    System.out.println("contains(3): " + abp.contains(3)); 
    System.out.println("contains(8): " + abp.contains(8));

    System.out.println("isInternal(4): " + abp.isInternal(4));
    System.out.println("isInternal(7): " + abp.isInternal(7));

    System.out.println("isExternal(1): " + abp.isExternal(1));
    System.out.println("isExternal(2): " + abp.isExternal(2));

    System.out.println("hasLeft(4): " + abp.hasLeft(4));
    System.out.println("hasLeft(1): " + abp.hasLeft(1));

    System.out.println("hasRight(2): " + abp.hasRight(2));
    System.out.println("hasRight(7): " + abp.hasRight(7));

    System.out.println("getLeft(4): " + abp.getLeft(4));
    System.out.println("getLeft(3): " + abp.getLeft(3));

    System.out.println("getRight(2): " + abp.getRight(2));
    System.out.println("getRight(5): " + abp.getRight(5));

    System.out.println("getParent(2): " + abp.getParent(2));
    System.out.println("getParent(4): " + abp.getParent(4));
    System.out.println("getParent(7): " + abp.getParent(7));

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