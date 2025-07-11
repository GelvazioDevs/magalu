package Atividade_01;

import java.util.Scanner;

public class Exercício_05 {
    public static void main(String[] args) {
        //Encontrar o dobro de um número caso ele seja positivo e o seu triplo caso seja negativo, imprimindo o resultado.

        Scanner teclado = new Scanner(System.in);
        //var
        int numero,num;

        System.out.println("Informe um valor:");
        numero = teclado.nextInt();

        if (numero>0){
            num= numero*2;
        }else {
            num=numero*3;
        }
        System.out.println("Valor final:");
        System.out.println(num);


    }
}
