Algoritmo "Ex. 5"

// Descrição   : Encontrar o dobro de um número caso ele seja positivo
//               e o seu triplo caso seja negativo, imprimindo o resultado.
// Autor(a)    : Yasmim A. Roeder
// Data atual  : 24/07/2022
Var
   // Seção de Declarações das variáveis

   num: inteiro
   mul: inteiro

Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...

   escreval ("Insira um número!")
   leia (num)

   se (num >= 0) entao
      mul := 2 * num
      escreval ("O dobro de ", num, " é ", mul)
   senao
      mul := 3 * num
      escreval ("O triplo de ", num, " é ", mul)
   fimse

Fimalgoritmo