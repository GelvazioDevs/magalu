package Aula01Ago2022;

import java.util.Scanner;

public class Exe_17 {
    public static void main(String[] args) {
        // Suponha que voce foi ao supermercado e comprou:
        // n Kg de café á x reais;
        // k litros de leite á y reais;
        // m Kg de farinha a z reais;
        // Faça um algoritmo que imprima o ticket de compra.
        // Primeiro produto: R$ 0,00 Segundo // : R$ 0.00


        Scanner tecla = new Scanner(System.in);
        int n, k, m;
        float xun, xt, yun, yt, zun, zt, total;

        System.out.println("Bem vindo ao Supermercado Piriquito :)");
        System.out.println("Quantos kilos de café?");
        n = tecla.nextInt();
        System.out.println("Qual o preço unitário do kilo de café?");
        xun = tecla.nextFloat();
        System.out.println("Quantos litros de leite?");
        k = tecla.nextInt();
        System.out.println("Qual o preço unitário do litro de leite?");
        yun = tecla.nextFloat();
        System.out.println("Quantos kilos de farinha?");
        m = tecla.nextInt();
        System.out.println("Qual o preço unitário do kilo de farinha?");
        zun = tecla.nextFloat();

        xt = n * xun;
        yt = k * yun;
        zt = m * zun;

        System.out.println("Produto...........qtd  x  R$/un.........Total");
        System.out.println("==============================================");
        System.out.println("Café:.........." + n + " un   x   R$"+ xun + "/un....... R$" + xt );
        System.out.println("Leite:........." + k + " un   x   R$"+ yun + "/un....... R$" + yt );
        System.out.println("Farinha:......." + m + " un   x   R$"+ zun + "/un....... R$" + zt );


    }
}
