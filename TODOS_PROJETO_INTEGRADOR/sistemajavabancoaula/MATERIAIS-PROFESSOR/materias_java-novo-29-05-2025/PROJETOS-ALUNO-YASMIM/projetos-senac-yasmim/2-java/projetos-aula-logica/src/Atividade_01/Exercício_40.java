package Atividade_01;

import java.util.Scanner;

public class Exercício_40 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        //Crie um algoritmo que leia um número inteiro do usuário
        // e verifique se o número está entre 100 e 200.
        // Se o número não estiver nesse intervalo, deve ser exibida a mensagem
        // “O número está fora do intervalo”.
        // Caso contrário mostre a mensagem “O número está dentro do intervalo”.

        int num;

        System.out.println("informe um numero:");
        num = teclado.nextInt();

        if(  (num > 100) && (num < 200) ) {

            System.out.println("o numero esta dentro do intervalo entre 100 e 200");

        } else {

            System.out.println("numero esta fora do intervalo entre 100 e 200");

        }

    }
}
