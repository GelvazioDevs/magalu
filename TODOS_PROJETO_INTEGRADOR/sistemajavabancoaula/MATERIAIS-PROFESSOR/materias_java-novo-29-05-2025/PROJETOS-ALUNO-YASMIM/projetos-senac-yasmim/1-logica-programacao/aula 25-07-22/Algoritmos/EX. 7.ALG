Algoritmo "Ex. 7"

// Descrição   : Faça um algoritmo que leia uma variável e
//               some 5 caso seja par ou some 8 caso seja ímpar,
//               imprimir o resultado desta operação.
// Autor(a)    : Yasmim A. Roeder
// Data atual  : 24/07/2022
Var
   // Seção de Declarações das variáveis

   num, soma: inteiro


Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...

   escreval ("Insira um número:")
   leia (num)

   se (num mod 2 =0) então
      soma := num + 5
      escreval ("O número ", num, " é par e somado à 5 temos o resultado ", soma)
   senao
      soma := num + 8
      escreval ("O número ", num, " é ímpar e somado à 8 temos o resultado ", soma)
   fimse

Fimalgoritmo