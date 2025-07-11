package Aula09Ago2022;

import java.util.Scanner;

public class Alg12 {
    public static void main(String[] args) {
        // Escreva um algoritmo que leia 20 números do usuário e exiba quantos números são pares

        Scanner sc = new Scanner(System.in);
        int n, i, par=0;

        for (i = 1; i <= 20; i++) {
            System.out.println("Digite o " + i + "º número:");
            n = sc.nextInt();

            if (n%2 == 0) {
                par++;
            }
        }
        System.out.println("A quantidade de números pares digitados é " + par);
    }
}
