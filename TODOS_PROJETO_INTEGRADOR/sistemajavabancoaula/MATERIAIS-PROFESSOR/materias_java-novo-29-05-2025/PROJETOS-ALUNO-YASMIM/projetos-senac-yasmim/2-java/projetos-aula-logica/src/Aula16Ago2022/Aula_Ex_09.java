package Aula16Ago2022;

import java.util.Scanner;

public class Aula_Ex_09 {
    public static void main(String[] args) {
        // Faça um algoritmo que leia Nome e notas (total de 4 notas) de 5 alunos de um colégio.
        //Após a leitura faça:
        //a. Imprima o Nome e a média dos alunos aprovados (Média >= 7.0).
        //b. Imprima o Nome e a média dos alunos em Recuperação (5.0 >= Média menor que 7.0)
        //c. Imprima o Nome e a média dos alunos reprovados (Média menor que 5.0).
        //d. Imprima o percentual de alunos aprovados.
        //e. Imprima o percentual de alunos reprovados.

        Scanner sc = new Scanner(System.in);
        String nome[] = new String[5];
        float nota[] = new float[4];
        float media[] = new float[5];
       float apr=0, repr=0;

        for (int i = 0; i <nome.length; i++) {
            System.out.println("Digite o nome do aluno " + (i+1));
            nome[i] = sc.next();
            float soma = 0;
                for (int n = 0; n < nota.length; n++) {
                    System.out.println("Digite a " + (n+1) + "ª nota");
                    nota[n] = sc.nextFloat();

                    soma = soma + nota[n];
                }
                media[i] = soma/4;
            System.out.println(media[i] + " " +nome[i]);
        }

                System.out.println("Alunos aprovados");
        for (int i = 0; i < nome.length; i++) {
            if (media[i] >= 7) {
                System.out.println("Aluno(a): " + nome[i] + ".........." + " Média: " + media[i]);
                apr++;
            }
        }
                System.out.println("Alunos em recuperação");
        for (int i = 0; i < nome.length; i++) {
            if ((media[i] >= 5) && (media[i] < 7)) {
                System.out.println("Aluno(a): " + nome[i] + ".........." + " Média: " + media[i]);

            }
        }
                System.out.println("Alunos reprovados");
        for (int i = 0; i < nome.length; i++) {
            if (media[i] < 5) {
                System.out.println("Aluno(a): " + nome[i] + ".........." + " Média: " + media[i]);
                 repr++;
            }


        }
        System.out.println("");
        System.out.println("O percentual de alunos aprovados é: " + ((apr/5)*100));
        System.out.println("O percentual de alunos reprovados é: " + ((repr/5)*100));



    }
}
