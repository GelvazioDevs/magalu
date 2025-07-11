package Aula22Ago2022;

import java.util.Scanner;

public class String_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("Digite uma palavra:");
        String palavra = sc.next();
        n = palavra.length();
        System.out.println("O número de caracteres da palavra digitada é: " + palavra.length());
        System.out.println("A palavra em letras maiúsculas: " + palavra.toUpperCase());
        String vetor[] = new String [n];

        vetor = palavra.split("");
        int vogal = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equalsIgnoreCase("a")) {
                vogal++;
            } if (vetor[i].equalsIgnoreCase("e")) {
                vogal++;
            } if (vetor[i].equalsIgnoreCase("i")) {
                vogal++;
            } if (vetor[i].equalsIgnoreCase("O")) {
                vogal++;
            } if (vetor[i].equalsIgnoreCase("u")) {
                vogal++;
            }
        }
        System.out.println("O número de vogais da palavra digitada é: " + vogal);
        boolean uni = false;

        for (int i =0; i < vetor.length; i++) {
            if (vetor[0].equalsIgnoreCase("u")) {
                if (vetor[1].equalsIgnoreCase("n")) {
                    if (vetor[2].equalsIgnoreCase("i")) {
                    uni = true;
                    }
                }
            }
        }

        if (uni) {
            System.out.println("A palavra começa com UNI");
        } else {
            System.out.println("A palavra não começa com UNI");
        }
        String fim = palavra.substring((n-3), n);
        boolean rio = false;
        for (int i = 0; i < fim.length(); i++) {
            if (fim.equalsIgnoreCase("rio")){
                rio = true;
            }
            }
        if (rio) {
            System.out.println("A palavra termina com RIO");
        } else {
            System.out.println("A palavra não termina com RIO");
        }
        boolean pali = true;
        for (int x = 0; x < n; x++) {
            if (palavra.charAt(x) != palavra.charAt(n - x - 1)) {
                pali = false;
            } else {
                pali = true;
            }
        }

        if (pali) {
            System.out.println("É palíndromo!");
        } else {
            System.out.println("Não é palíndromo");
        }

    }
}
