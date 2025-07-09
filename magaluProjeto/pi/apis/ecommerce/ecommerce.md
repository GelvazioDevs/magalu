## 0. Estrutura Técnica Comum para Todos os Projetos:
- **Backend**: Spring Boot 3.x, criar usando site springinitializer.io
- **Banco de Dados**: PostgreSQL com servidor online NEON.TECH e base de dados de nome = biblioteca
- **ORM**: JPA/Hibernate
- **Segurança**: Spring Security + JWT - Não é obrigatorio...
- **Documentação**: Swagger/OpenAPI - Exemplo no projeto MAGALU
- **Testes**: JUnit 5 + Mockito
- **Build**: Maven
- **Versionamento**: Git

## 1. Plataforma de E-commerce
- **Funcionalidades**: Cadastro de produtos, carrinho de compras, pedidos, usuarios
- **Tecnologias**: Spring Boot, Spring Security, PostgreSQL
- **APIs**: Gestão de produtos, usuários, pedidos, pagamentos
- **Diferencial**: Sistema de avaliações e recomendações


### Funcionalidades Detalhadas da Plataforma de E-commerce:

#### 1. Cadastro de Produtos
- **ID do Produto**: Código único do produto
- **Nome**: Nome do produto
- **Descrição**: Descrição detalhada do produto
- **Preço**: Valor do produto
- **Preço Promocional**: Valor com desconto (opcional)
- **Categoria**: Eletrônicos, Roupas, Livros, etc.
- **Marca**: Marca do produto
- **SKU**: Código de referência do produto
- **Quantidade em Estoque**: Quantidade disponível
- **Peso**: Peso do produto em gramas
- **Dimensões**: Altura, largura, profundidade
- **Imagens**: URLs das imagens do produto
- **Status**: Ativo, Inativo, Esgotado
- **Avaliação Média**: Média das avaliações dos clientes
- **Número de Avaliações**: Quantidade total de avaliações
- **Tags**: Palavras-chave para busca
- **Data de Cadastro**: Data em que foi cadastrado
- **Data de Atualização**: Data da última atualização

#### 2. Cadastro de Usuários
- **ID do Usuário**: Código único do usuário
- **Nome Completo**: Nome e sobrenome
- **Email**: Endereço de email único
- **Senha**: Senha criptografada
- **CPF**: Número único de identificação
- **Telefone**: Número de contato
- **Data de Nascimento**: Data de nascimento
- **Gênero**: Masculino, Feminino, Outro
- **Endereço de Entrega**: Endereço completo para entrega
- **Endereço de Cobrança**: Endereço para cobrança (pode ser diferente)
- **Tipo de Usuário**: Cliente, Administrador, Vendedor
- **Status**: Ativo, Inativo, Bloqueado
- **Data de Cadastro**: Data em que foi registrado
- **Último Acesso**: Data do último login
- **Newsletter**: Se deseja receber promoções por email
- **Termos Aceitos**: Se aceitou os termos de uso

#### 3. Cadastro de Carrinho de Compras
- **ID do Carrinho**: Código único do carrinho
- **Usuário**: Referência ao usuário
- **Produto**: Referência ao produto
- **Quantidade**: Quantidade do produto
- **Preço Unitário**: Preço do produto no momento da adição
- **Preço Total**: Preço unitário × quantidade
- **Data de Adição**: Data em que foi adicionado ao carrinho
- **Data de Atualização**: Data da última atualização
- **Status**: Ativo, Finalizado, Abandonado
- **Observações**: Notas adicionais

#### 4. Cadastro de Pedidos
- **ID do Pedido**: Código único do pedido
- **Usuário**: Referência ao usuário que fez o pedido
- **Data do Pedido**: Data em que foi realizado
- **Status**: Pendente, Aprovado, Em Preparação, Enviado, Entregue, Cancelado
- **Valor Total**: Valor total do pedido
- **Valor do Frete**: Custo do frete
- **Valor dos Descontos**: Total de descontos aplicados
- **Método de Pagamento**: Cartão, PIX, Boleto
- **Status do Pagamento**: Pendente, Aprovado, Recusado, Reembolsado
- **Endereço de Entrega**: Endereço completo para entrega
- **Código de Rastreamento**: Código para rastrear a entrega
- **Data de Entrega Prevista**: Data prevista para entrega
- **Data de Entrega Real**: Data em que foi realmente entregue
- **Observações**: Notas adicionais sobre o pedido

