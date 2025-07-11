package Atividade_01;

import java.util.Scanner;

public class Exercício_58 {
    public static void main(String[] args) {
        // Leia a quantidade de votos de 5 candidatos a prefeitos e informe quantos tiveram mais do que 3000 votos.

        Scanner teclado = new Scanner(System.in);
        // variáveis
        int votos;
        int controle = 5;
        int controlador;
        int tresmil = 0;

        for (controlador = 1; controlador <= controle; controlador++) {
            System.out.println("Digite a quantidade de votos do " + controlador + "º candidato:");
            votos = teclado.nextInt();
            if (votos > 3000) {
                tresmil++;
            }
        }

        System.out.println(tresmil + " candidatos receberam mais de 3000 votos.");

    }
}
