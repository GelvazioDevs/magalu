document.getElementById('formRelatorio').addEventListener('submit', function(e) {
  e.preventDefault();
  const form = e.target;
  const serie = form.serie.value;
  const bimestre = form.bimestre.value;

  fetch(`https://sua-api.com/api/relatorios?serie=${serie}&bimestre=${bimestre}`, {
    headers: {
      "Authorization": "Bearer " + localStorage.getItem("token")
    }
  }).then(res => res.json()).then(relatorio => {
    const corpo = document.querySelector("#tabelaRelatorio tbody");
    corpo.innerHTML = "";
    relatorio.forEach(r => {
      const linha = `<tr><td>${r.nome_aluno}</td><td>${r.nome_disciplina}</td><td>${r.nota}</td></tr>`;
      corpo.innerHTML += linha;
    });
  });
});