#### 5. Cadastro de Itens do Pedido
- **ID do Item**: Código único do item
- **Pedido**: Referência ao pedido
- **Produto**: Referência ao produto
- **Quantidade**: Quantidade comprada
- **Preço Unitário**: Preço do produto no momento da compra
- **Preço Total**: Preço unitário × quantidade
- **Desconto Aplicado**: Valor do desconto no item
- **Observações**: Notas adicionais sobre o item

#### 6. Cadastro de Avaliações
- **ID da Avaliação**: Código único da avaliação
- **Usuário**: Referência ao usuário que avaliou
- **Produto**: Referência ao produto avaliado
- **Pedido**: Referência ao pedido (opcional)
- **Nota**: Nota de 1 a 5 estrelas
- **Comentário**: Comentário sobre o produto
- **Data da Avaliação**: Data em que foi feita
- **Status**: Aprovada, Pendente, Rejeitada
- **Útil**: Quantidade de pessoas que marcaram como útil

### Estrutura do Banco de Dados PostgreSQL:


### 1. Tabela de Categorias
CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    imagem_url VARCHAR(255),
    categoria_pai_id INTEGER REFERENCES categoria(id),
    ativo BOOLEAN DEFAULT TRUE,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Índices para melhorar performance
CREATE INDEX idx_categoria_nome ON categoria(nome);
CREATE INDEX idx_categoria_pai ON categoria(categoria_pai_id);
CREATE INDEX idx_categoria_ativo ON categoria(ativo);

### 2. Tabela de Produtos
CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    preco_promocional DECIMAL(10,2),
    sku VARCHAR(50) UNIQUE,
    codigo_barras VARCHAR(50),
    categoria_id INTEGER REFERENCES categoria(id),
    marca VARCHAR(100),
    modelo VARCHAR(100),
    peso DECIMAL(8,3),
    altura DECIMAL(8,2),
    largura DECIMAL(8,2),
    profundidade DECIMAL(8,2),
    quantidade_estoque INTEGER DEFAULT 0,
    quantidade_minima INTEGER DEFAULT 0,
    status VARCHAR(20) DEFAULT 'Ativo' CHECK (status IN ('Ativo', 'Inativo', 'Esgotado', 'Em Promoção')),
    destaque BOOLEAN DEFAULT FALSE,
    imagem_principal VARCHAR(255),
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ativo BOOLEAN DEFAULT TRUE
);

-- Índices para melhorar performance
CREATE INDEX idx_produto_nome ON produto(nome);
CREATE INDEX idx_produto_categoria ON produto(categoria_id);
CREATE INDEX idx_produto_sku ON produto(sku);
CREATE INDEX idx_produto_status ON produto(status);
CREATE INDEX idx_produto_preco ON produto(preco);
CREATE INDEX idx_produto_destaque ON produto(destaque);

### 3. Tabela de Imagens dos Produtos
CREATE TABLE produto_imagem (
    id SERIAL PRIMARY KEY,
    produto_id INTEGER NOT NULL REFERENCES produto(id),
    url_imagem VARCHAR(255) NOT NULL,
    alt_text VARCHAR(200),
    ordem INTEGER DEFAULT 0,
    principal BOOLEAN DEFAULT FALSE,
    ativo BOOLEAN DEFAULT TRUE,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Índices para melhorar performance
CREATE INDEX idx_produto_imagem_produto ON produto_imagem(produto_id);
CREATE INDEX idx_produto_imagem_ordem ON produto_imagem(ordem);
CREATE INDEX idx_produto_imagem_principal ON produto_imagem(principal);

### 4. Tabela de Usuários
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(15),
    data_nascimento DATE,
    genero VARCHAR(10) CHECK (genero IN ('Masculino', 'Feminino', 'Outro')),
    newsletter BOOLEAN DEFAULT FALSE,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ultimo_acesso TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Ativo' CHECK (status IN ('Ativo', 'Inativo', 'Bloqueado')),
    ativo BOOLEAN DEFAULT TRUE
);

-- Índices para melhorar performance
CREATE INDEX idx_usuario_email ON usuario(email);
CREATE INDEX idx_usuario_cpf ON usuario(cpf);
CREATE INDEX idx_usuario_status ON usuario(status);

