package Aula18Ago2022;

public class Teste_Matrizes_01 {
    public static void main(String[] args) {
        int matriz [] [] = new int[4][6];

        for (int linhas = 0; linhas < matriz.length; linhas++) {
            for (int colunas = 0; colunas< matriz[linhas].length; colunas++) {
                System.out.println("Elemento da linha " + linhas + "e coluna " + colunas + ": " + matriz[linhas][colunas]);
            }
        }
    }
}
