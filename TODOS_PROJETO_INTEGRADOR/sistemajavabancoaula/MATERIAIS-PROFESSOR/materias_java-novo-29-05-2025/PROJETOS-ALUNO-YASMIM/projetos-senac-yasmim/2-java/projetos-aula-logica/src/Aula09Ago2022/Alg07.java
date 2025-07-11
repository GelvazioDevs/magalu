package Aula09Ago2022;

import java.util.Scanner;

public class Alg07 {
    public static void main(String[] args) {
        // Leia a idade de 20 pessoas e exiba a média das idades.

        Scanner tecla = new Scanner(System.in);

        int i, idade, soma = 0, media;

        for (i = 1; i <=20; i++) {
            System.out.println("Digite a idade da pessoa " + i);
            idade = tecla.nextInt();

            soma = soma + idade;
        }

        media = soma / 20;

        System.out.println("A média das idades digitadas é: " + media);

    }
}
