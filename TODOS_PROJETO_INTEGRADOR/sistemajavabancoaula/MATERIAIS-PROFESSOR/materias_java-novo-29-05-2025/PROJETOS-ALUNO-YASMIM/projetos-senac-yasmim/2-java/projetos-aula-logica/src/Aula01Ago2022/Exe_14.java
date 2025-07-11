package Aula01Ago2022;

import java.util.Scanner;

public class Exe_14 {
    public static void main(String[] args) {
        // Desenvolva um algoritmo para identificar se um determinado numero inteiro, * é positivo,negativo,ou nulo.

        Scanner tec = new Scanner(System.in);
        int n;

        System.out.println("Insira um número");
        n = tec.nextInt();

        if (n > 0) {
            System.out.println("O número é positivo");
        } else {
            if (n < 0) {
                System.out.println("O número é negativo");
            } else {
                System.out.println("O número é nulo");
            }
        }
    }
}
