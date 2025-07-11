Algoritmo "Ex. 1"

// Descrição   : Faça um algoritmo que leia os valores A, B, C
//               e imprima na tela se a soma de A + B é menor que C.
// Autor(a)    : Yasmim A. Roeder
// Data atual  : 24/07/2022
Var
   // Seção de Declarações das variáveis
   a, b, c: inteiro
   soma: inteiro

Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...
   escreval ("Insira valores para A, B e C:")
   leia (a, b, c)

   soma := a + b

   se (soma > c) entao
      escreval (c, " é menor que ", soma)
   senao
      escreval (c ," é maior que a soma de ", a, " mais ", b)
   fimse



Fimalgoritmo