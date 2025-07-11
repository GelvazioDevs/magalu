package Aula02Ago2022;

import java.util.Scanner;

public class Ago2_02 {
    public static void main(String[] args) {
        // Dado o modelo(Fiat, Ford,GM, Wolskwagen,Toyota,Honda), ano fabricação, cor e placa de 5 carros.
        //Faca um algoritmo que:
        //a)Imprima quantos carros sao da cor verde e o percentual em relacao ao total.
        //b)Imprima quantos foram fabricados antes de 1990 percentual em relacao ao total;
        //c)Imprima quantos sao da Fiat e o percentual em relacao ao total;

        Scanner tecla = new Scanner(System.in);
        int ano, marca, cor, opcao;
        int i = 0, iano = 0, imarc = 0, icor = 0; // iano é controle dos anos, imarc controle da marca, icor controle da cor
        float perca = 0, percm = 0, percc = 0; // perca é percentagem do ano, percm percentagem da marca e percc é percentagem da cor.

        while (i < 5) {

            System.out.println("Qual a marca do Carro?");
            System.out.println("1 - Fiat");
            System.out.println("2 - Ford");
            System.out.println("3 - GM");
            System.out.println("4 - Wolkswagen");
            System.out.println("5 - Toyota");
            System.out.println("6 - Honda");
            marca = tecla.nextInt();
            System.out.println("Qual o ano de fabricação?");
            ano = tecla.nextInt();
            System.out.println("Qual a cor do seu carro?");
            System.out.println("1 - Verde");
            System.out.println("2 - Outro");
            cor = tecla.nextInt();

            if (marca == 1) {
                imarc = ++imarc;
            }
            if (ano <= 1990) {
                iano = ++iano;
            }
            if (cor == 1) {
                icor = ++icor;
            }

            i = ++i;

        }

        System.out.println("Você quer:");
        System.out.println("1 - Imprimir quantos carros sao da cor verde e o percentual em relacao ao total.");
        System.out.println("2 - Imprimir quantos foram fabricados antes de 1990 percentual em relacao ao total.");
        System.out.println("3 - Imprimir quantos são da Fiat e o percentual em relação ao total.");
        System.out.println("4 - Todas as opções anteriores.");
        opcao = tecla.nextInt();

        switch (opcao) {
            case 1:
                percc = (((float)icor / 5) * 100);
                System.out.println(icor + " carros são da cor verde. Isto é " + (int)percc + "% em relação ao total de carros.");
              break;

            case 2:
                perca = (((float)iano / 5) * 100);
                System.out.println(iano + " carros foram fabricados antes de 1990. Isto é " + (int)perca + "% em relação ao total de carros.");
                break;

            case 3:
                percm = (((float)imarc / 5) * 100);
                System.out.println(imarc + " carros são da marca FIAT. Isto é " + (int)percm + "% em relação ao total de carros.");
                break;

            case 4:
                percc = (((float)icor / 5) * 100);
                System.out.println(icor + " carros são da cor verde. Isto é " + (int)percc + "% em relação ao total de carros.");
                perca = (((float)iano / 5) * 100);
                System.out.println(iano + " foram fabricados antes de 1990. Isto é " + (int)perca + "% em relação ao total de carros.");
                percm = (((float)imarc / 5) * 100);
                System.out.println(imarc + " carros são da marca FIAT. Isto é " + (int)percm + "% em relação ao total de carros.");
                break;

            default:
                System.out.println("Opção Inválida!");
                break;
        }




//        if (opcao == 1) {
//            percc = (((float)icor / 5) * 100);
//            System.out.println(icor + " carros são da cor verde. Isto é " + (int)percc + "% em relação ao total de carros.");
//        }
//        if (opcao == 2) {
//            perca = (((float)iano / 5) * 100);
//            System.out.println(iano + " carros foram fabricados antes de 1990. Isto é " + (int)perca + "% em relação ao total de carros.");
//        }
//        if (opcao == 3) {
//            percm = (((float)imarc / 5) * 100);
//            System.out.println(imarc + " carros são da marca FIAT. Isto é " + (int)percm + "% em relação ao total de carros.");
//
//        }
//        if (opcao == 4) {
//            percc = (((float)icor / 5) * 100);
//            System.out.println(icor + " carros são da cor verde. Isto é " + (int)percc + "% em relação ao total de carros.");
//            perca = (((float)iano / 5) * 100);
//            System.out.println(iano + " foram fabricados antes de 1990. Isto é " + (int)perca + "% em relação ao total de carros.");
//            percm = (((float)imarc / 5) * 100);
//            System.out.println(imarc + " carros são da marca FIAT. Isto é " + (int)percm + "% em relação ao total de carros.");
//
//        }

    }
}
