package Aula08Ago2022;

import java.util.Scanner;

public class Exercicio_08 {
    public static void main(String[] args) {
        // Escrever um algoritmo que leia um número n que indica quantos valores
        //devem ser lidos a seguir. Para cada número lido, mostre os valores lidos
        //e o fatorial destes valores.

        Scanner tecla = new Scanner(System.in);

        int n, i, fat, x, y;

        System.out.println("Quantos fatoriais você quer fazer?");
        n = tecla.nextInt();

        for (i = n; i >= 1; i--) {
            System.out.println("Qual o número que você quer fatorar?");
            x = tecla.nextInt();
            fat = 1;
                for (y = x; y >= 1; y--) {
                    fat = fat * y;
                }

            System.out.println("O fatorial de " + x + " é " + fat);


        }




    }
}
