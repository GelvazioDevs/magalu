package Aula01Ago2022;

import java.util.Scanner;

public class Exe_13 {
    public static void main(String[] args) {
        // Faça um algoritmo para ler uma temperatura em graus Celsius,
        // e transforme * para graus Farenheidt e Kelvin.
        // * C / 5 = (F - 32)/9 OUUUUU F = 9/5*C +32
        // * K = C + 273;

        Scanner tecla = new Scanner(System.in);
        int c, f, k;

        System.out.println("Insira uma temperatura em graus Célsius que eu te informo em Fahrenheit e em Kelvin:");
        c = tecla.nextInt();

        f = (((c * 9) / 5) + 32);
        k = c + 273;

        System.out.println("A temperatura de "+ c + "ºC em Fahrenheit é: "+ f + "F");
        System.out.println("E em Kelvin é " + k + "K");
    }
}
