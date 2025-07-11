package Atividade_01;

import java.util.Scanner;

public class Exercício_64 {
    // Leia o preço de 10 livros em uma livraria e informe quantos livros custam mais do que R$ 50,00.
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        // variaveis
        int controle;
        int controlador = 10;
        float preco;
        int controlepreco = 0;

        for (controle = 1; controle <= controlador; controle++) {
            System.out.println("Insira o preço do " + controle + "º livro:");
            preco = teclado.nextFloat();

            if (preco > 50.00) {
                controlepreco++;
            }
        }
        System.out.println(controlepreco + " livros custam mais de R$50,00");
    }
}
