package Aula18Ago2022;

public class Ex_Matrizes_06 {
    public static void main(String[] args) {
        // Dada uma matriz de ordem 3X3.
        //Matriz A =
        //[
        //  [2, 5, 11],
        //  [5, 4, 17],
        //  [11, 17, 6]
        //]
        //Faca um algoritmo que verifique se esta Matriz é simetrica.
        //Para isso sabemos que a Matriz é simetrica quando: Matriz A = Matriz A(Transposta).
        //Desse modo temos de gerar a Matriz transposta de A e ver se Aij = Aji.

        int mat_a[][] = {
                {2, 5, 11},
                {5, 4, 17},
                {11, 17, 6}
        };
        int mat_trans[][] = new int[3][3];
        boolean transposta = true;

        for (int l = 0; l < mat_a.length; l++) {
            for (int c = 0; c < mat_a[l].length; c++) {
               if (mat_trans[l][c] != (mat_a[c][l])) {
                transposta = false;
               }
            }
        }

        if (transposta) {
                   System.out.println("Matriz é simétrica");
        } else {
                   System.out.println("Matriz não é Simetrica");
        }



    }
}
