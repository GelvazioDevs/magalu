package Aula15Ago2022;

import java.util.Scanner;

public class SlideVetor_02 {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);

        int idade [] = new int[10];
        int i, soma=0;
        float media;

        for (i = 0; i < idade.length; i++) {
            System.out.println("Digite a idade da pessoa " + (i+1));
            idade[i] = tc.nextInt();

        } for(i = 0; i < idade.length; i++) {
            soma = soma + idade [i];

        }
        media = soma / 10;

        System.out.format("A média das idades é " + "%.2f",media + " anos");



    }
}
