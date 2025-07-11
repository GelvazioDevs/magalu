package Aula16Ago2022;

import java.util.Scanner;

public class Aula_Ex_01_opt {
    public static void main(String[] args) {
        // Faça um algoritmo que leia Nome idade e sexo de N pessoas. Após a leitura faça:
        //a. Imprima o Nome, idade e sexo das pessoas cuja idade seja maior que a idade da primeira pessoa.
        //b. Imprima o Nome e idade de todas as mulheres.
        //c. Imprima o Nome dos homens menores de 21 anos.

        Scanner sc = new Scanner(System.in);
        int i, n, opt, continuar = 1;
        System.out.println("Quantos nomes deseja inserir?");
        i = sc.nextInt();

        String[] nome = new String [i];
        String[] sexo = new String [i];
        int[] idade = new int[i];

        for (n = 0; n < nome.length; n++) {
            System.out.println("Insira o nome da " + (n+1) + "ª pessoa:");
            nome [n] = sc.next();

            System.out.println("Insira a idade da " + (n+1) + "ª pessoa:");
            idade [n] = sc.nextInt();

            System.out.println("Insira o sexo (M/F) da " + (n+1) + "ª pessoa:");
            sexo [n] = sc.next();

        }

        while (continuar > 0) {

            System.out.println("Escolha uma opção:");
            System.out.println("1 - Nome, idade e sexo das pessoas cuja idade seja maior que a idade da primeira pessoa");
            System.out.println("2 - Nome e idade de todas as mulheres");
            System.out.println("3 - Nome dos homens menores de 21 anos");
            opt = sc.nextInt();


            if (opt == 1) {
                System.out.println("Nome, idade e sexo das pessoas cuja idade seja maior que a idade da primeira pessoa");
                for (n = 0; n < nome.length; n++) {
                    if (idade[n] > idade[0]) {
                        System.out.println("Nome: " + nome[n]);
                        System.out.println("Idade: " + idade[n]);
                        System.out.println("Sexo: " + sexo[n]);

                    }
                }
            }

            if (opt == 2) {
                System.out.println("Nome e idade de todas as mulheres");
                for (n = 0; n < nome.length; n++) {
                    if (sexo[n].equalsIgnoreCase("F")) {
                        System.out.println("Nome: " + nome[n]);
                        System.out.println("Idade: " + idade[n]);

                    }
                }
            }
            if (opt == 3) {
                System.out.println("Nome dos homens menores de 21 anos");
                for (n = 0; n < nome.length; n++) {
                    if (sexo[n].equalsIgnoreCase("M") && (idade[n] < 21)) {
                        System.out.println("Nome: " + nome[n]);

                    }
                }
            }
            if (opt > 3) {
                System.out.println("Opção Inválida");
            }

            System.out.println("Deseja consultar outra informação?");
            System.out.println("0 - NÃO");
            System.out.println("1 - SIM");
            continuar = sc.nextInt();
        }
        System.out.println("Até logo!");
    }

}
