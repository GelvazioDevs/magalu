package Aula01Ago2022;

import java.util.Scanner;

public class Exe_05 {

    public static void main(String[] args) {
        // Faça um algoritmo para verificar se uma pessoa ja pode tirar carteira de motorista considerando a
        // idade >= 18 anos e mostre na tela uma mensagem:
        // JA POSSO TIRAR A CARTEIRA DE MOTORISTA, se for o caso
        // AINDA NÃO POSSO TIRAR A CARTEIRA DE MOTORISTA, se for o caso

        Scanner tecla = new Scanner(System.in);
        int idade;


        System.out.println("Quantos anos você tem?");
        idade = tecla.nextInt();

        if (idade >= 18) {
            System.out.println("JÁ POSSO TIRAR A CARTEIRA DE MOTORISTA!");
        } else {
            System.out.println("AINDA NÃO POSSO TIRAR A CARTEIRA DE MOTORISTA");
        }
    }
}
