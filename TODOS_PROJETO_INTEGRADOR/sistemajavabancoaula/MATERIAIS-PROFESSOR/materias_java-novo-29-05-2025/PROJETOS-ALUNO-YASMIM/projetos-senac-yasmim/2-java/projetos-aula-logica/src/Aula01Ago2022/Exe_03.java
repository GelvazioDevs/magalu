package Aula01Ago2022;

public class Exe_03 {
    public static void main(String[] args) {
        // Vou e volto diariamente a pé para o trabalho, que dista aproximadamente 800 m de minha casa.
        // Supondo que trabalho 5 dias por semana, 45 semanas por ano,
        // "bole" a operação matemática que deve ser efetuada para calcular quantos quilômetros,
        // aproximadamente, terei andado ao final de um ano. Elabore um programa que faça as contas e mostre o resultado

        float l, dia, semana, km;

        l = 800 * 2;
        dia = 5;
        semana = 45;

        km = (((l * dia) * semana)/1000);

        System.out.println("A distância em quilômetros que terás andado ao final de um ano, indo e voltando do trabalho é de aproximadamente " + km + " km.");


    }

}
