package Aula01Ago2022;

public class Exe_09 {
    public static void main(String[] args) {
        // Um estudante muito metódico estava matriculado em 6 disciplinas, e dispunha de 1 hora e 40 minutos para estudar.
        // Sua intenção era dividir o tempo disponível igualmente para as 6 disciplinas, e descansar livremente o tempo restante.
        // Faça um programa que calcule o tempo que ele deve dedicar para cada disciplina e o tempo livre.

        // 1h 40 = 100min

        float tempo, livre;

        tempo = 100 / 6;
        livre = (100 % 6);

        System.out.println("O aluno deverá dedicar " + tempo + " minutos para estudar cada matéria!");
        System.out.println("O aluno terá " + livre + " minutos de tempo livre");


    }

}
