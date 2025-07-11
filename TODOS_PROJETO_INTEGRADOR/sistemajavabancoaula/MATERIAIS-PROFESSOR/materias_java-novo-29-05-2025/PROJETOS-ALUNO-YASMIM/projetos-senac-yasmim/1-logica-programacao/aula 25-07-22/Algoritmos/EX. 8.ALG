Algoritmo "Ex. 8"

// Descrição   : Escreva um algoritmo que leia três valores inteiros
//               e diferentes e mostre-os em ordem decrescente.
// Autor(a)    : Yasmim A. Roeder
// Data atual  : 24/07/2022
Var
   // Seção de Declarações das variáveis

   a, b, c: inteiro
   maior, menor, meio : inteiro

Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...

   escreval ("Insira três número inteiros diferentes")
   leia (a, b, c)

   limpatela

   se (a>b) e (a>c) entao
      maior := a
      se (b>c) entao
         meio := b
         menor := c

      senao
         se (c>b) entao
            meio := c
            menor := b
         fimse
      fimse

   senao
      se (b>a) e (b>c) entao
         maior := b
         se (a>c) entao
            meio := a
            menor := c

         senao
            se (c>a) entao
               meio := c
               menor := a
            fimse
         fimse
      senao
         se (c>a) e (c>b) entao
            maior := c
            se (a>b) entao
               meio := a
               menor := b

            senao
               se (b>a) entao
                  meio := b
                  menor := a
               fimse

            fimse

         fimse
      fimse
   fimse

   Escreval ("A ordem decrescente é: ", maior, ", ", meio, ", ", menor)


Fimalgoritmo