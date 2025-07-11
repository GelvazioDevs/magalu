package Aula16Ago2022;

import java.util.Scanner;

public class Aula_Ex_03 {
    public static void main(String[] args) {
        // Amplie o exercício anterior emitindo um relatório com todos os números pares que você leu.

        Scanner sc = new Scanner(System.in);
        int num[] = new int[10];
        int i;

        for (i = 0; i < num.length; i++) {
            System.out.println("Digite um número:");
            num[i] = sc.nextInt();
        }

        System.out.println("Os números pares digitados foram:");
        for (int w : num) {
            if (w%2 ==0) {
            System.out.println(w);
            }
        }

    }
}
