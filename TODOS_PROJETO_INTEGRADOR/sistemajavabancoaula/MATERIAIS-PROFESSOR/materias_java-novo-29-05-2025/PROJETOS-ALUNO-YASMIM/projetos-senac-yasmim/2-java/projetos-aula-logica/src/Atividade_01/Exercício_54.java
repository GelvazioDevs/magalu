package Atividade_01;

import java.util.Scanner;

public class Exercício_54 {
    public static void main(String[] args) {
        // Leia 7 valores referentes ao valor gasto com o almoço de cada dia durante uma semana.
        // Em seguida, informe o total em dinheiro gasto na semana.

        Scanner teclado = new Scanner(System.in);
        // variáveis
        float almoco, soma = 0;
        int contador = 1;
        int controle = 7;

        for (contador = 1; contador <=  controle; contador++ ) {
            System.out.println("Insira o valor do almoço do " + contador + "º dia:");
            almoco = teclado.nextFloat();
            soma = soma + almoco;
        }

        System.out.println("O total gasto em almoços esta semana é R$" + soma);



    }
}
