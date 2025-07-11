package Aula16Ago2022;

import java.util.Scanner;

public class Aula_Ex_06 {
    public static void main(String[] args) {
        // Faça um algoritmo que leia 10 nomes e os guarde na memória. No fim, imprima os 10 nomes armazenados.

        Scanner sc = new Scanner(System.in);
        String nome[] = new String[10];
        int i;

        for (i = 0; i < nome.length; i++) {
            System.out.println("Digite um nome: ");
            nome[i] = sc.next();
        }
        System.out.println("Os nomes digitados foram: ");
        for ( String w : nome) {
            System.out.println(w);
        }


    }
}
