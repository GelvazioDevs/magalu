package Aula02Ago2022;

import java.util.Scanner;

public class Ago2_01 {
    public static void main(String[] args) {
        //Suponha que para cada aluno de uma sala exista uma ficha contendo o nome e a idade de 05 alunos.
        // Faca algoritmo que determine quantos alunos tem idade maior que 30.


        Scanner tecla = new Scanner(System.in);

        int controle = 0, idade;
        String nome;
        int i = 0;

        while (i < 5) {
            System.out.println("Digite o nome do aluno:");
            nome = tecla.nextLine();
            System.out.println("Qual a idade de " + nome + "?");
            idade = tecla.nextInt();
            tecla.nextLine();

            if (idade >= 30) {
                controle++;
            }
            i = ++i;

        }

        System.out.println("A quantidade de alunos acima de 30 anos é " + controle);

    }
}
