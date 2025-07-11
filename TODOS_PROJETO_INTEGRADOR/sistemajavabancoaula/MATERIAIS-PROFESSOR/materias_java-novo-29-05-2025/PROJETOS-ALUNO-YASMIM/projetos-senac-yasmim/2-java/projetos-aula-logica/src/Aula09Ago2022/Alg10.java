package Aula09Ago2022;

import java.util.Scanner;

public class Alg10 {
    public static void main(String[] args) {
        // Crie um algoritmo leia um número do usuário e exiba a sua tabuada de multiplicação.
        Scanner tecla = new Scanner(System.in);
        int i, n, m;
        System.out.println("Digite um número:");
        n = tecla.nextInt();

        for (i = 1; i <= 10; i++) {
            m = n * i;
            System.out.println(n + " x " + i + " = " + m );
        }


    }
}
