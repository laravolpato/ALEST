package com.volpato;


public class ListaEstatica {

    private int [] arranjo;
    // fimDaLista tem dupla interpretação
    //   1. A primeira posição livre para inserção na lista
    //   2. O nro de elmentos salvos na minha lista
    private int fimDaLista; 

    public ListaEstatica() {
        this.arranjo = new int[10];
        this.fimDaLista=0;        
    }

    public ListaEstatica(int capacidadeInicial) {
        this.arranjo = new int[capacidadeInicial];
        this.fimDaLista=0;        
    }

    private void aumentaAEstrutura(){
        if(this.fimDaLista==this.arranjo.length){
            int [] novoArranjo = new int[arranjo.length*2];
            for(int i=0; i<arranjo.length; i++)
                novoArranjo[i]=arranjo[i];
            arranjo=novoArranjo;
        }
    }

    public boolean add(int e){
        aumentaAEstrutura();
        this.arranjo[this.fimDaLista] = e;
        this.fimDaLista++;
        return true;
    }
    public void add(int index, int element){
      ValidaPosicao(index);
      aumentaAEstrutura();

    for(int idx=fimDaLista; idx>index)
    
}
    //public boolean addAll(int[] c) 
    //public boolean addAll(int index, int[] c) 
    public void clear(){
        this.fimDaLista=0;
    }
    public boolean contains(int o){
        for(int idx=0; idx<fimDaLista; idx++)
    } 
    public int get(int index){
        validaPosicao(index);
        return arranjo[index];
    }
    //public int indexOf(int o) 
    public boolean isEmpty(){
        return this.fimDaLista==0;
    }
    //public int lastIndexOf(int o) 
    public int remove(int index){
        validaPosicao(index);

        //salva valor a ser retornado
        int aux = arranjo[index];

        // ajusta lista 
        //   remove espaços vazios
        for(int i=index; i<this.fimDaLista-1; i++)
            this.arranjo[i]=this.arranjo[i+1];
        this.fimDaLista--;

        reduzAEstrutura();

        // retorna valor salvo
        return aux;
    }

    private void reduzAEstrutura(){

        if(arranjo.length>10){
            if(fimDaLista<=(arranjo.length/4)){
                int [] novoArranjo = new int[arranjo.length/2];
                for(int i=0; i<arranjo.length; i++)
                    novoArranjo[i]=arranjo[i];
                arranjo=novoArranjo;
            }
        }
    }

    private void validaPosicao(int index){
        if((index >= fimDaLista)||(index<0))
            throw new RuntimeException("A posição index:"+index+" é inválida");
    }
    //public boolean remove(int o) 
    //public boolean removeAll(int[] c) 
    //public int set(int index, int element) 
    public int size(){
        return this.fimDaLista;
    }
    //public int[] subList(int fromIndex, int toIndex) 

    public String toString(){

        if(this.fimDaLista==0)
            return "A lista está vazia";
        
        StringBuilder sb = new StringBuilder();

        sb.append("0:[");
        for(int idx=0; idx<fimDaLista-1; idx++)
            sb.append(arranjo[idx]+",");
        sb.append(arranjo[fimDaLista-1]);
        sb.append("]:"+(fimDaLista-1)+":"+(arranjo.length-1)+"("+fimDaLista+")");

        return sb.toString();

    }

    public static void main(String[] args) {
        ListaEstatica le = new ListaEstatica();

        System.out.println(le);

        le.add(32);
        System.out.println(le);

        le.add(14);
        System.out.println(le);

        le.add(-1);
        System.out.println(le);

        le.add(98);
        System.out.println(le);

        System.out.println("O conteudo da posicao 2 é "+le.get(2));

        le.remove(1);
        System.out.println(le);

    }
}