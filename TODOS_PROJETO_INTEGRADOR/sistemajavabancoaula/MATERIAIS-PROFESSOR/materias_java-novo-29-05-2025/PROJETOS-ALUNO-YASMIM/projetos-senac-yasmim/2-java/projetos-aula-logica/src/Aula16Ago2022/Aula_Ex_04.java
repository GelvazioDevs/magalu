package Aula16Ago2022;

import java.util.Scanner;

public class Aula_Ex_04 {
    public static void main(String[] args) {
        // Faça um algoritmo que determine qual o menor valor existente no vetor do Exercício 02.

        Scanner sc = new Scanner(System.in);
        int num[] = new int[10];
        int i, menor = 0;

        for (i = 0; i < num.length; i++) {
            System.out.println("Digite um número:");
            num[i] = sc.nextInt();

            if (menor ==0) {
                menor = num[i];
            }
            if (num[i] < menor) {
                menor = num[i];
            }

        }
        System.out.println("O menor numero digitado foi " + menor);


    }
}
