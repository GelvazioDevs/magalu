package Atividade_01;

import java.util.Scanner;

public class Exercício_62 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Leia 30 valores referente ao valor gasto com transporte
        // durante cada dia de um mês. Em seguida, informe o total
        // em dinheiro gasto no mês.

        //var
        int valor = 0;
        int total = 0;

        for (int i = 1;i<=30;i++){
            System.out.println("Informe o valor gasto com transporte no " + i + "º dia:");
            valor = teclado.nextInt();

            total = total+valor;
        }

        System.out.println("Valor gasto com transporte no mês:");
        System.out.println(total);
    }
}
