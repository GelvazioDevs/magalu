package Atividade_02;

import java.util.Scanner;

public class Atividade_17 {
    public static void main(String[] args) {
        // FEITO POR YASMIM
        // Faca um algoritmo que leia o maior, o menor e o intermediario de tres numeros digitados.

        Scanner tecla = new Scanner(System.in);
        int a,b,c = 0;
        int maior =0 , meio=0, menor = 0;
        System.out.println("Digite três números diferentes:");
        a = tecla.nextInt();
        b = tecla.nextInt();
        c = tecla.nextInt();


        if ((a>b) && (a>c)) {
            maior = a;
            if (b>c) {
                meio = b;
                menor = c;
            } else {
                meio = c;
                menor = b;
            }
        } else {

            if ((b>a) && (b>c)) {
                maior = b;
                if (a>c) {
                    meio = a;
                    menor = c;
                } else {
                    meio = c;
                    menor = a;
                }
            }
            else {

                if ((c>a) && (c>b)){
                    maior = c;
                    if (a>b) {
                        meio = a;
                        menor = b;
                    } else {
                        meio = b;
                        menor = a;
                    }
                }
            }
        }
        System.out.println("O menor número digitado foi o número " + menor );
        System.out.println("O número intermediário digitado foi o número " + meio );
        System.out.println("O maior número digitado foi o número " + maior );

    }
}
