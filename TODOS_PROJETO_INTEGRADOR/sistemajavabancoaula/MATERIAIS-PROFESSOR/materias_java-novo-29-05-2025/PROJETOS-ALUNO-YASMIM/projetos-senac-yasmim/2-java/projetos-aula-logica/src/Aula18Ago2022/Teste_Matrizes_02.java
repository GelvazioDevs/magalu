package Aula18Ago2022;

import java.util.Arrays;
import java.util.Scanner;

public class Teste_Matrizes_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int matriz [] [] = new int[3][3];
        int l, c;
        int par = 0;
        int impar = 0;

        for (l = 0; l < matriz.length; l++) {
            for (c = 0; c <matriz[l].length; c++) {
                System.out.println("Digite um numero");
                matriz[l][c] = sc.nextInt();
                if (matriz [l][c]%2 ==0) {
                    par++;
                } else {
                    impar++;
                }

            }
        }
        for (l = 0; l < matriz.length; l++) {
             System.out.println(Arrays.toString(matriz[l]));

        }


        System.out.println(par + " números são pares");
        System.out.println(impar + " números são impares");


    }
}
