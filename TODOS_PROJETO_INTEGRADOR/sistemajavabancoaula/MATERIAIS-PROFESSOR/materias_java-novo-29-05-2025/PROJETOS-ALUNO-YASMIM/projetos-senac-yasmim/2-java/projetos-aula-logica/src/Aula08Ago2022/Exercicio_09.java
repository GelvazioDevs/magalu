package Aula08Ago2022;

import java.util.Scanner;

public class Exercicio_09 {
    public static void main(String[] args) {
        // Crie um algoritmo que receba vários números inteiros e positivos
        //e imprima o produto dos números ímpares digitados e a soma dos pares.
        //O algoritmo encerra quando o zero ou um número negativo é digitado.

        Scanner tecla = new Scanner(System.in);
        int num, controle = 1, contador = 0;
        int somapar = 0;
        int prod = 1;

        while (controle > contador) {
            System.out.println("Digite um número:");
            num = tecla.nextInt();

            if (num%2 == 0) {
                somapar = somapar + num;
            } else {
                prod = prod * num;
            }

            if (num <= 0) {
                break;
            }
        }

        System.out.println("A soma dos números pares é igual a " + somapar);
        System.out.println("O produto dos números impares é igual a " + prod);



    }
}
