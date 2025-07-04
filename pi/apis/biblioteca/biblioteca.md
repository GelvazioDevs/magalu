## 0. Estrutura Técnica Comum para Todos os Projetos:
- **Backend**: Spring Boot 3.x, criar usando site springinitializer.io
- **Banco de Dados**: PostgreSQL com servidor online NEON.TECH e base de dados de nome = biblioteca
- **ORM**: JPA/Hibernate
- **Segurança**: Spring Security + JWT - Não é obrigatorio...
- **Documentação**: Swagger/OpenAPI - Exemplo no projeto MAGALU
- **Testes**: JUnit 5 + Mockito - NAO E OBRIGATORIO
- **Build**: Maven
- **Versionamento**: Git

## 1. Sistema de Gestão de Biblioteca
- **Funcionalidades**: Cadastro de livros, usuários, empréstimos e devoluções
- **Tecnologias**: Spring Boot, JPA/Hibernate, PostgreSQL
- **APIs**: CRUD completo para livros, usuários, empréstimos
- **Diferencial**: Sistema de notificações para devoluções atrasadas

### Funcionalidades Detalhadas do Sistema de Gestão de Biblioteca:

#### 1. Cadastro de Livros
- **ISBN**: Código único internacional do livro (13 dígitos)
- **Título**: Nome do livro
- **Subtítulo**: Subtítulo opcional
- **Autor**: Nome completo do autor
- **Editora**: Nome da editora
- **Ano de Publicação**: Ano em que o livro foi publicado
- **Edição**: Número da edição
- **Número de Páginas**: Quantidade total de páginas
- **Gênero/Categoria**: Ficção, Não-ficção, Técnico, Acadêmico, etc.
- **Sinopse**: Breve descrição do conteúdo
- **Idioma**: Português, Inglês, Espanhol, etc.
- **Preço**: Valor de aquisição
- **Quantidade Disponível**: Número de exemplares em estoque
- **Localização**: Prateleira, seção, código de localização
- **Status**: Disponível, Emprestado, Em Manutenção, Perdido

#### 2. Cadastro de Usuários
- **Nome Completo**: Nome e sobrenome
- **Email**: Endereço de email único
- **CPF**: Número único de identificação
- **Telefone**: Número de contato
- **Endereço**: Endereço completo
- **Data de Nascimento**: Data de nascimento
- **Tipo de Usuário**: Estudante, Professor, Funcionário, Visitante
- **Matrícula/ID**: Número de identificação institucional
- **Data de Cadastro**: Data em que foi registrado no sistema
- **Status**: Ativo, Inativo, Bloqueado
- **Limite de Empréstimos**: Quantidade máxima de livros que pode emprestar
- **Multas Pendentes**: Valor total de multas não pagas

#### 3. Cadastro de Empréstimos
- **ID do Empréstimo**: Código único do empréstimo
- **Usuário**: Referência ao usuário que fez o empréstimo
- **Livro**: Referência ao livro emprestado
- **Data de Empréstimo**: Data em que o livro foi retirado
- **Data de Devolução Prevista**: Data limite para devolução
- **Data de Devolução Real**: Data em que foi realmente devolvido
- **Status**: Em Andamento, Devolvido, Atrasado
- **Observações**: Notas adicionais sobre o empréstimo
- **Funcionário Responsável**: Quem realizou o empréstimo

#### 4. Cadastro de Devoluções
- **ID da Devolução**: Código único da devolução
- **Empréstimo**: Referência ao empréstimo correspondente
- **Data de Devolução**: Data em que o livro foi devolvido
- **Estado do Livro**: Bom, Regular, Danificado, Perdido
- **Multa Aplicada**: Valor da multa (se houver atraso)
- **Observações**: Comentários sobre o estado do livro
- **Funcionário Responsável**: Quem recebeu a devolução

#### 5. Funcionalidades Adicionais
- **Sistema de Notificações**: Alertas para devoluções próximas do prazo
- **Relatórios**: Estatísticas de empréstimos, livros mais populares
- **Busca Avançada**: Filtros por autor, gênero, disponibilidade
- **Histórico**: Registro completo de empréstimos por usuário
- **Reservas**: Sistema de reserva de livros indisponíveis


## Tabelas PostgreSQL para Sistema de Biblioteca

