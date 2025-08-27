package com.volpato;

public class Ordena {

    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("Informe uma sequencia de inteiros a serem acumulados");
            System.out.println("  Os valores devem estar separados por espaço");
            System.out.println("  java Ordena 1 3 15 27 4 9");
            System.exit(0);
        }
        
        int [] valores = new int [args.length];
        for(int i=0; i<args.length; i++)
            valores[i]=Integer.parseInt(args[i]);
        
        System.out.println("Iniciando a operacao");
        System.out.print("  Conteúdo do vetor: [");
        for(int i: valores)
            System.out.print(i+", ");
        System.out.println("]");

        QuickSort.run(valores);

        System.out.print("  Conteúdo do vetor apos a ordenacao: [");
        for(int i: valores)
            System.out.print(i+", ");
        System.out.println("]");



    }
    
}