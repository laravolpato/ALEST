package com.volpato;

import java.util.LinkedList;
import java.util.Random;

public class ArvoreGenerica {

    private Nodo raiz;
    private int nNodos;

    private class Nodo {            
        public int valor;
        public LinkedList<Nodo> filhos;
        public Nodo pai;

        public Nodo(int v) {
            this.valor=v;
            filhos=new LinkedList<Nodo>();
            pai=null;            
        }
    }

    public ArvoreGenerica() {        
        raiz=null;
        nNodos=0;
    }

    public Integer getRoot(){
        if(raiz!=null) return raiz.valor;
        return null;
    }

    public void setRoot(Integer e){
        if(e==null)
            throw new IllegalArgumentException("O valor passado é nulo");

        if(raiz==null){
            raiz=new Nodo(e);
            nNodos++;
        }
        else{
            raiz.valor=e;
        }
    }

    public boolean isRoot(Integer e){
        // PASSO 1 - valido o argumento passado
        //==============================
        if(e==null)
            throw new IllegalArgumentException("O valor passado é nulo");


        // PASSO 2 - avalio se a arvore está vazia
        //==============================
        // Alternativa 1 - Gera uma exceção caso a arvore esteja vazia
        if(raiz==null)
            throw new NullPointerException("A árvore está vazia");
        // Alternativa 2 - retornar falso, visto que a árvore está vazia 
        //    e não contem o valor procurado
        //  return false;

        // PASSO 3 - comparo com o valor armazenado na raiz
        return (raiz.valor==e);
    }

    public boolean isEmpty(){
        return (raiz==null);
        //return (nNodos==0);
    }
    public int size(){
        return nNodos;
    }

    public void clear(){
        raiz=null;
        nNodos=0;
    }

    public boolean add(Integer e, Integer father){

        // 1ª versão
        //   a. Inclusão de nodos filhos da raiz. Nenhuma navegação é realizada.
        //   b. O parametro father deve ser diferente de nulo

        // Passo 1 - Validar os argumentos/parametros
        if(father==null)
            throw new IllegalArgumentException("O valor do nodo pai deve ser diferente de nulo");
        if(e==null)
            throw new IllegalArgumentException("O valor a ser armazenado deve ser diferente de nulo");


        //Versão 2 deve permitir a inserção de um nodo em qq ponto da árvore
        // Passo 2 da versão 2 - Preciso encontrar o father
        Nodo pai = findNode(raiz, father);
        if(pai==null)
            throw new RuntimeException("O pai não encontrado na árvore");

        /*
        // Passo específico da versão 1
        // Passo 2 - Validar a relação com a raiz
        if(father!=raiz.valor){
            System.out.println("1ª Versao - somente inclusão de filhos do nodo raiz");
            System.out.println("  Inclusão do nodo não foi realizada");
            return false;            
        }
        */

        // Passo 3 - Adicionar o nodo
        Nodo aux = new Nodo(e);

        // Versão 1 - só adiciona na raiz
        //raiz.filhos.add(aux);
        // Versão 2 - Permite adição em qq ponto da árvore
        pai.filhos.add(aux);

        nNodos++;
        return true;
    }

    private Nodo findNode(Nodo ref, Integer value){

        if(ref.valor==value)
            return ref;
        else{
            Nodo resultado=null;
            for(Nodo filho: ref.filhos){
                resultado=findNode(filho, value);
                if(resultado!=null) return resultado;
            }
        }
        return null;

    }

    @Override
    public String toString() {
        if(raiz==null)
            return "[0] - A árvore está vazia";

        StringBuilder sb = new StringBuilder();
        // 1ª versão - imprime raiz e seus filhos
        /*
        sb.append("["+nNodos+"] - {"+raiz.valor);
        for(Nodo aux: raiz.filhos)
            sb.append(", "+aux.valor);
        sb.append("}");
        */

        // 2ª versão - imprime a árvore toda
        sb.append("["+nNodos+"] - {"+raiz.valor);
        Integer[] nodos = positionsPre();
        for(int i=1; i<nodos.length; i++)
            sb.append(", "+nodos[i]);
        sb.append("}");
        
        return sb.toString();
        
    }

    // exige caminhamento
    public Integer getParent(Integer e){
        Nodo aux = findNode(raiz, e);
        
    }    
    // exige caminhamento
    public boolean removeBranch(Integer e){
        return false;
    }
    // exige caminhamento
    public boolean contains(Integer e){
        return false;
    }
    // exige caminhamento
    public boolean isInternal(Integer e){
        return false;
    }
    // exige caminhamento
    public boolean isExternal(Integer e){
        return false;
    }

    // exige caminhamento
    public Integer[] positionsPre(){
        if(nNodos==0)
            return null;
        Integer[] lista = new Integer[nNodos];
        preordem(raiz, lista, 0);
        return lista;
    }

    private int preordem(Nodo ref, Integer[] list, int idx){
        // Implementação funcionante para raiz e seus filhos (altura 1)
        // Será que funciona para árvores com mais níveis?
        if(ref!=null){
            // ação a ser realizada
            // antes de visitar os filhos
            list[idx]=ref.valor;
            idx++;
            for(Nodo filho: ref.filhos){
                idx=preordem(filho, list, idx);
            }            
        }
        return idx;
    }

    // exige caminhamento
    public Integer[] positionsPos(){
        if(nNodos==0)
            return null;
        Integer[] lista = new Integer[nNodos];
        posordem(raiz, lista, 0);
        return lista;
    }

    private int posordem(Nodo ref, Integer[] list, int idx){
        // Implementação funcionante para raiz e seus filhos (altura 1)
        // Será que funciona para árvores com mais níveis?
        if(ref!=null){
            for(Nodo filho: ref.filhos){
                idx=preordem(filho, list, idx);
            }            
            // ação a ser realizada
            // depois de visitar os filhos
            list[idx]=ref.valor;
            idx++;

        }
        return idx;
    }

    
    // exige caminhamento
    public Integer[] positionsWidth(){
        if(nNodos==0) return null;

        Integer [] resultado = new Integer[nNodos];
        int idx=0;

        LinkedList<Nodo> fila = new LinkedList<>();
        //1º passo - incluir a raiz na fila
        fila.add(raiz);

        do{
            //2º passo - consumi o elemento da fila
            Nodo elemento = fila.remove(0);


            //3º passo - inclui o resultado na lista a ser retornada
            resultado[idx]=elemento.valor;
            idx++;

            //4º passo - incluir os filhos do elemento na fila
            for(Nodo filho: elemento.filhos)
            fila.add(filho);

        //5º passo - refaça desde o passo 2 se ainda tem elementos na fila
        }while(fila.size()>0);

        return resultado;
    }

    public static void main(String[] args) {
        ArvoreGenerica ag = new ArvoreGenerica();
        ag.setRoot(7);
        System.out.println(ag+"\n");        

        ag.add(5,7);
        System.out.println(ag+"\n");        

        ag.add(10,5);
        System.out.println(ag+"\n");        

        ag.add(15,10);
        System.out.println(ag+"\n");        

        ag.add(8,10);
        System.out.println(ag+"\n");        

        ag.add(3,7);
        System.out.println(ag+"\n");        

        ag.add(9,3);
        System.out.println(ag+"\n");        

        ag.add(2,7);
        System.out.println(ag+"\n");
        /*
        Random rnd = new Random();
        int raiz = rnd.nextInt(100);

        System.out.println(ag);

        ag.setRoot(raiz);
        System.out.println(ag);

        for(int i=0; i< 10; i++){
            ag.add(rnd.nextInt(100), raiz);            
            System.out.println(ag);
        }
        */
    }

}