package Aula08Ago2022;

import java.util.Scanner;

public class Exercicio_06 {
    public static void main(String[] args) {
       // Implemente um algoritmo que leia um número e uma opção de listagem.
        //Com base nessa opção, escreva a sequência dos números:
        //em ordem crescente (de zero até o número)
        //ou decrescente (do número até zero).
        //Exemplo:
        //Opcao=> 1 - CRESCENTE
        //Opcao=> 2 - DECRESCENTE

        int i, n, opcao;

        Scanner tecla = new Scanner(System.in);

        System.out.println("Digite um número:");
        n = tecla.nextInt();
        System.out.println("Digite: \n 1 - Ordem Crescente \n 2 - Ordem Decrescente");
        opcao = tecla.nextInt();

        if (opcao == 1) {
            for (i = 0; i <= n; i++) {
                System.out.println(i);
            }
        } else {
            for (i = n; n >= 0; n--) {
                System.out.println(n);
            }
        }

        }




    }

