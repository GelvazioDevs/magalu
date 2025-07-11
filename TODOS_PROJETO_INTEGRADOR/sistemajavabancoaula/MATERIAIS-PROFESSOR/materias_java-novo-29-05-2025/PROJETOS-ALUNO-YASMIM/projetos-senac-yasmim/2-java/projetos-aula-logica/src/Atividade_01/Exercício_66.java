package Atividade_01;

public class Exercício_66 {
    public static void main(String[] args) {
        // Escreva um algoritmo que leia os numeros de 1 ate 500.
        //Neste intervalo armazene os seguintes dados sobre os numeros:
        //1. quantidade de numeros pares
        //2. quantidade de numeros impares
        //3. quantidade de numeros divisiveis por 3
        //4. soma dos numeros pares
        //5. fatorial dos numeros impares
        //6. quantidade de numeros perfeitos
        //7. quantidade de numeros imperfeitos

        // variáveis

        // controles:
        int pares=0, impares=0, divtres=0,pft=0,impft=0;

        // soma
        int somapar = 0;
        int somapft;

        // fatorial
        int fatimpar = 1;

        // controlefor
        int controle;
        int controlador = 10;

        for (controle = 1; controle<=controlador; controle++) {

            fatimpar = 1;

            if (controle%2 ==0) {
                pares++;
                somapar = somapar + controle;
            } else {
                impares++;

                int n = controle;

                for (int i = n; i >= 1; i-- ) {
                    fatimpar = fatimpar * i;
                }
                System.out.println("O fatorial de " + controle + " é " + fatimpar);

            }
            if (controle % 3 == 0) {
                divtres++;
            }
            somapft = 0;
            for (int x = 1; x < controle; x++) {
                if (controle%x == 0) {
                    somapft = somapft + x;
                }
            }
            if (somapft == controle) {
                pft++;
            } else {
                impft++;
            }

        }
//    //1. quantidade de numeros pares
//        //2. quantidade de numeros impares
//        //3. quantidade de numeros divisiveis por 3
//        //4. soma dos numeros pares
//        //5. fatorial dos numeros impares
//        //6. quantidade de numeros perfeitos
//        //7. quantidade de numeros imperfeitos

        System.out.println("A quantidade de números pares é:" + pares);
        System.out.println("A quantidade de números impares é:" + impares);
        System.out.println("A quantidade de números divisíveis por 3:" + divtres);
        System.out.println("A soma dos números pares é:" + somapar);
        System.out.println("A quantidade de números perfeitos é:" + pft);
        System.out.println("A quantidade de números imperfeitos é:" + impft);






    }
}
