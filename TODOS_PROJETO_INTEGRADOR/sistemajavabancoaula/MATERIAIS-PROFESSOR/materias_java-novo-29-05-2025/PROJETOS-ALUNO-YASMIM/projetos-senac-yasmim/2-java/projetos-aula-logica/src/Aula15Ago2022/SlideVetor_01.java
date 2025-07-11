package Aula15Ago2022;

import java.util.Scanner;

public class SlideVetor_01 {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);

        //var
        String vetor [] = new String[10];
        int i;

        for (i = 0; i < vetor.length; i++) {
            System.out.println("Digite um nome: ");
            vetor [i] = tc.nextLine();
        }
        for (i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

    }
}
