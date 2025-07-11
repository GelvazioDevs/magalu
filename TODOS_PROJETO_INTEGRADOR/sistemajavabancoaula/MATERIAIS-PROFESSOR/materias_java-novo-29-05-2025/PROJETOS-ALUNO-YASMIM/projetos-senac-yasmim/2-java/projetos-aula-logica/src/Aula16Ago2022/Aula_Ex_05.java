package Aula16Ago2022;

import java.util.Scanner;

public class Aula_Ex_05 {
    public static void main(String[] args) {
        // Faça um algoritmo que determine qual o maior valor existente no vetor do Exercício 02.

        Scanner sc = new Scanner(System.in);
        int num[] = new int[10];
        int i, maior = 0;

        for (i = 0; i < num.length; i++) {
            System.out.println("Digite um número:");
            num[i] = sc.nextInt();

           if (num[i] > maior) {
                maior = num[i];
            }

        }
        System.out.println("O maior numero digitado foi " + maior);

    }
}
