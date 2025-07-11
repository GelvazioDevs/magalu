package Atividade_01;

import java.util.Scanner;

public class Exercício_26 {
    public static void main(String[] args) {
        //Faça um algoritmo para calcular o Indice de Massa Corporal de uma pessoa,
        // considerando a seguinte formula: IMC = PESO / (ALTURA AO QUADRADO) Se a pessoa
        // tiver IMC MENOR OU IGUAL A 18.5, mostre a mensagem abaixo: "Parabens! Voce esta
        // no seu peso ideal" Senão mostre a mensagem abaixo: "Voce nao esta na faixa de peso ideal"
        Scanner teclado = new Scanner(System.in);
        double peso, altura, IMC;

        System.out.println("Calculadora de IMC:");
        System.out.println();
        System.out.println("Informe seu peso:");
        peso = teclado.nextDouble();
        System.out.println("Informe sua altura:");
        altura = teclado.nextDouble();


        //peso=80
        //altura=1,7
        //IMC=23,5
        IMC = peso / (Math.pow(altura,2));
        System.out.println("Seu IMC é: " + IMC);


        if (IMC <= 18.5) {
            System.out.println("Parabens! Você está no seu peso ideal!");
        } else {
            System.out.println("Você não esta na faixa de peso ideal!");


        }
}}
