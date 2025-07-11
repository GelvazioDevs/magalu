package Aula02Ago2022;

import java.util.Scanner;

public class Ago2_03 {
    public static void main(String[] args) {
        // Dada uma relacao de 5 nomes de carros, imprima quantos sao da cor azul.
        //Sendo que para cada carro tem-se uma ficha contendo a cor e o nome.

        Scanner tecla = new Scanner(System.in);

        String nome;
        int cor;
        int i = 0;
        int az = 0;

        while (i < 5) {
            System.out.println("Insira o nome do seu carro:");
            nome = tecla.next();
            System.out.println("Qual a cor do seu veículo?");
            System.out.println("1 - Azul");
            System.out.println("2 - Outro");
            cor = tecla.nextInt();

            if (cor == 1) {
                az = ++az;
            }
            i = ++i;
        }

        System.out.println(az + " é o número de carros azuis.");


}}





