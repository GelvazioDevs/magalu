package Aula15Ago2022;

import java.util.Scanner;

public class SlideVetor_03 {
    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);

        double sal [] = new double[10];
        double maior = 0, x;
        int i;

        for (i = 0; i < sal.length; i++) {
            System.out.println("Digite o salário " + (i+1));
            sal[i] = tecla.nextDouble();
            x = sal[i];

            if (x > maior) {
                maior = x;
            }

        }

            System.out.format("O maior salario é: R$" + "%.2f", maior);
    }
}
