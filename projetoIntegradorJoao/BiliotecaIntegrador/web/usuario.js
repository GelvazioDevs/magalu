// Supondo que você tenha um formulário com os campos: nome, email, livros, limiteEmprestimos, status, senha
document.getElementById('cadastroForm').addEventListener('submit', async function(e) {
    e.preventDefault();

    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const livros = document.getElementById('listaLivroEmprestado').value; // IDs separados por vírgula
    const limiteEmprestimos = parseInt(document.getElementById('limiteEmprestimos').value, 10);
    const status = document.getElementById('status').value;
    const senha = document.getElementById('senha').value;

    const dados = {
        nome,
        email,
        livros,
        limiteEmprestimos,
        status,
        senha
    };


    console.log("Dados do usuário:", dados);

    try {
        const resposta = await fetch('http://localhost:8080/api/v1/usuarios', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dados)
        });

        if (resposta.ok) {
            alert('Usuário cadastrado com sucesso!');            
        } else {
            alert('Erro ao cadastrar usuário.');
        }
    } catch (erro) {
        alert('Erro de conexão com a API.');
    }
});