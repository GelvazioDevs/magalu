document.getElementById('formTurma').addEventListener('submit', function(e) {
  e.preventDefault();
  const form = e.target;
  const dados = {
    nome: form.nome.value,
    serie: form.serie.value,
    ano_letivo: parseInt(form.ano_letivo.value),
    periodo: form.periodo.value,
    sala: form.sala.value,
    capacidade_maxima: parseInt(form.capacidade_maxima.value)
  };

  fetch("https://sua-api.com/api/turmas", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Authorization": "Bearer " + localStorage.getItem("token")
    },
    body: JSON.stringify(dados)
  }).then(res => res.json()).then(() => {
    alert("Turma criada com sucesso!");
    form.reset();
    carregarTurmas();
  });
});

function carregarTurmas() {
  fetch("https://sua-api.com/api/turmas", {
    headers: {
      "Authorization": "Bearer " + localStorage.getItem("token")
    }
  }).then(res => res.json()).then(turmas => {
    const corpo = document.querySelector("#tabelaTurmas tbody");
    corpo.innerHTML = "";
    turmas.forEach(t => {
      const linha = `<tr><td>${t.nome}</td><td>${t.serie}</td><td>${t.ano_letivo}</td><td>${t.periodo}</td></tr>`;
      corpo.innerHTML += linha;
    });
  });
}

carregarTurmas();