package Aula09Ago2022;

import java.util.Scanner;

public class Alg03 {
    public static void main(String[] args) {
        // Leia o nome do usuário e escreva o nome dele na tela 10 vezes.
        Scanner tecla = new Scanner(System.in);
        String nome;

        System.out.println("Insira o seu nome:");
        nome = tecla.next();

        for (int i = 1; i <=10; i++) {
            System.out.println(nome);
        }
    }
}
