package Aula18Ago2022;

import java.util.Arrays;

public class Ex_Matrizes_07 {
    public static void main(String[] args) {
        // Dada uma matriz de ordem 3X3.
        //Matriz A =
        //[
        //  [2, 5, 11],
        //  [5, 4, 17],
        //  [11, 17, 6]
        //]
        //Faca um algoritmo que gera a Matriz B Oposta desta matriz A.
        //Explicacao sobre Matriz Oposta: clique aqui

        int mat_a[][] = {
                {2, 5, 11},
                {5, 4, 17},
                {11, 17, 6}
        };
        int mat_b[][] = new int[3][3];

        for (int l = 0; l < mat_a.length; l++) {
            for (int c = 0; c < mat_a[l].length; c++) {
                mat_b[l][c] = (-1 * mat_a[l][c]);
            }
        }
        System.out.println("A matriz oposta de A é:");

        for (int l = 0; l < mat_a.length; l++) {
            System.out.println(Arrays.toString(mat_b[l]));
        }
    }
}
