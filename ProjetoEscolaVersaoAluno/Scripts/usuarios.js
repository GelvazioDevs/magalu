const baseUrl = "http://localhost:8080/api/v1";

document.getElementById('formUsuario').addEventListener('submit', function(e) {
  e.preventDefault();
  const form = e.target;
  const dados = {
    nome_completo: form.nome.value,
    email: form.email.value,
    cpf: form.cpf.value,
    tipo_usuario: form.tipo_usuario.value
  };

  fetch(baseUrl + "/alunos", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Authorization": "Bearer " + localStorage.getItem("token")
    },
    body: JSON.stringify(dados)
  }).then(res => res.json()).then(() => {
    alert("Usuário cadastrado!");
    form.reset();
    carregarDadosUsuarios();
  });
});

async function carregarDadosUsuarios() {
  console.log("Carregando dados dos usuários...");
  const response = await fetch(baseUrl + "/alunos", {
    headers: {
      "Content-Type": "application/json",
      "Authorization": "Bearer " + localStorage.getItem("token")
    }
  }).then(res => res.json()).then(alunos => {
    const corpo = document.querySelector("#tabelaUsuarios tbody");
    corpo.innerHTML = "";
    alunos.forEach(u => {
      const linha = `<tr><td>${u.nome}</td><td>${u.email}</td><td>${u.cidade}</td></tr>`;
      corpo.innerHTML += linha;
    });
  });

  const responseJson = await response.json();

  return responseJson;
}