package com.example.magalu.model;

public class Usuario {
    
//     ID: Código único do usuário
// Nome Completo: Nome e sobrenome
// Email: Endereço de email único para login
// Senha: Senha criptografada
// CPF: Número único de identificação
// Telefone: Número de contato
// Endereço: Endereço completo
// Data de Nascimento: Data de nascimento
// Tipo de Usuário: ALUNO, PROFESSOR, GESTOR
// Matrícula/ID Funcional: Número de identificação institucional
// Data de Cadastro: Data em que foi registrado no sistema
// Status: Ativo, Inativo, Bloqueado
// Foto: Imagem do usuário (opcional)
// Data de Último Acesso: Registro do último login

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
