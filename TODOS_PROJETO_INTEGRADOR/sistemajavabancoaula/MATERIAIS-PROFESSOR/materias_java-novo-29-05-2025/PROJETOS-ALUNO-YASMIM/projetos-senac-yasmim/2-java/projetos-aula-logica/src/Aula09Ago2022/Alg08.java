package Aula09Ago2022;

import java.util.Scanner;

public class Alg08 {
    public static void main(String[] args) {
        // Leia a idade de 20 pessoas e exiba quantas pessoas são maiores de idade.

        Scanner tecla = new Scanner(System.in);
        int i, idade, maior = 0;

        for (i = 1; i <= 20; i++) {
            System.out.println("Insira a idade da " + i + "ª pessoa");
            idade = tecla.nextInt();

            if (idade >= 18) {
                maior = maior + 1;
            }
        }

        System.out.println("O número de pessoas maiores de 18 anos é: " + maior);

    }
}
