Algoritmo "Ex. 11"

// Descrição   : O IMC – Indice de Massa Corporal é um critério da
//               Organização Mundial de Saúde para dar umaindicação sobre a
//               condição de peso de uma pessoa adulta.
//               A fórmula é IMC = peso / ( altura )2
//               Elabore um algoritmo que leia o peso e a altura de um adulto
//               e mostre sua condição de acordo com a tabela abaixo.
//               IMC em adultos Condição Abaixo de 18,5 Abaixo do peso
//               Entre 18,5 e 25 Peso normal
//               Entre 25 e 30 Acima do peso
//               Acima de 30 obeso

// Autor(a)    : Yasmim A. Roeder
// Data atual  : 24/07/2022
Var
   // Seção de Declarações das variáveis
   h, p, imc: real

Inicio
   // Seção de Comandos, procedimento, funções, operadores, etc...
   Escreval ("Olá, vamos calcular o seu IMC")
   Escreval("")
   Escreval("Para isso, preciso que você informe a sua altura")
   leia (h)
   Escreval("Muito bem! Agora informe o seu peso atual: ")
   leia (p)

   limpatela

   // imc = (p/(h^2))
   imc := (p/(h^2))

   se (imc<=18.5) entao
      escreval ("Abaixo do peso")

   senão
      se (imc > 18.5) e (imc <= 25) entao
         escreval ("Peso normal!")

      senao
         se (imc > 25) e (imc <= 30) entao
            escreval ("Acima do peso")

         senao
            se (imc > 30)  entao
               escreval ("Obeso")
            fimse
         fimse
      fimse
   fimse


Fimalgoritmo