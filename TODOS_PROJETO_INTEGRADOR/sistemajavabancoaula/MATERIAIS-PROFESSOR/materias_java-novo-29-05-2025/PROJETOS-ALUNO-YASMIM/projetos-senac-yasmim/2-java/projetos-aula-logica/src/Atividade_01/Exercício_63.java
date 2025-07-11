package Atividade_01;

import java.util.Scanner;

public class Exercício_63 {
    public static void main(String[] args) {
        // Leia o nome de 20 alunos em uma sala de aula e exiba quantas pessoas se chamam Maria.

        Scanner teclado = new Scanner(System.in);
        // variáveis
        int control;
        int maria = 0;
        String nome;

        for (control = 1; control <= 5; control++) {
            System.out.println("Insira o nome do " + control + "º aluno:");
            nome = teclado.nextLine();

           if (nome.equalsIgnoreCase("maria")) {
                maria++;
            }

        }

        System.out.println(maria + " alunas se chamam Maria!");

    }
}
