package Aula04Ago2022;

import java.util.Scanner;

public class Slide_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("Digite um número");
        n = sc.nextInt();


//        while ( n >= 0) {
//            System.out.println(n);
//            n--;
//        }

        for ( int i = n; n >=0; n--) {
            System.out.println(n);

        }

    }

}
