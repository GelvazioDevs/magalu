package Aula08Ago2022;

import java.util.Scanner;

public class Exercicio_10 {
    public static void main(String[] args) {
        // Escreva um algoritmo que mostre o menor e o maior
        //dos números digitados pelo usuário.
        //Termine a leitura se o usuário digitar zero.

        Scanner tecla = new Scanner(System.in);
        int num, maior = 0, menor=1000000;
        int controle = 1;
        int contador = 0;

        while (controle > contador) {
            System.out.println("Digite um número:");
            num = tecla.nextInt();
            if (num == 0) {
                break;
            }
            if (num>maior) {
                maior = num;
            } if ((num <= menor) && (menor>0)) {
                menor = num;
            }

        }

        System.out.println("O maior número digitado é " + maior);
        System.out.println("O menor número digitado é " + menor);


    }
}
