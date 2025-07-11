package Atividade_01;

import java.util.Scanner;

public class Exercício_55 {
    public static void main(String[] args) {
        // Leia o nome de 20 alunos em uma sala e exiba quantas pessoas se chamam ou Maria ou João.

        Scanner teclado = new Scanner(System.in);
        // variáveis
        int control;
        int joao = 0;
        int maria = 0;
        int joaooumaria;
        String nome;

        for (control = 1; control <= 10; control++) {
            System.out.println("Insira o nome do " + control + "º aluno:");
            nome = teclado.nextLine();

            if (nome.equalsIgnoreCase("joão")) {
                joao++;
            } if (nome.equalsIgnoreCase("maria")) {
                maria++;
            }

        }
        joaooumaria =  joao + maria;
        System.out.println(joaooumaria + " alunos se chamam João ou Maria!");
    }
}
