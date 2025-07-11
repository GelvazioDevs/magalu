package Aula01Ago2022;

import java.util.Scanner;

public class Exe_07 {
    public static void main(String[] args) {
        // Faça um algoritmo para verificar se um valor e PAR ou IMPAR;

        Scanner tecla = new Scanner(System.in);
        int num;

        System.out.println("Digite um número para descobrir se ele é par ou ímpar!");
        num = tecla.nextInt();

        if (num%2 ==0) {
            System.out.println("O número digitado é par!");
        } else {
            System.out.println("O número digitado é ímpar!");
        }


    }

}
