package Aula16Ago2022;

import java.util.Scanner;

public class Aula_Ex_09_opt {
    public static void main(String[] args) {
        // Faça um algoritmo que leia Nome e notas (total de 4 notas) de 5 alunos de um colégio.
        //Após a leitura faça:
        //a. Imprima o Nome e a média dos alunos aprovados (Média >= 7.0).
        //b. Imprima o Nome e a média dos alunos em Recuperação (5.0 >= Média menor que 7.0)
        //c. Imprima o Nome e a média dos alunos reprovados (Média menor que 5.0).
        //d. Imprima o percentual de alunos aprovados.
        //e. Imprima o percentual de alunos reprovados.

        Scanner sc = new Scanner(System.in);
        String[] nome = new String[5];
        float[] nota = new float[4];
        float[] media = new float[5];
        float apr=0, repr=0;
        int opt, w = 1;

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

        for (int i = 0; i < nome.length; i++) {
            if (media[i] >= 7) {
                apr++;
            }
            if (media[i] < 5) {
                repr++;
            }
        }

        while ( w > 0 ) {
            System.out.println("Escolha uma opção:");
            System.out.println("1........... Nome e a média dos alunos aprovados ");
            System.out.println("2...... Nome e a média dos alunos em recuperação ");
            System.out.println("3.......... Nome e a média dos alunos reprovados ");
            System.out.println("4................ Percentual de alunos aprovados ");
            System.out.println("5............... Percentual de alunos reprovados ");
            opt = sc.nextInt();

            if (opt == 1) {
                System.out.println("Alunos aprovados");
                for (int i = 0; i < nome.length; i++) {
                    if (media[i] >= 7) {
                        System.out.println("Aluno(a): " + nome[i] + ".........." + " Média: " + media[i]);
                    }
                }
            }
            if (opt == 2) {
                System.out.println("Alunos em recuperação");
                for (int i = 0; i < nome.length; i++) {
                    if ((media[i] >= 5) && (media[i] < 7)) {
                        System.out.println("Aluno(a): " + nome[i] + ".........." + " Média: " + media[i]);

                    }
                }
            }
            if (opt == 3) {
                System.out.println("Alunos reprovados");
                for (int i = 0; i < nome.length; i++) {
                    if (media[i] < 5) {
                        System.out.println("Aluno(a): " + nome[i] + ".........." + " Média: " + media[i]);
                    }
                }
            }
            if (opt == 4) {
                System.out.println("O percentual de alunos aprovados é: " + ((apr / 5) * 100));
            }
            if (opt == 5) {
                System.out.println("O percentual de alunos reprovados é: " + ((repr / 5) * 100));
            }
            if (opt > 5) {
                System.out.println("Opção Inválida");
            }

            System.out.println("Deseja continuar?");
            System.out.println("0 - NÃO");
            System.out.println("1 - SIM");
            w = sc.nextInt();
        }

        System.out.println("Até logo!");
    }
}
