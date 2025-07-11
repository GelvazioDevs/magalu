Algoritmo "Ex. 3"

// Descrição   : Faça um algoritmo para
//               receber um número qualquer e
//               informar na tela se é par ou ímpar.
// Autor(a)    : Yasmim A. Roeder
// Data atual  : 24/07/2022
Var
// Seção de Declarações das variáveis 
num: inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 

   escreval ("Insira um número inteiro qualquer:")
   leia (num)
   
   limpatela
   
   se (num mod 2 = 0) então
      escreval ("O número ", num, " é par!")
      senao
      escreval ("O número ", num, " é ímpar!")
   fimse


Fimalgoritmo