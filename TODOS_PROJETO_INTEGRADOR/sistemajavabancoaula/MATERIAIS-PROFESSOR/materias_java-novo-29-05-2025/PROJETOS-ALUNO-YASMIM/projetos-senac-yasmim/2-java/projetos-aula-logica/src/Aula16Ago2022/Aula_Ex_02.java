package Aula16Ago2022;

import java.util.Scanner;

public class Aula_Ex_02 {
    public static void main(String[] args) {
        // faça um algoritmo que leia, via teclado, 10 valores do tipo inteiro e os guarde na memória.
        //Após a leitura liste os numeros armazenados.

        Scanner sc = new Scanner(System.in);
        int num[] = new int[10];
        int i;

        for (i = 0; i < num.length; i++) {
            System.out.println("Digite um número:");
            num[i] = sc.nextInt();
        }

        System.out.println("Os números digitados foram:");
        for (int w : num) {
            System.out.println(w);
        }



    }
}