### 1. Tabela de Livros
CREATE TABLE livro (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(150) NOT NULL,
    editora VARCHAR(100),
    ano_publicacao INTEGER,
    isbn VARCHAR(20) UNIQUE,
    genero VARCHAR(50),
    idioma VARCHAR(30) DEFAULT 'Português',
    numero_paginas INTEGER,
    edicao VARCHAR(20),
    preco DECIMAL(10,2),
    quantidade_disponivel INTEGER DEFAULT 0,
    quantidade_total INTEGER DEFAULT 0,
    localizacao VARCHAR(50),
    codigo_localizacao VARCHAR(20),
    status VARCHAR(20) DEFAULT 'Disponível' CHECK (status IN ('Disponível', 'Emprestado', 'Em Manutenção', 'Perdido')),
    sinopse TEXT,
    capa_url VARCHAR(255),
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ativo BOOLEAN DEFAULT TRUE
);

### 2. Tabela de Usuários
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(15),
    endereco TEXT,
    tipo_usuario VARCHAR(20) DEFAULT 'Aluno' CHECK (tipo_usuario IN ('Aluno', 'Professor', 'Funcionário', 'Administrador')),
    matricula VARCHAR(20) UNIQUE,
    curso VARCHAR(100),
    departamento VARCHAR(100),
    data_nascimento DATE,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ultimo_acesso TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Ativo' CHECK (status IN ('Ativo', 'Inativo', 'Suspenso', 'Bloqueado')),
    limite_emprestimos INTEGER DEFAULT 3,
    emprestimos_ativos INTEGER DEFAULT 0,
    multas_pendentes DECIMAL(10,2) DEFAULT 0.00,
    observacoes TEXT,
    ativo BOOLEAN DEFAULT TRUE
);

-- Índices para melhorar performance
CREATE INDEX idx_usuario_email ON usuario(email);
CREATE INDEX idx_usuario_cpf ON usuario(cpf);
CREATE INDEX idx_usuario_matricula ON usuario(matricula);
CREATE INDEX idx_usuario_tipo ON usuario(tipo_usuario);
CREATE INDEX idx_usuario_status ON usuario(status);

### 3. Tabela de Empréstimos
CREATE TABLE emprestimo (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL REFERENCES usuario(id),
    livro_id INTEGER NOT NULL REFERENCES livro(id),
    data_emprestimo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_devolucao_prevista TIMESTAMP NOT NULL,
    data_devolucao_efetiva TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Ativo' CHECK (status IN ('Ativo', 'Devolvido', 'Atrasado', 'Perdido')),
    observacoes TEXT,
    funcionario_responsavel INTEGER REFERENCES usuario(id),
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    multa_calculada DECIMAL(10,2) DEFAULT 0.00,
    dias_atraso INTEGER DEFAULT 0,
    renovacoes_permitidas INTEGER DEFAULT 0,
    renovacoes_realizadas INTEGER DEFAULT 0
);

-- Índices para melhorar performance
CREATE INDEX idx_emprestimo_usuario ON emprestimo(usuario_id);
CREATE INDEX idx_emprestimo_livro ON emprestimo(livro_id);
CREATE INDEX idx_emprestimo_status ON emprestimo(status);
CREATE INDEX idx_emprestimo_data_emprestimo ON emprestimo(data_emprestimo);
CREATE INDEX idx_emprestimo_data_devolucao_prevista ON emprestimo(data_devolucao_prevista);
CREATE INDEX idx_emprestimo_funcionario ON emprestimo(funcionario_responsavel);

### 4. Tabela de Devoluções
CREATE TABLE devolucao (
    id SERIAL PRIMARY KEY,
    emprestimo_id INTEGER NOT NULL REFERENCES emprestimo(id),
    data_devolucao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    funcionario_recebeu INTEGER REFERENCES usuario(id),
    estado_livro VARCHAR(50) DEFAULT 'Bom' CHECK (estado_livro IN ('Bom', 'Regular', 'Ruim', 'Danificado')),
    observacoes_devolucao TEXT,
    multa_aplicada DECIMAL(10,2) DEFAULT 0.00,
    dias_atraso INTEGER DEFAULT 0,
    valor_multa_por_dia DECIMAL(5,2) DEFAULT 1.00,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Índices para melhorar performance
CREATE INDEX idx_devolucao_emprestimo ON devolucao(emprestimo_id);
CREATE INDEX idx_devolucao_data_devolucao ON devolucao(data_devolucao);
CREATE INDEX idx_devolucao_funcionario ON devolucao(funcionario_recebeu);
CREATE INDEX idx_devolucao_estado_livro ON devolucao(estado_livro);

### 5. Funções adicionais-  ANALISAR DEPOIS...
- **Sistema de Notificações**: Alertas para devoluções próximas do prazo
- **Relatórios**: Estatísticas de empréstimos, livros mais populares
- **Busca Avançada**: Filtros por autor, gênero, disponibilidade
- **Histórico**: Registro completo de empréstimos por usuário
- **Reservas**: Sistema de reserva de livros indisponíveis