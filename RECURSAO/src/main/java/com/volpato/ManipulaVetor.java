package com.volpato;

public class ManipulaVetor {

    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("Informe uma sequencia de inteiros a serem acumulados");
            System.out.println("  Os valores devem estar separados por espaço");
            System.out.println("  java ManipulaVetor 1 3 15 27 4 9");
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
        int resultado=ManipulaVetor.acumulaValores_v1(valores, valores.length-1);
        System.out.println("  Resultado da soma: "+resultado);
    }

    public static int acumulaValores_v0(int [] vetor, int posicao){
        if(posicao==vetor.length)
            return 0;
        else
            return vetor[posicao]+acumulaValores_v0(vetor, posicao+1);

    }

    public static int acumulaValores_v1(int [] vetor, int posicao){
        if(posicao==0)
            return vetor[0];
        else
            return vetor[posicao]+acumulaValores_v0(vetor, posicao-1);

    }

    
}