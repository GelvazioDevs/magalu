Algoritmo "Ex. 2"

// Descrição   : Faça um algoritmo que leia o nome, o sexo("F" ou "M")
//               e o estado civil de uma pessoa.
//               Caso sexo seja “F” e estado civil seja “CASADA”,
//               solicitar o tempo de casada (anos).
// Autor(a)    : Yasmim A. Roeder
// Data atual  : 24/07/2022
Var
   // Seção de Declarações das variáveis
   nome: caractere
   sexo: caractere
   est_civil: caractere
   tempo_casado: inteiro

Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...

   escreval ("Olá! Qual o seu nome?")
   leia (nome)
   escreval ("")
   escreval ("Qual o seu sexo? F/M")
   leia (sexo)
   escreval ("")
   escreval ("Qual o seu estado civil?")
   leia (est_civil)

   limpatela

   se (sexo = "F") e (est_civil = "Casada") entao
      escreval ("Há quanto tempo você está casada? (em anos)")
      leia (tempo_casado)
   fimse

Fimalgoritmo