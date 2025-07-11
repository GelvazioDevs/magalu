package Aula18Ago2022;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_Matrizes_01 {
    public static void main(String[] args) {
        // Faca uma matriz A de ordem 9x3 que:
        //leia nome, idade e sexo de nove pessoas.
        //Imprima os valores da matriz gerada.

        Scanner sc = new Scanner(System.in);
        String matriz[][] = new String[9][3];

        String nome;
        String sexo;
        int idade;
        int l, c;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                switch (j) {
                    case 0:
                        System.out.println("Digite o " + (i + 1) + "º nome:");
                        nome = sc.next();

                        matriz[i][j] = nome;
                        break;

                    case 1:
                        System.out.println("Digite o " + (i + 1) + "º idade:");
                        idade = sc.nextInt();

                        matriz[i][j] = Integer.toString(idade);

                        break;

                    case 2:
                        System.out.println("Digite o " + (i + 1) + "º sexo:");
                        sexo = sc.next();
                        matriz[i][j] = sexo;
                        break;
                }
            }




        }
        for (l = 0; l < matriz.length; l++) {
            System.out.println(Arrays.toString(matriz[l]));
//            for (c = 0; c<matriz[l].length; c++){
//            }
        }

    }
}
