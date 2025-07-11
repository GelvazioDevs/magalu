Algoritmo "Ex. 4"

// Descrição   : Faça um algoritmo que leia dois valores inteiros A e B,
//               e se os valores forem iguais deverá se somar os dois,
//               caso contrário multiplique A por B.
//               Ao final de qualquer um dos cálculos deve-se atribuir o
//               resultado para uma variável C e mostrar seu conteúdo na tela.
// Autor(a)    : Yasmim A. Roeder
// Data atual  : 24/07/2022
Var
   // Seção de Declarações das variáveis
   a, b, c: inteiro

Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...

   escreval ("Digite o valor para A e B, por favor")
   leia (a,b)

   limpatela

   se (a = b) então
      c := a + b
      escreval ("A soma de ", a, " + ", b, " é igual à ", c)
   senao
      c := a * b
      escreval ("A multiplicação de ", a, " x ", b, " é igual à ", c)
   fimse


Fimalgoritmo