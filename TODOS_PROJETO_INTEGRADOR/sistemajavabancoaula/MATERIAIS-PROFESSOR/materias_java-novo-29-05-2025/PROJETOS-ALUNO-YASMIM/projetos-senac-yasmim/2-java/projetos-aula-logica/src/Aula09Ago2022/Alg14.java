package Aula09Ago2022;

import java.util.Scanner;

public class Alg14 {
    public static void main(String[] args) {
        // Faça um algoritmo que leia 20 números e, ao final, escreva quantos estão entre 0 e 100,
        //quantos estão entre 101 e 200 e quantos são maiores de 200.

        Scanner sc = new Scanner(System.in);
        int i, n, zero=0, cem=0, duz=0;

        for (i = 1; i <= 20; i++) {
            System.out.println("Digite o " + i + "º número:");
            n = sc.nextInt();

            if ((n >0) && (n <= 100)) {
                zero++;
            } if ((n > 100) && (n <= 200)) {
                cem++;
            } if (n > 200) {
                duz++;
            }
        }
        System.out.println("Existem " + zero + " números entre 0 e 100");
        System.out.println("Existem " + cem + " números entre 101 e 200");
        System.out.println("Existem " + duz + " números acima de 200");


    }
}
