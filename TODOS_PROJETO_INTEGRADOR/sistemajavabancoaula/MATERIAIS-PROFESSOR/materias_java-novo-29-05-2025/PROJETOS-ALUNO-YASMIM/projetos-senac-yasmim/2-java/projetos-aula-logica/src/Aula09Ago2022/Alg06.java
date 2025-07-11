package Aula09Ago2022;

import java.util.Scanner;

public class Alg06 {
    public static void main(String[] args) {
        // Leia a idade de 20 pessoas e exiba a soma das idades.
        Scanner tecla = new Scanner(System.in);
        int i, id, soma = 0;

        for (i = 1; i <= 20; i++) {
            System.out.println("Insira a idade " + i);
            id = tecla.nextInt();

            soma = soma + id;
        }

        System.out.println("A soma das idades digitadas é: " + soma);
    }
}
