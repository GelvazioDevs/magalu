package Aula09Ago2022;

import java.util.Scanner;

public class Alg11 {
    public static void main(String[] args) {
        //Escreva um algoritmo que leia 20 números do usuário e exiba quantos números são maiores do que 8

        Scanner sc = new Scanner(System.in);
        int i, num, mai=0;

        for (i = 1; i <=20; i++) {
            System.out.println("Digite um número");
            num = sc.nextInt();

            if (num > 8) {
                mai++;
            }
        }
        System.out.println("A quantidade de números maiores que 8 digitados é: " + mai);

    }
}
