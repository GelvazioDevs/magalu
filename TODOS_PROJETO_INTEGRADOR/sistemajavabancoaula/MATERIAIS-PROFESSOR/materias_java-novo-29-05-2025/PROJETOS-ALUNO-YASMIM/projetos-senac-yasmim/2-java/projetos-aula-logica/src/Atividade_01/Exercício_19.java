package Atividade_01;

import java.util.Scanner;

public class Exercício_19 {
    public static void main(String[] args) {
    // Conta telefônica - Uma conta telefônica é composta dos seguintes custos:
        // assinatura: R$ 17,90
        // impulsos: R$ 0,04 por impulso que exceder a 90 interurbanos
        // chamadas p/ celular: R$0,20 por impulso
        // Monte a fórmula para calcular o valor da conta para 254 impulsos,
        // R$34,29 de interurbanos e
        // 23 chamadas para celular.
        // Elabore um programa que mostra os custos, calcula e mostra o valor total.

        Scanner tecla = new Scanner(System.in);

        float ass = (float) 17.90;
        float imp = (float) 0.04;
        float cel = (float) 0.20;
        float inter, mob, T;

        inter = (float) (((254 - 90) * imp) + 34.29);
        mob = (23 * cel);
        T = ass + mob + inter;

        System.out.println("O valor da assinatura de telefone é R$" + ass);
        System.out.println("O valor das ligações interurbanas deste mês é R$" + inter);
        System.out.println("O valor das ligações para celular deste mês é R$" + mob);
        System.out.println("O valor total da sua conta de telefone este mês é de R$" + T);

    }
}
