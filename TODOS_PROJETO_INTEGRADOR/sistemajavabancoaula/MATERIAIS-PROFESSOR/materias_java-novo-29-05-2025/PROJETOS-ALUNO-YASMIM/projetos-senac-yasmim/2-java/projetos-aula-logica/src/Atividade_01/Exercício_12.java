package Atividade_01;

import java.util.Scanner;

public class Exercício_12 {
    public static void main(String[] args) {
    // Faca um algoritmo que leia o nome e as tres notas de um aluno e ao final, escreva o seu nome, sua media e se ele foi aprovado. Media de aprovacao igual a 8.

        Scanner teclado = new Scanner(System.in);

        String nome;
        int num1,num2,num3, media;

        System.out.println("Informe o nome:");
        nome = teclado.next();

        System.out.println("Informe as três notas:");
        num1 = teclado.nextInt();
        num2 = teclado.nextInt();
        num3 = teclado.nextInt();

        media=(num1+num2+num3)/3;

        System.out.println("Nome do aluno:");
        System.out.println(nome);

        System.out.println("Média do aluno:");
        System.out.println(media);

        if (media>=8){
            System.out.println("Aluno aprovado!!");
        }else{
            System.out.println("Aluno reprovado!!");
        }


    }
}
