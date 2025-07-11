Algoritmo "Ex. 10"

// Descrição   : Tendo como dados de entrada a altura e o sexo de uma pessoa,
//               construa um algoritmo que calcule seu peso ideal,
//               utilizando as seguintes fórmulas:
//               para homens: (72.7 * h) – 58;
//               para mulheres: (62.1 * h) – 44.7.
//               Ao final do mesmo, informe se a pessoa tem peso ideal ou não.
// Autor(a)    : Yasmim A. Roeder
// Data atual  : 24/07/2022
Var
   // Seção de Declarações das variáveis
   //pesoa é o peso atual
   //pesoi peso ideal
   pesoa, pesoi, h: real
   sexo: caractere

Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...

   escreval ("Olá! Informe seu sexo: F/M")
   leia (sexo)
   Escreval ("")
   Escreval ("Informe sua altura")
   leia (h)
   Escreval ("Informe o seu peso atual")
   leia (pesoa)

   se (sexo = "F") ou (sexo="f") entao
      pesoi   := ((62.1 * h) - 44.7)

   senao
      pesoi := ((72.7 * h) - 58)
   fimse

   se (pesoi >= pesoa) entao
      escreval ("Você já está no seu peso ideal!")
   senao
      Escreval ("Você está acima do seu peso ideal")
   fimse


Fimalgoritmo