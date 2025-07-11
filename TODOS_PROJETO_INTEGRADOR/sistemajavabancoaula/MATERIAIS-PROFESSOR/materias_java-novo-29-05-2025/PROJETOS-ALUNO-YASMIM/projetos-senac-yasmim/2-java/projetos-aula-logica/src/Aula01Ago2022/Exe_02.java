package Aula01Ago2022;

public class Exe_02 {

    public static void main(String[] args) {
        // Uma pessoa com pouco tempo disponível lê um livro por 5 minutos a cada dia, 6 dias por semana.
        // Monte a fórmula e escreva um programa que calcula e mostra na tela quanto tempo, em horas,
        // a pessoa terá dedicado ao livro ao final de um ano.

        double th, ts, ta;
        // th = tempo em hora
        // tempo na semana
        // tempo no ano

        ts = 5 * 6;
        th = (ts / 60);
        ta = th * 52;

        System.out.println("O tempo, em horas que uma pessoa terá dedicado à leitura, se tiver apenas 5 min por dia " +
                "é de " + ta + " horas.");




    }
}
