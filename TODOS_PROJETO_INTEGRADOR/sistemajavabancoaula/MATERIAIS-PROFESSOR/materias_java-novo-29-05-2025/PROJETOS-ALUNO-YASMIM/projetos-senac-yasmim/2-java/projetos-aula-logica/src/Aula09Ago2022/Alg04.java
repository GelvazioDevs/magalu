package Aula09Ago2022;

import java.util.Scanner;

public class Alg04 {
    public static void main(String[] args) {
        // Leia o nome um número do usuário um número N e escreva o nome dele na tela N vezes.

        Scanner tecla = new Scanner(System.in);
        int i, n;
        String nome;

        System.out.println("Insira o seu nome");
        nome = tecla.next();
        System.out.println("Quantas vozes você quer escrever o seu nome?");
        n = tecla.nextInt();

        for (i = n; i > 0; i--) {
            System.out.println(nome);
        }

    }
}
