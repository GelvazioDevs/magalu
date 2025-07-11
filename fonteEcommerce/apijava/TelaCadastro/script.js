// UTILIDADES
function salvarLS(chave, valor) {
  localStorage.setItem(chave, JSON.stringify(valor));
}

function carregarLS(chave) {
  return JSON.parse(localStorage.getItem(chave)) || [];
}

function gerarId(lista) {
  return lista.length ? Math.max(...lista.map(e => e.id)) + 1 : 1;
}

// USUÁRIOS
const usuarios = carregarLS('usuarios');
const listaUsuarios = document.getElementById('listaUsuarios');
const selectUsuarios = document.getElementById('pedidoUsuarioId');

document.getElementById('formUsuario').addEventListener('submit', e => {
  e.preventDefault();
  const id = gerarId(usuarios);
  const nome = document.getElementById('usuarioNome').value;
  const email = document.getElementById('usuarioEmail').value;
  const senha = document.getElementById('usuarioSenha').value;
  usuarios.push({ id, nome, email, senha });
  salvarLS('usuarios', usuarios);
  atualizarUsuarios();
  e.target.reset();
});

function atualizarUsuarios() {
  listaUsuarios.innerHTML = '';
  selectUsuarios.innerHTML = '<option value="">Selecione um usuário</option>';
  usuarios.forEach(u => {
    listaUsuarios.innerHTML += `<li>${u.id} - ${u.nome} (${u.email})</li>`;
    selectUsuarios.innerHTML += `<option value="${u.id}">${u.nome}</option>`;
  });
}
atualizarUsuarios();

// PRODUTOS
const produtos = carregarLS('produtos');
const listaProdutos = document.getElementById('listaProdutos');
const selectProdutos = document.getElementById('itemProdutoId');

document.getElementById('formProduto').addEventListener('submit', e => {
  e.preventDefault();
  const id = gerarId(produtos);
  const descricao = document.getElementById('produtoDescricao').value;
  const preco = parseFloat(document.getElementById('produtoPreco').value);
  const precopromocional = parseFloat(document.getElementById('produtoPrecoPromocional').value || 0);
  const categoria = document.getElementById('produtoCategoria').value;
  const estoque = parseInt(document.getElementById('produtoEstoque').value);
  produtos.push({ id, descricao, preco, precopromocional, categoria, estoque });
  salvarLS('produtos', produtos);
  atualizarProdutos();
  e.target.reset();
});

function atualizarProdutos() {
  listaProdutos.innerHTML = '';
  selectProdutos.innerHTML = '<option value="">Selecione um produto</option>';
  produtos.forEach(p => {
    listaProdutos.innerHTML += `<li>${p.id} - ${p.descricao} - R$${p.preco.toFixed(2)}</li>`;
    selectProdutos.innerHTML += `<option value="${p.id}">${p.descricao}</option>`;
  });
}
atualizarProdutos();

// PEDIDOS
const pedidos = carregarLS('pedidos');
const listaPedidos = document.getElementById('listaPedidos');
const selectPedidos = document.getElementById('itemPedidoId');

document.getElementById('formPedido').addEventListener('submit', e => {
  e.preventDefault();
  const id = gerarId(pedidos);
  const usuarioId = parseInt(document.getElementById('pedidoUsuarioId').value);
  const dataPedido = new Date().toISOString();
  const status = document.getElementById('pedidoStatus').value;
  const valorTotal = parseFloat(document.getElementById('pedidoValorTotal').value || 0);
  const valorFrete = parseFloat(document.getElementById('pedidoFrete').value || 0);
  const valorDescontos = parseFloat(document.getElementById('pedidoDescontos').value || 0);
  const metodoPagamento = document.getElementById('pedidoPagamento').value;
  const statusPagamento = document.getElementById('pedidoStatusPagamento').value;
  const enderecoEntrega = document.getElementById('pedidoEndereco').value;
  const codigoRastreamento = document.getElementById('pedidoRastreamento').value;
  const dataEntregaPrevista = document.getElementById('pedidoEntregaPrevista').value;
  const dataEntregaReal = document.getElementById('pedidoEntregaReal').value;

  pedidos.push({
    id, usuarioId, dataPedido, status, valorTotal, valorFrete,
    valorDescontos, metodoPagamento, statusPagamento, enderecoEntrega,
    codigoRastreamento, dataEntregaPrevista, dataEntregaReal
  });

  salvarLS('pedidos', pedidos);
  atualizarPedidos();
  e.target.reset();
});

function atualizarPedidos() {
  listaPedidos.innerHTML = '';
  selectPedidos.innerHTML = '<option value="">Selecione o pedido</option>';
  pedidos.forEach(p => {
    listaPedidos.innerHTML += `<li>#${p.id} - Usuário ${p.usuarioId} - ${p.status}</li>`;
    selectPedidos.innerHTML += `<option value="${p.id}">Pedido #${p.id}</option>`;
  });
}
atualizarPedidos();

// ITENS PEDIDO
const itens = carregarLS('itensPedido');
const listaItens = document.getElementById('listaItensPedido');

document.getElementById('formItemPedido').addEventListener('submit', e => {
  e.preventDefault();
  const id = gerarId(itens);
  const pedido_id = parseInt(document.getElementById('itemPedidoId').value);
  const produto_id = parseInt(document.getElementById('itemProdutoId').value);
  const quantidade = parseInt(document.getElementById('itemQuantidade').value);
  const precoUnitario = parseFloat(document.getElementById('itemPrecoUnitario').value);
  const precoTotal = parseFloat(document.getElementById('itemPrecoTotal').value || (quantidade * precoUnitario));
  const descontoAplicado = parseFloat(document.getElementById('itemDesconto').value || 0);

  itens.push({ id, pedido_id, produto_id, quantidade, precoUnitario, precoTotal, descontoAplicado });
  salvarLS('itensPedido', itens);
  atualizarItens();
  e.target.reset();
});

function atualizarItens() {
  listaItens.innerHTML = '';
  itens.forEach(i => {
    listaItens.innerHTML += `<li>Item #${i.id} - Pedido ${i.pedido_id} - Produto ${i.produto_id} - Qtde: ${i.quantidade}</li>`;
  });
}
atualizarItens();
