package Aula16Ago2022;

import java.util.Scanner;

public class Aula_Ex_07 {
    public static void main(String[] args) {
        // Amplie o exercício 06 imprimindo o menor Nome do vetor
        //(usar função strlen() do JAVA)
        //(A função strlen retorna o número de caracteres inseridos numa variável. Ex.: Caso o usuário digitar o nome Maria, o strlen() retornará o valor 05.

        Scanner sc = new Scanner(System.in);
        String[] nome = new String[10];
        String menome = null;
        int ch, menor =0;
        int i;

        for (i = 0; i < nome.length; i++) {
            System.out.println("Digite um nome: ");
            nome[i] = sc.next();
            
            ch = nome[i].length();

            if (menor == 0) {
                menor = ch;
                menome = nome[i];
                
            }
            if (ch < menor) {
                menor = ch;
                menome = nome[i];
            }
            
        }
        System.out.println("O menor nome digitado foi: " + menome);
      
    }

    
}
