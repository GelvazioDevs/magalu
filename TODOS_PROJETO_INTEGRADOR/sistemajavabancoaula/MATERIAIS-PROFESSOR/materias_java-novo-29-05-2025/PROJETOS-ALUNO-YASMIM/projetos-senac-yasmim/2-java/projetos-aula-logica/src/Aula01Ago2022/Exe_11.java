package Aula01Ago2022;

import java.util.Scanner;

public class Exe_11 {

    public static void main(String[] args) {
        // Determine a velocidade de um automovel que percorreu uma distancia S em km,
        // * em um intervalo de tempo T,informando em horas.

        Scanner tecla = new Scanner(System.in);

        int s, t, v;

        System.out.println("Vamos determinar a velocidade média de um automóvel!");
        System.out.println("Para isso, preciso que você insira a distância percorrida em KM");
        s = tecla.nextInt();
        System.out.println("Agora informe quanto tempo o automóvel demorou para percorrer esta distância, em horas");
        t = tecla.nextInt();

        v = (s/t);

        System.out.println("A velocidade média do veículo foi de " + v + "km/h.");


    }
}
