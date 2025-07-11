package Atividade_02;

import java.util.Scanner;

public class Atividade_52 {
    public static void main(String[] args) {


        // FEITO PELA LETÍCIA

        // Desenvolver um algoritmo que efetue a soma de todos os números ímpares que são múltiplos
        //de três e que se encontram no conjunto dos números de 1 até 500.

        Scanner teclado = new Scanner(System.in);

       //variaveis

        int numerosimpares = 0;
        int multiplosdetres;
        int numero;
        int controle = 500;
        int controlador;



        for (controlador = 1; controlador <= controle; controlador ++ ){
            numero = controlador;

            if (numero %3 == 0 ){
                if (! (numero %2 == 0 )){
                    numerosimpares = numerosimpares + numero;
                }
            }

        }
        System.out.println("a soma dos numeros impares e multiplos de tres é " + numerosimpares );









    }



}



