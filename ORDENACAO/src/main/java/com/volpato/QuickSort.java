package com.volpato;

public class QuickSort {

    public static void run(int [] vetor){

        quickSort(vetor, 0, vetor.length-1);

    }

    private static void quickSort(int [] vet, int inicio, int fim){

        if(inicio<fim){
            int pivo = partialSort(vet, inicio, fim);
            quickSort(vet, inicio, pivo-1);
            quickSort(vet, pivo+1, fim);
        }
    }

    private static int partialSort(int vet [], int inicio, int fim){
        int pivo = vet[inicio];
        int vaga=inicio+1;
        int investiga=inicio+1;

        for(int idx=investiga; idx<=fim; idx++){
            if(vet[investiga]<pivo){
                int aux=vet[vaga];
                vet[vaga]=vet[investiga];
                vet[investiga]=aux;
                vaga++;
            }
        }
        vet[0]=vet[vaga-1];
        vet[vaga-1]=pivo;

        return vaga-1; // posicao onde o pivo ficou
    }
}