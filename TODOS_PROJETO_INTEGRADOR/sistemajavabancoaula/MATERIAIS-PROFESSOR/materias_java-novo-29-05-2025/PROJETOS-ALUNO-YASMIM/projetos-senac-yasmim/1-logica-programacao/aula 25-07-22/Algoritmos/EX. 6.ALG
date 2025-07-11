Algoritmo "Ex. 6"
// Disciplina   : Programador de Sistemas
// Professor   : Gelvazio Camargo

// Descrição   : Escreva um algoritmo que lê dois valores booleanos (lógicos)
//               e então determina se ambos são VERDADEIROS ou FALSOS.
//               Obs:Faça uma pergunta por exemplo:
//               Você é maior de idade?Responda SIM ou NAO.
//               Atribua o valor conforme o caso e no final mostre a resposta:
//               A pessoa é maior de idade, se a resposta for SIM
//               A pessoa é menor de idade, se a resposta for NAO
// Autor(a)    : Yasmim A. Roeder
// Data atual  : 24/07/2022
Var
   // Seção de Declarações das variáveis
   idade, dinheiro: inteiro
   din, maiori: logico


Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...

   escreval ("Olá! Quantos anos você tem?")
   leia (idade)
   Escreval ("Quanto dinheiro você tem para investir na sua carteira de habilitação?")
   leia (dinheiro)

   limpatela

   din <- falso
   maiori <- falso

   se (idade >= 18) e (dinheiro >= 3000) entao
      din    <- verdadeiro
      maiori <- verdadeiro
   fimse

   se din e maiori entao
      escreval ("Você pode tirar sua carteira de habilitação!")
   senao
      escreval ("Você não pode tirar dua carteira de habilitação!")

   fimse


Fimalgoritmo