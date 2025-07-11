package Atividade_01;

import java.util.Scanner;

public class Exercício_65 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Implementar uma progressao aritmetica a partir de um numero inicial x com base numa razao y (y é uma constante)
        //Ex: 1 3 5 7 9 11 13 15 17
        //No exemplo acima a razao é igual a 2. e o numero inicial e 1;
        //Imprimir os 10 primeiros numeros da progressão.

        int x = 0;
        int y = 0;

        System.out.println("Informe valor para x:");
        x = teclado.nextInt();
        System.out.println("Informe valor para y:");
        y = teclado.nextInt();

        System.out.println("Os dez primeiros números da progressão com número inicial " + x + " e razão igual a " + y + " são:");
        System.out.println(x);

        for (int i = 0;i<9;i++){
            x=x+y;

            System.out.println(x);


        }

    }
}
