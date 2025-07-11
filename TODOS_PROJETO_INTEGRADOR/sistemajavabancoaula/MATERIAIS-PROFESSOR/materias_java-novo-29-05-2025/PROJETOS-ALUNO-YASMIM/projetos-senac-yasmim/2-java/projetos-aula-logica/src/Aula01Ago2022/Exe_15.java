package Aula01Ago2022;

import java.util.Scanner;

public class Exe_15 {
    public static void main(String[] args) {
        // Calcule o salario do mes de um funcionario.
        // * O funcionario ganha 3000, mais 500 reais por carro vendido,
        // * mais 5% do valor total de cada carro vendido.
        // * Quanto o funcionario ganha ao fim do mes?

        Scanner tec = new Scanner(System.in);
        int fixo, com, carro, sal;

        System.out.println("Vamos calcular o salário do seu funcionário:");
        System.out.println("Quantos carros ele vendeu neste mês?");
        carro = tec.nextInt();

        com = carro * 500;
        fixo = 3000;
        sal = fixo + com;

        System.out.println("Seu funcionário deve receber R$" + sal + ",00 este mês");


    }
}
