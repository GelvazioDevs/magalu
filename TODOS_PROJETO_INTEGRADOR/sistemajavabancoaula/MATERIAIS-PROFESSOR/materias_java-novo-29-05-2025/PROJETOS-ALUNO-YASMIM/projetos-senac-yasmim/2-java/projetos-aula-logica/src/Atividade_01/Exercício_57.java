package Atividade_01;

import java.util.Scanner;

public class Exercício_57 {
    public static void main(String[] args) {
        // Leia a nota de 20 alunos e exiba quantos alunos tem nota abaixo de 5.

        Scanner teclado = new Scanner(System.in);
        // variáveis
        float nota;
        int controlador;
        int controle = 20;
        int notamenor = 0;

        for ( controlador = 1; controlador <= controle; controlador++) {
            System.out.println("Insira a " + controlador + "ª nota:");
            nota = teclado.nextFloat();

            if (nota < 5) {
                notamenor++;
            }

        }

        System.out.println(notamenor + " alunos tem nota abaixo de 5!");


    }
}
