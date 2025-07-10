const baseUrl = "http://localhost:8080/api/v1";

async function carregarDadosProfessores() {
  console.log("Carregando dados dos professores...");
  
  const response = await fetch(baseUrl + "/professores", {
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