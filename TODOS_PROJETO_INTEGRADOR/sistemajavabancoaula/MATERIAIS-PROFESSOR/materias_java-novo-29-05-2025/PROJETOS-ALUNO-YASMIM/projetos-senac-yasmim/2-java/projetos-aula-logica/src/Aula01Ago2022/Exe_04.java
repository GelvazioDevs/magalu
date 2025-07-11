package Aula01Ago2022;

import java.util.Scanner;

public class Exe_04 {

    public static void main(String[] args) {
        // Faça um algoritmo para verificar se um aluno esta APROVADO ou REPROVADO,
        // lendo 3 notas e calculando sua media que deve ser maior ou igual a 7.

        Scanner tec = new Scanner(System.in);

        float n1, n2, n3, media;

        System.out.println("Insira a primeira nota:");
        n1 = tec.nextFloat();
        System.out.println("Insira a segunda nota:");
        n2 = tec.nextFloat();
        System.out.println("Insira a terceira nota:");
        n3 = tec.nextFloat();

        media = ((n1 + n2 + n3)/3);

        if (media >= 7.0) {
            System.out.println("Aluno APROVADO");
        } else {
            System.out.println("Aluno REPROVADO");
        }

    }

}
