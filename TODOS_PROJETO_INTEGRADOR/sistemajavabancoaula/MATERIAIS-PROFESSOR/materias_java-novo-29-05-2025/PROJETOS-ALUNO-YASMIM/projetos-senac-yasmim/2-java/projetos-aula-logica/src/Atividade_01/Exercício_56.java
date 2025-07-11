package Atividade_01;

import java.util.Scanner;

public class Exercício_56 {
    public static void main(String[] args) {
        // Leia a nota de 10 alunos e exiba quantos alunos tem nota acima de 7.

        Scanner teclado = new Scanner(System.in);
        // variáveis
        float nota;
        int controlador;
        int controle = 10;
        int notamaior = 0;

        for ( controlador = 1; controlador <= controle; controlador++) {
            System.out.println("Insira a " + controlador + "ª nota:");
            nota = teclado.nextFloat();

            if (nota > 7) {
                notamaior++;
            }

        }

        System.out.println(notamaior + " alunos tem nota acima de 7!");

    }
}
