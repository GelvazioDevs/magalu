package Atividade_01;

import java.util.Scanner;

public class Exercício_47 {
    public static void main(String[] args) {

        // Crie um algoritmo que peça ao usuário para adivinhar a última letra do seu nome.
        // Caso ele digite a letra correta, escreva a mensagem: “Você acertou! Meu nome termina comessa letra”.
        // Caso contrário, escreva a mensagem “Você errou”.

        Scanner teclado = new Scanner(System.in);

        String a;

        System.out.println("Chute a ultima letra do nome do usuario:");
        a = teclado.next();

        if (a.equals ("s") ) {

            System.out.println("Você acertou! Meu nome termina com essa letra!!");

        } else{

            System.out.println("Voce errou!!");
        }


    }
}
