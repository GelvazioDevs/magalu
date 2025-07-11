package Aula01Ago2022;

import java.util.Scanner;

public class Exe_12 {
    public static void main(String[] args) {
        // aça um algoritmo que leia dois numeros inteiros (n1 e n2)
        // * calcule a divisão de n1/n2, e informe o resto desta divisão.
        // * Não pode ser usado funções pre-programadas(mod em VisualG e % em JAVA).

        Scanner tecla = new Scanner(System.in);
        int n1, n2, div, res;

        System.out.println("Insira dois números");
        n1 = tecla.nextInt();
        n2 = tecla.nextInt();

        div = (n1 / n2);
        res = (n1 % n2);

        System.out.println("A divisão de " + n1 + " e " + n2 + " é igual à " + div);
        System.out.println("O resto da divisão é " + res);

    }
}
