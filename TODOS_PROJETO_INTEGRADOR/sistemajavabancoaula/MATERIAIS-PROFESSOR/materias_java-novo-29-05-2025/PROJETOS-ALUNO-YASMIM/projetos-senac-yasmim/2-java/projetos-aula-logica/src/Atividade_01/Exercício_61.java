package Atividade_01;

import java.util.Scanner;

public class Exercício_61 {
    public static void main(String[] args) {
        // Leia o nome de 10 alunos em uma sala de aula e exiba quantas pessoas se chamam João.

        Scanner teclado = new Scanner(System.in);
        // variáveis
        int control;
        int joao = 0;
        String nome;

        for (control = 1; control <= 10; control++) {
            System.out.println("Insira o nome do " + control + "º aluno:");
            nome = teclado.nextLine();

            if (nome.equalsIgnoreCase("joão")) {
                joao++;
            }

        }
               System.out.println(joao + " alunos se chamam João");
    }
}
