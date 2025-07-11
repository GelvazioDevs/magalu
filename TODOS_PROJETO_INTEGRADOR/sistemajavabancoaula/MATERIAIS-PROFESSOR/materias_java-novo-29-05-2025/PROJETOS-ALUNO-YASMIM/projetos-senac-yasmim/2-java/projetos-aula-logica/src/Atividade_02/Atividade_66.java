package Atividade_02;

import java.util.Scanner;

public class Atividade_66 {
    public static void main(String[] args) {

        // FEITA POR GUILHERME SCHRODER
        //Escreva um algoritmo que receba quinze números
        // do usuário e imprima a raiz quadrada de cada número.

        Scanner teclado = new Scanner(System.in);
        int numero=0;

        for (int i =0;i<15;i++){

            System.out.println("Informe um valor:");
            numero = teclado.nextInt();

            System.out.println("Raiz quadrada do numero "+numero+" é:");
            System.out.println(Math.sqrt(numero));
        }


    }
}
