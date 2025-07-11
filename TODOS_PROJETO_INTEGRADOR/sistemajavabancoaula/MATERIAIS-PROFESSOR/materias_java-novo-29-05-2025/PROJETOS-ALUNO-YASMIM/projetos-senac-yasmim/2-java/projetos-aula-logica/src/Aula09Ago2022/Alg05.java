package Aula09Ago2022;

import java.util.Scanner;

public class Alg05 {
    public static void main(String[] args) {
        // Escreva um algoritmo que leia 10 números do usuário e calcule a soma desses números.
        Scanner tecla = new Scanner(System.in);
        int n, soma = 0, i;

        for (i = 1; i <= 10; i++) {
            System.out.println("Digite um número: ");
            n = tecla.nextInt();

            soma = soma + n;
        }
        System.out.println("A soma dos números digitados é " + soma);

    }
}
