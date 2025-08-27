package com.volpato;

public class Potencia {

    public static int nOperacoes;

    public static int naoRecursivo(int base, int expoente){
        nOperacoes=1;
        int resultado=1;
        for(int i=0; i<expoente; i++){
          resultado*=base;
          nOperacoes++;
        }
        return resultado;
    }
    
    public static int recursivo(int base, int expoente){
        nOperacoes=0;
        int resultado=funcaoRecursivaPrivada(base, expoente);
        return resultado;
    }

    private static int funcaoRecursivaPrivada(int base, int expoente){
        nOperacoes++;
        if(expoente==0)
            return 1;
        else    
            return base*funcaoRecursivaPrivada(base, expoente-1);
    }
    
}