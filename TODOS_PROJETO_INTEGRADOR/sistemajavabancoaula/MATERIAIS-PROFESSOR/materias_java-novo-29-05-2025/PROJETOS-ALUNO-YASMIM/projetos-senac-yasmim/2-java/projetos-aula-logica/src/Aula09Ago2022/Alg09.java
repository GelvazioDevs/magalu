package Aula09Ago2022;

import java.util.Scanner;

public class Alg09 {
    public static void main(String[] args) {
        // Leia o nome e a idade de 10 pessoas e exiba o nome da pessoa mais nova.

        Scanner tecla = new Scanner(System.in);
        int i, n, menor = 0;
        String nome, nova = null;

        for (i = 1; i <= 10; i++) {
            System.out.println("Insira o nome da " + i + "ª pessoa.");
            nome = tecla.nextLine();
            System.out.println("Qual a idade de " + nome + "?");
            n = tecla.nextInt();
            tecla.nextLine();

            if (menor == 0) {
                menor = n;
                }

            if (n < menor) {
                nova = nome;
                menor = n;
            }

        }

        System.out.println(nova + " é a pessoa mais nova com " + menor + " anos.");
    }
}
