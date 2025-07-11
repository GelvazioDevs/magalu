package Aula01Ago2022;

import java.util.Scanner;

public class Exe_08 {
    public static void main(String[] args) {
        // Faça um algoritmo para calcular o Indice de Massa Corporal de uma pessoa,
        // considerando a seguinte formula: IMC = PESO / (ALTURA AO QUADRADO)
        // Se a pessoa tiver IMC MENOR OU IGUAL A 18.5,
        // mostre a mensagem abaixo: "Parabens! Voce esta no seu peso ideal"
        // Senão mostre a mensagem abaixo: "Voce nao esta na faixa de peso ideal"

        float peso, imc, h;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Vamos calcular o seu IMC!");
        System.out.println("Para isso, preciso que você insira a sua altura:");
        h = teclado.nextFloat();
        System.out.println("Muito bem! Agora, insira o seu peso atual.");
        peso = teclado.nextFloat();

        imc = (peso/(h * h));

        if (imc <= 18.5) {
            System.out.println("Parabéns! Você está no seu peso ideal");
        } else {
            System.out.println("Você não está na faixa de peso ideal");
        }

    }

}
