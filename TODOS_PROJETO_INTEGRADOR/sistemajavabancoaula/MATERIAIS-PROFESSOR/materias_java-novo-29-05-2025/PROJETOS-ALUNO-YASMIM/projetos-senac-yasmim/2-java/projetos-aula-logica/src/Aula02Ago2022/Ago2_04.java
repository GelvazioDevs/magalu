package Aula02Ago2022;

import java.util.Scanner;

public class Ago2_04 {
    public static void main(String[] args) {
        // Dada uma serie de 5 valores, faca um algoritmo que calcule e escreva a media destes.
        //Entretanto, se a media obtida for maior que 8, devera ser atribuido 10 para a media.

        Scanner tecla = new Scanner(System.in);
        int i = 1;
        float nota, soma = 0, media;

        while (i<=5) {
            System.out.println("Insira a nota " + i +" do aluno:");
            nota = tecla.nextFloat();

            soma = soma + nota;
            i = ++i;
        }

        media = (soma / 5);

        if (media > 8.0) {
            System.out.println("A média do aluno é 10.0");
        } else {
            System.out.println("A média do aluno é " + media);
        }


    }
}
