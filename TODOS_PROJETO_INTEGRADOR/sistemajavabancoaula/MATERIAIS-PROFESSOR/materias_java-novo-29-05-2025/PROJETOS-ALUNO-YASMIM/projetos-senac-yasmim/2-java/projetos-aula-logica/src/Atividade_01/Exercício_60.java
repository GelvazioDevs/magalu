package Atividade_01;

import java.util.Scanner;

public class Exercício_60 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Leia a nota de 10 alunos e exiba quantos alunos tem nota entre 5 e 7.

        //var

        float nota=0;
        int entre5e7=0;

        for (int i = 0;i<10;i++){
            System.out.println("Informe a nota do aluno:");
            nota = teclado.nextFloat();

            if ((nota>5)&&(nota<7)){
                entre5e7++;
            }
        }
        System.out.println(" ");
        System.out.println("Tem "+entre5e7+" alunos com notas entre 5 e 7!");
    }
}
