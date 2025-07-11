package Aula01Ago2022;

import java.util.Scanner;

public class Exe_18 {
    public static void main(String[] args) {
        // Faça um algoritmo que receba do usuario o raio em cm e calcule o volume de uma esfera.
        //Formula:
        //VOLUME = 4 * PI * R ao cubo.
        Scanner tecla = new Scanner(System.in);
        int r;
        float v;

        System.out.println("Vamos calcular o volume de um cilindro:");
        System.out.println("Informe o valor do Raio em cm");
        r = tecla.nextInt();

        v = (float) (4 * Math.PI * Math.pow(r, 3));

        System.out.println("O volume do cilíndro é: " + v + "cm³");




    }
}
