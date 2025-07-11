package Aula01Ago2022;

import java.util.Scanner;

public class Exe_06 {

    public static void main(String[] args) {
        // Faça um algoritmo para verificar se uma pessoa ja atingiu a maioridade.
        // algoritmo deve receber como entrada apenas o ano de nascimento e
        // considerar o ano atual para calculo e 18 anos para maioridade.

        Scanner teclado = new Scanner(System.in);

        int anon, idade, anoa;

        System.out.println("Em que ano você nasceu?");
        anon = teclado.nextInt();
        anoa = 2022;
        idade = anoa - anon;

        if (idade >= 18) {
            System.out.println("Você já atingiu a maioridade!");
        } else {
            System.out.println("Você ainda não atingiu a maioridade!");
        }


    }

}
