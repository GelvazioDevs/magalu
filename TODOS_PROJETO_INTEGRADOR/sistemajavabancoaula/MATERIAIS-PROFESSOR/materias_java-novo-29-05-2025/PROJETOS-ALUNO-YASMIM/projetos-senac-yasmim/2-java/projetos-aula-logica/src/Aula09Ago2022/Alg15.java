package Aula09Ago2022;

import java.util.Scanner;

public class Alg15 {
    public static void main(String[] args) {
        // Escreva um algoritmo que leia uma sequência de números do usuário e realize a soma desses números.
        //Encerre a execução quando um número negativo for digitado.

        Scanner sc = new Scanner(System.in);
        int controle = 0, control = 1, n, soma = 0;

        while (controle < control) {
            System.out.println("Digite um número:");
            n = sc.nextInt();

            if (n < 0) {
                break;
            } else {
                soma = soma + n;
            }

        }

        System.out.println("A soma dos números digitados é: " + soma);
    }
}
