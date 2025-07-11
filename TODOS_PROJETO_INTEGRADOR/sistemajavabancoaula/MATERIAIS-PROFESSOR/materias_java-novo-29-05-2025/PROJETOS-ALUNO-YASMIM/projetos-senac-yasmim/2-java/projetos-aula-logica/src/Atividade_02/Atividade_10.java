package Atividade_02;

import java.util.Scanner;

public class Atividade_10 {
    public static void main(String[] args) {
        // FEITA POR GUILHERME SCHRODER
        //Tendo como dados de entrada a altura e o sexo de uma pessoa, construa um
        // algoritmo que calcule seu peso ideal, utilizando as seguintes fórmulas:
        //
        //    para homens: (72.7 * h) – 58;
        //    para mulheres: (62.1 * h) – 44.7.

        Scanner teclado = new Scanner(System.in);

        float altura=0;
        float pesoideal=0;
        String sexo= " ";

        System.out.println("Calculadora de peso ideal:\n");
        System.out.println("Informe seu sexo M ou F:");
        sexo = teclado.next();

        System.out.println("Informe sua altura:");
        altura = teclado.nextFloat();

        if (sexo.equalsIgnoreCase("M")){
            pesoideal = (72.7f*altura)-58;
            System.out.println("Seu peso ideal é:");
            System.out.println(pesoideal);
        }if (sexo.equalsIgnoreCase("F")){
            pesoideal = (float) ((62.1f*altura)-44.7);
            System.out.println("Seu peso ideal é:");
            System.out.println(pesoideal);

        }
        else {
            System.out.println("Sexo invalido!");
        }



    }
}
