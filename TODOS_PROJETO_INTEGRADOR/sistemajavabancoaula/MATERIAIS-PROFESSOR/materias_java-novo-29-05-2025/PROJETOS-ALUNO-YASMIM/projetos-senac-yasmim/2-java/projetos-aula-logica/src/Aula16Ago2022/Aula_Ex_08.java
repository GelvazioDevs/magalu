package Aula16Ago2022;

import java.util.Scanner;

public class Aula_Ex_08 {
    public static void main(String[] args) {
        // Faça um algoritmo que leia um nome e o guarde na memória.
        //Após a leitura, verifique se a palavra é um palíndromo.
        //Um palíndromo é aquela palavra que a sua leitura é a mesma da esquerda para a direita e vice versa. Exemplo: ARARA, ANA, etc.

        Scanner sc = new Scanner(System.in);
        String palindromo;
        boolean pali = true;

        System.out.println("Insira uma palavra:");
        palindromo = sc.next();
        int len = palindromo.length();

        for (int i = 0; i < len; i++) {
            if (palindromo.charAt(i) != palindromo.charAt(len - i - 1)) {
                pali = false;
             }
        }
        if (pali) {
            System.out.println(palindromo + " é palíndromo!");
        } else {
            System.out.println(palindromo + " não é palíndromo!");

        }

    }
}
