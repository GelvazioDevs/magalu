package Aula09Ago2022;

import java.util.Scanner;

public class Alg13 {
    public static void main(String[] args) {
        // Faça um algoritmo que leia 20 números e, ao final, escreva quantos estão entre 0 e 100.


        Scanner sc = new Scanner(System.in);
        int i, n, entre = 0;

        for (i = 1; i <= 20; i++) {
            System.out.println("Digite o " + i + "º número:");
            n = sc.nextInt();

            if ((n < 100) && (n > 0)) {
                entre++;
            }
        }
        System.out.println("A quantidade de números que estão entre 0 e 100 é " + entre);

    }
}
