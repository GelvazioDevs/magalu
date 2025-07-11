document.addEventListener('DOMContentLoaded', () => {
    const produtos = {
        paes: [
            { id: 1, nome: 'Pão Francês', preco: 0.50, imagem: 'https://via.placeholder.com/150' },
            { id: 2, nome: 'Pão de Queijo', preco: 2.50, imagem: 'https://via.placeholder.com/150' },
            { id: 3, nome: 'Pão Doce', preco: 3.00, imagem: 'https://via.placeholder.com/150' },
        ],
        bolos: [
            { id: 4, nome: 'Bolo de Chocolate', preco: 15.00, imagem: 'https://via.placeholder.com/150' },
            { id: 5, nome: 'Bolo de Cenoura', preco: 12.00, imagem: 'https://via.placeholder.com/150' },
            { id: 6, nome: 'Bolo de Fubá', preco: 10.00, imagem: 'https://via.placeholder.com/150' },
        ],
        lanches: [
            { id: 7, nome: 'Misto Quente', preco: 5.00, imagem: 'https://via.placeholder.com/150' },
            { id: 8, nome: 'Coxinha', preco: 4.50, imagem: 'https://via.placeholder.com/150' },
            { id: 9, nome: 'Esfiha', preco: 4.00, imagem: 'https://via.placeholder.com/150' },
        ]
    };

    const carrinho = [];
    const carrinhoItens = document.getElementById('carrinho-itens');
    const carrinhoTotal = document.getElementById('carrinho-total');
    const carrinhoAside = document.getElementById('carrinho');

    function renderizarProdutos() {
        for (const secao in produtos) {
            const secaoDiv = document.getElementById(secao).querySelector('.produtos');
            produtos[secao].forEach(produto => {
                const produtoDiv = document.createElement('div');
                produtoDiv.classList.add('produto');
                produtoDiv.innerHTML = `
                    <img src="${produto.imagem}" alt="${produto.nome}">
                    <h3>${produto.nome}</h3>
                    <p>R$ ${produto.preco.toFixed(2)}</p>
                    <button data-id="${produto.id}" data-secao="${secao}">Adicionar ao Carrinho</button>
                `;
                secaoDiv.appendChild(produtoDiv);
            });
        }
    }

    function adicionarAoCarrinho(e) {
        if (e.target.tagName === 'BUTTON') {
            const id = parseInt(e.target.dataset.id);
            const secao = e.target.dataset.secao;
            const produto = produtos[secao].find(p => p.id === id);

            carrinho.push(produto);
            renderizarCarrinho();
            abrirCarrinho();
        }
    }

    function renderizarCarrinho() {
        carrinhoItens.innerHTML = '';
        let total = 0;
        carrinho.forEach(produto => {
            const li = document.createElement('li');
            li.textContent = `${produto.nome} - R$ ${produto.preco.toFixed(2)}`;
            carrinhoItens.appendChild(li);
            total += produto.preco;
        });
        carrinhoTotal.textContent = total.toFixed(2);
    }

    function abrirCarrinho() {
        carrinhoAside.classList.add('aberto');
    }

    function fecharCarrinho() {
        carrinhoAside.classList.remove('aberto');
    }

    document.querySelector('main').addEventListener('click', adicionarAoCarrinho);

    document.getElementById('finalizar-compra').addEventListener('click', () => {
        alert('Compra finalizada com sucesso!');
        carrinho.length = 0;
        renderizarCarrinho();
        fecharCarrinho();
    });

    renderizarProdutos();
});
