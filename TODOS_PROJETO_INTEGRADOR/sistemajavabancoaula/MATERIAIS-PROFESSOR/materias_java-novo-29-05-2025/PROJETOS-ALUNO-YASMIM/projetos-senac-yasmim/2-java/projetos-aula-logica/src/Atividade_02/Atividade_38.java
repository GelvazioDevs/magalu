package Atividade_02;

import java.util.Scanner;

public class Atividade_38 {
    public static void main(String[] args) {

        // FEITA POR GUILHERME SCHRODER
        //Um salário tem os seguintes componentes: - valor nominal - adicional devido a horas extras - valor descontado
        //para o INSS (10% do valor a receber, limitado a 150 reais). O valor adicional devido às horas extras é
        //calculado dividindo-se o valor nominal
        //por 176 (22 dias de 8 horas), multiplicando-se pela quantidade de horas e ainda com um acréscimo de 50%.
        //Escrever um programa que lê os valores necessários, calcula e mostra na tela os componentes do salário e
        //o salário líquido
        //resultante para o empregado.

        //Não é preciso prever arredondamentos, mas os valores devem ser mostrados na tela com duas casas decimais.
        //Exemplos: para um salário de R$ 1.000,00, com 30 horas extras, teremos R$ 255,68 de horas extras
        //[(1.000/176)*30*1,5], R$ 125,57 de INSS e um salário líquido de R$ 1.130,11.
        //Para um salário de R$ 2.000,00 e 20 horas extras, seriam R$ 340,91 de horas extras,
        //R$ 150,00 de INSS (e não os 10%), com um salário líquido de R$ 2.190,91.


        //INSS = 10% do salario

        Scanner teclado = new Scanner(System.in);

        float salario,horas_extras,valor_das_horasextras,valor_INSS,salario_liquido;

        System.out.println("Informa o valor nominal do salario:");
        salario = teclado.nextFloat();
        System.out.println("Informe quantidade de horas extras:");
        horas_extras = teclado.nextFloat();

        valor_das_horasextras = (salario/176f)*horas_extras*1.5f;


        valor_INSS = (salario+valor_das_horasextras)*0.1f;

        if (valor_INSS>150){
            valor_INSS=150;
        }

        salario_liquido= (salario + valor_das_horasextras) - valor_INSS;

        System.out.println("Valor das horas extras:");
        System.out.format("%.2f",valor_das_horasextras);
        System.out.println(" ");


        System.out.println("Valor do INSS:");
        System.out.format("%.2f",valor_INSS);
        System.out.println(" ");

        System.out.println("Salario liquido:");
        System.out.format("%.2f",salario_liquido);


    }
}
