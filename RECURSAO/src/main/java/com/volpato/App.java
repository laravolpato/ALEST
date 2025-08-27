package com.volpato;

public class App {

    public static void main(String[] args) {
        if(args.length!=2){
            System.out.println("Informe a base e o expoente a serem usado");
            System.out.println("java Main base expoente");
            System.exit(0);
        }

        int base=Integer.parseInt(args[0]);
        int expoente=Integer.parseInt(args[1]);

        System.out.println("Valores informados");
        System.out.println("  Base    : "+ base);
        System.out.println("  Expoente: "+ expoente);
        System.out.println("Funcao nao recursiva");
        System.out.println("  Resultado       : "+Potencia.naoRecursivo(base, expoente));
        System.out.println("  Nro de operações: "+Potencia.nOperacoes);
        System.out.println("Funcao Recursiva");
        System.out.println("  Resultado       : "+Potencia.recursivo(base, expoente));
        System.out.println("  Nro de operações: "+Potencia.nOperacoes);

    }
}