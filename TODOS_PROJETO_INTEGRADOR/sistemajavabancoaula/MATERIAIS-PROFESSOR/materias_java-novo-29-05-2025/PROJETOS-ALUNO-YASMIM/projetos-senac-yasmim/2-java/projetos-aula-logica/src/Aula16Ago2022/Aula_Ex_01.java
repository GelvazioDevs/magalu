package Aula16Ago2022;

import java.util.Scanner;

public class Aula_Ex_01 {
    public static void main(String[] args) {
        // Faça um algoritmo que leia Nome idade e sexo de N pessoas. Após a leitura faça:
        //a. Imprima o Nome, idade e sexo das pessoas cuja idade seja maior que a idade da primeira pessoa.
        //b. Imprima o Nome e idade de todas as mulheres.
        //c. Imprima o Nome dos homens menores de 21 anos.

        Scanner sc = new Scanner(System.in);
        int i, n, opt;
        System.out.println("Quantos nomes deseja inserir?");
        i = sc.nextInt();

        String nome[] = new String [i];
        String sexo[] = new String [i];
        int idade[] = new int[i];

        for (n = 0; n < nome.length; n++) {
            System.out.println("Insira o nome da " + (n+1) + "ª pessoa:");
            nome [n] = sc.next();

            System.out.println("Insira a idade da " + (n+1) + "ª pessoa:");
            idade [n] = sc.nextInt();

            System.out.println("Insira o sexo (M/F) da " + (n+1) + "ª pessoa:");
            sexo [n] = sc.next();

        }

            System.out.println("Nome, idade e sexo das pessoas cuja idade seja maior que a idade da primeira pessoa");
        for (n = 0; n < nome.length; n++) {
            if (idade[n] > idade[0]) {
                System.out.println("Nome: " + nome[n]);
                System.out.println("Idade: " + idade[n]);
                System.out.println("Sexo: " + sexo[n]);

            }
        }
            System.out.println("Nome e idade de todas as mulheres");
        for (n = 0; n < nome.length; n++) {
            if (sexo[n].equalsIgnoreCase("F")) {
                System.out.println("Nome: " + nome[n]);
                System.out.println("Idade: " + idade[n]);

            }
        }
        System.out.println("Nome dos homens menores de 21 anos");
        for (n = 0; n < nome.length; n++) {
            if (sexo[n].equalsIgnoreCase("M") && (idade[n] < 21)) {
                System.out.println("Nome: "+ nome[n]);

            }
        }


    }

}
