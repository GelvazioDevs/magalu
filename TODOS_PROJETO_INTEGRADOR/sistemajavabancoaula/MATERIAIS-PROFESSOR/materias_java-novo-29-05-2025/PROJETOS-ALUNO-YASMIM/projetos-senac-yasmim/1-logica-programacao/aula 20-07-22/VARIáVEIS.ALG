Algoritmo "variáveis"
// Disciplina   : Linguagem e Lógica de Programação
// Autor(a)    : Yasmim A. Roeder
// Data atual  : 20/07/2022
Var

nome: caracter

// meses desde a ultima atualização
AttCadastro: inteiro

ativo: logico

Inicio

    nome := "Yasmim"
    
    // em meses
    AttCadastro := 4

    
    // Sistema tem uma regra de negocios que
    // desativa cliente com data de atualização
    // de cadastro maior que 3 meses
    
    // booleano
    // cadastro do cliente inicia ativo


    Escreval ("Meses desde a ultima atualização do cadastro: ", AttCadastro, " meses")
    
    // rotina 1
    // cliente com cadastro atualizado há mais de 3 meses
    se AttCadastro > 3 então
       ativo := falso
       escreval ("Seu cadastro está inativo")
    senao
       ativo := verdadeiro
       escreval (" Seu cadastro está ativo")
    fimse
    

     // rotina 2
    // calcular limite de credito dos clientes
    
    se ativo = verdadeiro então
       escreval ("Calculando limite de Crédito...")

    senao
       escreval ("Cliente com cadastro inativo, consulte a loja")
       escreval ("Cadastro atualizado há mais de três meses.")
       escreva (AttCadastro, " meses desde a ultima atualização" )
 fimse
    
Fimalgoritmo