### 5. Tabela de Endereços
CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL REFERENCES usuario(id),
    tipo_endereco VARCHAR(20) DEFAULT 'Residencial' CHECK (tipo_endereco IN ('Residencial', 'Comercial', 'Entrega')),
    cep VARCHAR(9) NOT NULL,
    logradouro VARCHAR(200) NOT NULL,
    numero VARCHAR(20),
    complemento VARCHAR(100),
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    pais VARCHAR(50) DEFAULT 'Brasil',
    principal BOOLEAN DEFAULT FALSE,
    ativo BOOLEAN DEFAULT TRUE,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Índices para melhorar performance
CREATE INDEX idx_endereco_usuario ON endereco(usuario_id);
CREATE INDEX idx_endereco_cep ON endereco(cep);
CREATE INDEX idx_endereco_principal ON endereco(principal);

### 6. Tabela de Carrinhos
CREATE TABLE carrinho (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER REFERENCES usuario(id),
    sessao_id VARCHAR(100),
    produto_id INTEGER NOT NULL REFERENCES produto(id),
    quantidade INTEGER NOT NULL DEFAULT 1,
    preco_unitario DECIMAL(10,2) NOT NULL,
    preco_total DECIMAL(10,2) NOT NULL,
    data_adicao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Ativo' CHECK (status IN ('Ativo', 'Finalizado', 'Abandonado')),
    observacoes TEXT
);

-- Índices para melhorar performance
CREATE INDEX idx_carrinho_usuario ON carrinho(usuario_id);
CREATE INDEX idx_carrinho_sessao ON carrinho(sessao_id);
CREATE INDEX idx_carrinho_produto ON carrinho(produto_id);
CREATE INDEX idx_carrinho_status ON carrinho(status);

### 7. Tabela de Pedidos
CREATE TABLE pedido (
    id SERIAL PRIMARY KEY,
    numero_pedido VARCHAR(20) UNIQUE NOT NULL,
    usuario_id INTEGER NOT NULL REFERENCES usuario(id),
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Pendente' CHECK (status IN ('Pendente', 'Aprovado', 'Em Preparação', 'Enviado', 'Entregue', 'Cancelado')),
    valor_total DECIMAL(10,2) NOT NULL,
    valor_frete DECIMAL(10,2) DEFAULT 0.00,
    valor_descontos DECIMAL(10,2) DEFAULT 0.00,
    metodo_pagamento VARCHAR(50),
    status_pagamento VARCHAR(20) DEFAULT 'Pendente' CHECK (status_pagamento IN ('Pendente', 'Aprovado', 'Recusado', 'Reembolsado')),
    endereco_entrega_id INTEGER REFERENCES endereco(id),
    codigo_rastreamento VARCHAR(100),
    data_entrega_prevista DATE,
    data_entrega_real TIMESTAMP,
    observacoes TEXT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Índices para melhorar performance
CREATE INDEX idx_pedido_usuario ON pedido(usuario_id);
CREATE INDEX idx_pedido_numero ON pedido(numero_pedido);
CREATE INDEX idx_pedido_status ON pedido(status);
CREATE INDEX idx_pedido_data_pedido ON pedido(data_pedido);
CREATE INDEX idx_pedido_status_pagamento ON pedido(status_pagamento);

### 8. Tabela de Itens do Pedido
CREATE TABLE pedido_item (
    id SERIAL PRIMARY KEY,
    pedido_id INTEGER NOT NULL REFERENCES pedido(id),
    produto_id INTEGER NOT NULL REFERENCES produto(id),
    quantidade INTEGER NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    preco_total DECIMAL(10,2) NOT NULL,
    desconto_aplicado DECIMAL(10,2) DEFAULT 0.00,
    observacoes TEXT
);

-- Índices para melhorar performance
CREATE INDEX idx_pedido_item_pedido ON pedido_item(pedido_id);
CREATE INDEX idx_pedido_item_produto ON pedido_item(produto_id);

### 9. Tabela de Avaliações
CREATE TABLE avaliacao (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL REFERENCES usuario(id),
    produto_id INTEGER NOT NULL REFERENCES produto(id),
    pedido_id INTEGER REFERENCES pedido(id),
    nota INTEGER NOT NULL CHECK (nota >= 1 AND nota <= 5),
    comentario TEXT,
    data_avaliacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Aprovada' CHECK (status IN ('Aprovada', 'Pendente', 'Rejeitada')),
    util INTEGER DEFAULT 0,
    ativo BOOLEAN DEFAULT TRUE
);

-- Índices para melhorar performance
CREATE INDEX idx_avaliacao_usuario ON avaliacao(usuario_id);