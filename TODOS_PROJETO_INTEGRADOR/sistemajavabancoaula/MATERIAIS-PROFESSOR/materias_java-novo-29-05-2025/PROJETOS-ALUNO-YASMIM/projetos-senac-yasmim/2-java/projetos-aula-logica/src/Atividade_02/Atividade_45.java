package Atividade_02;

import java.util.Scanner;

public class Atividade_45 {
    public static void main(String[] args) {
        // FEITO POR YASMIM
        // Crie um algoritmo que leia um número inteiro do usuário e informe se esse número é ou não é múltiplo de 5.

        Scanner teclado = new Scanner(System.in);
        int n;

        System.out.println("Digite um número inteiro:");
        n = teclado.nextInt();

        if (n % 5 == 0) {
            System.out.println("O número " + n + " é múltiplo de 5");
        } else {
            System.out.println("O número " + n + " não é múltiplo de 5");

        }
    }
}
