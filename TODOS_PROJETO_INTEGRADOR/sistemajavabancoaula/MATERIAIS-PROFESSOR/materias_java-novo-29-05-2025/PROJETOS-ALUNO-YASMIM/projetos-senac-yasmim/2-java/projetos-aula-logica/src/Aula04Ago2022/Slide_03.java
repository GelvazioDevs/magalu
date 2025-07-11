package Aula04Ago2022;

import java.util.Scanner;

public class Slide_03 {
    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);

        int n1, n2, i, m = 0;

        System.out.println("Digite dois números: ");
        n1 = tecla.nextInt();
        n2 = tecla.nextInt();

//        while (i <= n2) {
//            m = m + n1;
//            i++;
//            System.out.println(m);
//        }
//        System.out.println(n1 + " x " + n2 + " = " + m);

        for (i = 1; i <= n2; i++) {
            m = m + n1;
            System.out.println(n1 + " x " + i + " = " + m);
        }
        System.out.println(n1 + " x " + n2 + " = " + m);



    }
}
