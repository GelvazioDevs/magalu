// document.getElementById('formDisciplina').addEventListener('submit', function (e) {
//   e.preventDefault();
//   // inicializaPagina();
// });

function inicializaPagina() {
  const form = e.target;
  const dados = {
    nome: form.nome.value,
    codigo: form.codigo.value,
    carga_horaria: parseInt(form.carga_horaria.value),
    serie: form.serie.value,
    descricao: form.descricao.value
  };

  fetch("https://sua-api.com/api/disciplinas", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Authorization": "Bearer " + localStorage.getItem("token")
    },
    body: JSON.stringify(dados)
  }).then(res => res.json()).then(() => {
    alert("Disciplina cadastrada!");
    form.reset();
    carregarDisciplinas();
  });
}

function carregarDisciplinas() {
  fetch("https://sua-api.com/api/disciplinas", {
    headers: {
      "Authorization": "Bearer " + localStorage.getItem("token")
    }
  }).then(res => res.json()).then(lista => {
    const corpo = document.querySelector("#tabelaDisciplinas tbody");
    corpo.innerHTML = "";
    lista.forEach(d => {
      const linha = `<tr><td>${d.nome}</td><td>${d.codigo}</td><td>${d.serie}</td><td>${d.carga_horaria}</td></tr>`;
      corpo.innerHTML += linha;
    });
  });
}

// Gestão de disciplinas (gestor/professor)
async function buscarDisciplinas() {
  const res = await fetch('https://sua-api.com/api/disciplinas', {
    headers: {
      'Authorization': 'Bearer ' + localStorage.getItem('token')
    }
  });
  if (!res.ok) return [];
  return await res.json();
}

async function renderTabela(disciplinas) {
  // const corpo = document.querySelector('#tabelaDisciplinas tbody');
  // corpo.innerHTML = '';
  // disciplinas.forEach(d => {
  //   corpo.innerHTML += `<tr><td>${d.nome}</td><td>${d.area}</td><td>${d.carga}</td></tr>`;
  // });

  
  // Lista todos os professores
  const professores = await buscarDadosApi('professores');

  const corpo = document.querySelector('#tabelaNotas tbody');
  corpo.innerHTML = '';
  disciplinas.forEach(n => {

    const professor = professores.find(p => p.id === n.professor_id);
    corpo.innerHTML += `<tr><td>${n.nome}</td><td>${n.serie}</td><td>${professor.nome}</td><td>${n.status}</td></tr>`;
  });

}

async function atualizarTabela() {
  const disciplinas = await buscarDisciplinas();
  const termo = document.getElementById('pesquisaDisciplina').value.toLowerCase();
  const area = document.getElementById('filtroArea').value;
  const filtradas = disciplinas.filter(d => {
    let ok = true;
    if (area && d.area !== area) ok = false;
    if (termo && !(`${d.nome}`.toLowerCase().includes(termo))) ok = false;
    return ok;
  });
  renderTabela(filtradas);
}

// const usuario = JSON.parse(localStorage.getItem('usuarioLogado')) || { cargo: 'Aluno' };
// if (usuario.cargo === 'Aluno') {
//   // Buscar notas do aluno autenticado
//   async function buscarNotasAluno() {
//     const res = await fetch('https://sua-api.com/api/aluno/notas', {
//       headers: {
//         'Authorization': 'Bearer ' + localStorage.getItem('token')
//       }
//     });
//     if (!res.ok) return [];
//     return await res.json();
//   }
//   function renderTabelaNotas(notas) {
//     const corpo = document.querySelector('#tabelaNotas tbody');
//     corpo.innerHTML = '';
//     notas.forEach(n => {
//       corpo.innerHTML += `<tr><td>${n.disciplina}</td><td>${n.nota}</td><td>${n.media}</td><td>${n.situacao}</td></tr>`;
//     });
//   }
//   async function atualizarTabelaNotas() {
//     const notas = await buscarNotasAluno();
//     renderTabelaNotas(notas);
//   }
//   atualizarTabelaNotas();
// } else {
//   // Gestão de disciplinas (gestor/professor)
//   document.getElementById('pesquisaDisciplina').addEventListener('input', atualizarTabela);
//   document.getElementById('filtroArea').addEventListener('change', atualizarTabela);

//   atualizarTabela();
// }



// NOVA PARTE PROFESSOR

const baseUrl = "http://localhost:8080/api/v1";
// http://localhost:8080/api/v1/disciplinas
async function carregarDadosDisciplinas() {
  console.log("Carregando dados das disciplinas...");

  const response = await fetch(baseUrl + "/disciplinas", {
    headers: {
      "Content-Type": "application/json",
      "Authorization": "Bearer " + localStorage.getItem("token")
    }
  });

  const responseJson = await response.json();

  renderTabela(responseJson);

  return responseJson;
}