package Atividade_01;

import java.util.Scanner;

public class Exercício_53 {
    public static void main(String[] args) {
        // Crie um algoritmo para o usuário tentar adivinhar qual é o seu nome. Ele terá até 10 chances para acertar.

        Scanner teclado = new Scanner(System.in);
        int i, cont;
        String nome;
        cont = 10;

        for (i = 1; i <= 10; i++) {
            System.out.println("Tente acertar meu nome!");
            nome = teclado.nextLine();

            if (nome.equalsIgnoreCase("Yasmim")) {
                System.out.println("Parabéns! Você acertou.");
                break;
            } else {
                System.out.println("Tente novamente");
                System.out.println("Você tem " + --cont + " tentativas restantes.");
            }

        }
    }
}
