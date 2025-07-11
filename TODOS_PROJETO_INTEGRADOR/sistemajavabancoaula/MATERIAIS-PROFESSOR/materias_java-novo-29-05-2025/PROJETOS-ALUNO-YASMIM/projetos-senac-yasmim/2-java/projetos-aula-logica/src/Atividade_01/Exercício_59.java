package Atividade_01;

import java.util.Scanner;

public class Exercício_59 {
    public static void main(String[] args) {
        //Leia a quantidade de votos de 5 vereadores eleitos e informe quantos vereadores tiveram mais do que 200 votos.

        Scanner teclado = new Scanner(System.in);
        // variáveis
        int votos;
        int controle = 5;
        int controlador;
        int duzentos = 0;

        for (controlador = 1; controlador <= controle; controlador++) {
            System.out.println("Digite a quantidade de votos do " + controlador + "º candidato:");
            votos = teclado.nextInt();
            if (votos > 200) {
                duzentos++;
            }
        }

        System.out.println(duzentos + " candidatos receberam mais de 200 votos.");
    }
}
