package Aula04Ago2022;

import java.util.Scanner;

public class Slide_01 {
    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);

        int n;
        System.out.println("Digite um número: ");
        n = tecla.nextInt();


        for (int i = 0; i <= n; i++) {
            System.out.println(i);
        }



    }
}
