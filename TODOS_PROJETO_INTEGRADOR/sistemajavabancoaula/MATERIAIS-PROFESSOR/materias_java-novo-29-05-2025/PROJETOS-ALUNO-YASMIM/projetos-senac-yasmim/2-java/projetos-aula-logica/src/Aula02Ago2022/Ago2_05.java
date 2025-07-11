package Aula02Ago2022;

public class Ago2_05 {
    public static void main(String[] args) {
        // Determinado pais tem populacao de 5 milhoes de habitantes com taxa de natalidade de 4 % e mortalidade de 1,1 %.
        // Um segundo pais tem 7 milhoes de pessoas e natalidade de 2% e mortalidade de 0,8% .
        // Em quanto tempo o pais 1 ira ultrapassar o pais 2?
        // Quantos milhoes de população tera o pais 1 e o pais 2 quando isso ocorrer?

        // Váriaveis:
        int pop1 = 5000000;
        int pop2 = 7000000;
        float nat1 = 0.04f;
        float mort1 = 0.011f;
        float nat2 = 0.02f;
        float mort2 = 0.008f;
        int anos = 0;

        System.out.println("");

        while (pop1 < pop2) {
            pop1 = (int) (pop1 + (pop1 * nat1) - (pop1 * mort1));
            pop2 = (int) (pop2 + (pop2 * nat2) - (pop2 * mort2));
            anos = ++anos;

        }

        System.out.println("O país 1 demorará " + anos + " anos para ultrapassar o país 2 em população.");
        System.out.println("O país 1 terá " + pop1 + " habitantes quando isso acontecer.");
        System.out.println("O país 2 terá " + pop2 + " habitantes quando isso acontecer.");






    }
}
