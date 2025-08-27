package com.volpato;

public class App {

    public static void main(String[] args) {
        Pilha p = new Pilha(4);

        p.push(7);
        System.out.println(p);

        p.push(3);
        System.out.println(p);
        
        p.push(1);
        System.out.println(p);
        
        p.push(0);
        System.out.println(p);
        
        p.push(37);
        System.out.println(p);

        System.out.println("Removendo da pilha: "+p.pop());
        System.out.println(p);
        
        System.out.println("Removendo da pilha: "+p.pop());
        System.out.println(p);
        
        System.out.println("Removendo da pilha: "+p.pop());
        System.out.println(p);
        
        System.out.println("Removendo da pilha: "+p.pop());
        System.out.println(p);
        
        System.out.println("Removendo da pilha: "+p.pop());
        System.out.println(p);
        
        System.out.println("Removendo da pilha: "+p.pop());
        System.out.println(p);
        
        System.out.println("Removendo da pilha: "+p.pop());
        System.out.println(p);
        
    }
}