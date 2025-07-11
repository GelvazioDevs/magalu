package Atividade_01;

import java.util.Scanner;

public class Exercício_52 {
    public static void main(String[] args) {
//        Os números perfeitos são iguais à soma de seus divisores:
//        6 pode ser dividido por 1, 2 e 3 e, quando você soma esses números, o resultado é 6.
//        Faça um algoritmo que conte quantos numeros perfeitos existem entre 1 e 5000;

        Scanner teclado = new Scanner(System.in);
        int n, i, soma = 0, numpft = 0;

        for ( i = 1; i <= 5000; i++) {

            soma= 0;
            for (n = 1; n < i; n++) {
               if (i % n == 0) {
                   soma = soma + n;
               }

            }
            if (soma == i) {
                numpft++;

            }
        }
        System.out.println("Existem " + numpft + " números perfeitos entre 1 e 5000!");
    }
}
