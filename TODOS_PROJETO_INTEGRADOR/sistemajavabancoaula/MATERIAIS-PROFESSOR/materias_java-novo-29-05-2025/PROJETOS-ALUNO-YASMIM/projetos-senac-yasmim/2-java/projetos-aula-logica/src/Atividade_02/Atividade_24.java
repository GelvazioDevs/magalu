package Atividade_02;

import java.util.Scanner;

public class Atividade_24 {
    public static void main(String[] args) {
        // FEITO PELA LETÍCIA
        // Faça um algoritmo para verificar se uma pessoa ja atingiu a maioridade.
        // algoritmo deve receber como entrada apenas o ano de nascimento e considerar o ano atual para calculo e 18 anos para maioridade.


        Scanner teclado = new Scanner(System.in);

        //variaveis

       int  ano;
       int idade;



       System.out.println("Insira o ano que voce nasceu");
       ano = teclado.nextInt();

        idade = 2022 - ano;

        if (idade >= 18  ){

            System.out.println("maior de idade");

        }












    }




}
