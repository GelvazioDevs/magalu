document.getElementById('formEvento').addEventListener('submit', function(e) {
  const usuario = JSON.parse(localStorage.getItem('usuarioLogado')) || {};
  if (usuario.cargo !== 'Gestor' && usuario.cargo !== 'Professor') {
    e.preventDefault();
    alert('Apenas gestores ou professores podem adicionar eventos.');
    return;
  }
  e.preventDefault();
  const form = e.target;
  const evento = {
    data: form.data.value,
    titulo: form.titulo.value,
    descricao: form.descricao.value
  };

  fetch("https://sua-api.com/api/eventos", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Authorization": "Bearer " + localStorage.getItem("token")
    },
    body: JSON.stringify(evento)
  }).then(res => res.json()).then(() => {
    alert("Evento adicionado!");
    form.reset();
    carregarEventos();
  });
});

function carregarEventos() {
  fetch("https://sua-api.com/api/eventos", {
    headers: {
      "Authorization": "Bearer " + localStorage.getItem("token")
    }
  }).then(res => res.json()).then(lista => {
    const ul = document.getElementById("listaEventos");
    ul.innerHTML = "";
    lista.forEach(e => {
      const item = `<li><strong>${e.data}</strong> — ${e.titulo}<br>${e.descricao || ""}</li>`;
      ul.innerHTML += item;
    });
  });
}

carregarEventos();