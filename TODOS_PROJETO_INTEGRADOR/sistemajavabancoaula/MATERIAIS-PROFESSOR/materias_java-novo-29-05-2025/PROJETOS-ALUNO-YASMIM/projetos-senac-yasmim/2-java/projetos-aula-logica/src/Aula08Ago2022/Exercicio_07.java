package Aula08Ago2022;

import java.util.Scanner;

public class Exercicio_07 {
    public static void main(String[] args) {
        // Crie um algoritmo que leia um número e calcule seu fatorial.Ex: 5! = 5 * 4 * 3 * 2 * 1 =120.
        Scanner leia = new Scanner(System.in);

        int n, i, x;

        System.out.println("Digite o número que deseja descobrir o fatorial:");
        n = leia.nextInt();

        x = 1;

//        for (i = (n-1); i >=1; i--) {
//            x = x * i;
//
//        }
        for (i = n; i >=1; i--) {
            x = x * i;

        }


        System.out.println("O fatorial de " + n + " é: " + x);

    }
}
