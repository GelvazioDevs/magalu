package Atividade_01;

import java.util.Scanner;

public class Exercício_33 {
    public static void main(String[] args) {

        //Fornecido os coeficientes de uma equação do 2 grau,
        // (a,b,c - ler do teclado) * faça um algoritmo que calcule
        // as raizes se houverem * Validar se o numero e negativo, pois
        // não existe raiz de numero negativo!

        Scanner tecla = new Scanner(System.in);
        int a, b, c, delta;
        float x1, x2;

        System.out.println("Vamos calcular os coeficientes de uma equação de 2º grau.");
        System.out.println("Para isso, insira os valores de A, B e C");
        System.out.println("Considerando: Ax² + bx + c");
        System.out.println("O valor de A:");
        a = tecla.nextInt();
        System.out.println("O valor de B:");
        b = tecla.nextInt();
        System.out.println("O valor de C:");
        c = tecla.nextInt();

        // (-b +- Raiz de delta)/ 2a
        // delta = b² - 4ac

        delta = ((b * b) - 4 * a * c);

        if (delta > 0 ) {
            x1 = (float) ((-b - Math.sqrt(delta))/(2 * a));

            x2 = (float) ((-b + Math.sqrt(delta))/(2 * a));


            System.out.println(delta);
            System.out.println("As raízes da equação são " + x1 + " e " + x2);
        } else {
            System.out.println("A equação não possui raízes.");
        }


    }
    }

