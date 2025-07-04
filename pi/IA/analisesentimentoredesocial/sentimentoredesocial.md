## Plataforma de Análise de Sentimentos em Redes Sociais
- **Funcionalidades**: Monitoramento de redes sociais, análise de sentimentos, relatórios
- **Tecnologias**: Spring Boot, PostgreSQL, APIs de redes sociais
- **APIs**: Gestão de monitoramento, relatórios, alertas
- **IA**: Análise de sentimentos usando NLP e machine learning
- **Diferencial**: Dashboard com métricas de sentimento em tempo real


## Detalhamento das Funcionalidades

### 1. Monitoramento de Redes Sociais

#### Cadastros Necessários:

**a) Configuração de Redes Sociais**
- **Twitter/X**: Chaves de API, tokens de acesso, configuração de filtros
- **Instagram**: Credenciais de API, configuração de hashtags monitoradas
- **Facebook**: Tokens de acesso, configuração de páginas/grupos
- **LinkedIn**: Credenciais de API, configuração de empresas monitoradas
- **YouTube**: Chaves de API, configuração de canais/vídeos
- **TikTok**: Configuração de hashtags e contas monitoradas

**b) Filtros de Monitoramento**
- Palavras-chave específicas
- Hashtags relevantes
- Contas de influenciadores
- Períodos de monitoramento
- Idiomas de interesse
- Localização geográfica

**c) Configuração de Alertas**
- Limites de volume de menções
- Palavras-chave críticas
- Mudanças bruscas de sentimento
- Horários de notificação

### 2. Análise de Sentimentos

#### Cadastros de Configuração:

**a) Modelos de IA**
- Configuração de algoritmos de NLP
- Dicionários de palavras positivas/negativas
- Modelos customizados por domínio
- Configuração de precisão e recall

**b) Classificação de Sentimentos**
- Categorias: Positivo, Negativo, Neutro
- Subcategorias: Alegria, Tristeza, Raiva, Surpresa
- Intensidade: Baixa, Média, Alta
- Contexto: Produto, Serviço, Marca, Experiência

**c) Regras de Negócio**
- Peso de diferentes palavras-chave
- Contexto de uso das palavras
- Sarcasmo e ironia
- Gírias e expressões regionais

### 3. Relatórios e Dashboards

#### Cadastros de Configuração:

**a) Templates de Relatórios**
- Relatórios diários, semanais, mensais
- Dashboards personalizados
- Gráficos e visualizações
- Métricas específicas por cliente

**b) Configuração de Métricas**
- Volume de menções
- Sentimento médio
- Influência de posts
- Alcance e engajamento
- Tendências temporais

**c) Usuários e Permissões**
- Administradores do sistema
- Analistas de dados
- Clientes finais
- Níveis de acesso por funcionalidade

## Conceituação da Ideia

### Objetivo Principal
A plataforma visa transformar dados brutos das redes sociais em insights acionáveis através da análise de sentimentos, permitindo que empresas e organizações compreendam a percepção pública sobre suas marcas, produtos e serviços.

### Casos de Uso

**1. Monitoramento de Marca**
- Acompanhar menções da marca em tempo real
- Identificar crises de reputação rapidamente
- Medir impacto de campanhas publicitárias
- Comparar sentimento com concorrentes

**2. Pesquisa de Mercado**
- Analisar tendências de produtos
- Identificar necessidades não atendidas
- Avaliar aceitação de novos lançamentos
- Mapear comportamento do consumidor

**3. Gestão de Crise**
- Detectar problemas antes que se tornem virais
- Monitorar evolução de crises
- Avaliar efetividade de respostas
- Medir recuperação de reputação

**4. Análise de Concorrência**
- Comparar sentimento entre marcas
- Identificar pontos fortes e fracos
- Monitorar lançamentos da concorrência
- Antecipar movimentos estratégicos

**5. Suporte ao Cliente**
- Identificar problemas recorrentes
- Medir satisfação do cliente
- Priorizar melhorias de produto
- Personalizar atendimento

### Valor Agregado

**Para Empresas:**
- Tomada de decisão baseada em dados
- Redução de tempo de resposta a crises
- Melhoria na experiência do cliente
- Vantagem competitiva através de insights

**Para Agências:**
- Serviço diferenciado para clientes
- Relatórios automatizados
- Escalabilidade de análise
- Redução de trabalho manual

**Para Pesquisadores:**
- Dados em tempo real para estudos
- Análise de tendências sociais
- Compreensão de comportamento humano
- Base para publicações acadêmicas

### Diferencial Competitivo

1. **Análise em Tempo Real**: Processamento instantâneo de dados
2. **Precisão de IA**: Modelos customizados por domínio
3. **Integração Multiplataforma**: Dados consolidados de várias redes
4. **Dashboard Intuitivo**: Visualizações claras e acionáveis
5. **Alertas Inteligentes**: Notificações baseadas em padrões
6. **API Flexível**: Integração com sistemas existentes
7. **Relatórios Customizáveis**: Adaptação às necessidades específicas


-- Tabelas para Sistema de Análise de Sentimento em Redes Sociais

-- Tabela de usuários do sistema
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    senha_hash VARCHAR(255) NOT NULL,
    tipo_usuario VARCHAR(50) NOT NULL, -- 'empresa', 'agencia', 'pesquisador', 'admin'
    status VARCHAR(20) DEFAULT 'Ativo',
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de clientes/empresas
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER NOT NULL REFERENCES usuario(id),
    nome_empresa VARCHAR(255) NOT NULL,
    cnpj VARCHAR(18) UNIQUE,
    setor_atividade VARCHAR(100),
    tamanho_empresa VARCHAR(50), -- 'pequena', 'media', 'grande'
    contato_principal VARCHAR(255),
    telefone VARCHAR(20),
    endereco TEXT,
    plano_assinatura VARCHAR(50),
    data_inicio_contrato DATE,
    data_fim_contrato DATE,
    status VARCHAR(20) DEFAULT 'Ativo',
    observacoes TEXT,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de redes sociais monitoradas
CREATE TABLE rede_social (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL, -- 'Twitter', 'Instagram', 'Facebook', 'LinkedIn', 'YouTube'
    tipo_conteudo VARCHAR(50), -- 'texto', 'imagem', 'video', 'misto'
    api_disponivel BOOLEAN DEFAULT true,
    limite_requisicoes INTEGER,
    status VARCHAR(20) DEFAULT 'Ativo',
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de palavras-chave para monitoramento
CREATE TABLE palavra_chave (
    id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL REFERENCES cliente(id),
    termo VARCHAR(255) NOT NULL,
    tipo VARCHAR(50), -- 'marca', 'produto', 'concorrente', 'geral'
    idioma VARCHAR(10) DEFAULT 'pt-BR',
    ativo BOOLEAN DEFAULT true,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de posts coletados
CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    rede_social_id INTEGER NOT NULL REFERENCES rede_social(id),
    cliente_id INTEGER NOT NULL REFERENCES cliente(id),
    palavra_chave_id INTEGER REFERENCES palavra_chave(id),
    id_externo VARCHAR(255) NOT NULL, -- ID original da rede social
    autor VARCHAR(255),
    conteudo TEXT,
    url_post VARCHAR(500),
    data_postagem TIMESTAMP,
    likes INTEGER DEFAULT 0,
    compartilhamentos INTEGER DEFAULT 0,
    comentarios INTEGER DEFAULT 0,
    alcance_estimado INTEGER,
    localizacao VARCHAR(255),
    idioma VARCHAR(10),
    coletado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Processado'
);

-- Tabela de análise de sentimento
CREATE TABLE analise_sentimento (
    id SERIAL PRIMARY KEY,
    post_id INTEGER NOT NULL REFERENCES post(id),
    score_sentimento DECIMAL(3,2), -- -1.0 a 1.0
    classificacao VARCHAR(20), -- 'positivo', 'negativo', 'neutro'
    confianca DECIMAL(3,2), -- 0.0 a 1.0
    modelo_utilizado VARCHAR(100),
    emocoes_detectadas JSONB, -- {'alegria': 0.8, 'raiva': 0.1, ...}
    entidades_nomeadas JSONB, -- {'pessoas': [], 'organizacoes': [], 'locais': []}
    palavras_chave_extraidas JSONB,
    analisado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de alertas
CREATE TABLE alerta (
    id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL REFERENCES cliente(id),
    tipo_alerta VARCHAR(50), -- 'crise', 'tendencia', 'mencao_importante', 'sentimento_negativo'
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    severidade VARCHAR(20), -- 'baixa', 'media', 'alta', 'critica'
    post_id INTEGER REFERENCES post(id),
    dados_alerta JSONB,
    lido BOOLEAN DEFAULT false,
    acao_tomada TEXT,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    lido_em TIMESTAMP
);

-- Tabela de relatórios
CREATE TABLE relatorio (
    id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL REFERENCES cliente(id),
    tipo_relatorio VARCHAR(50), -- 'diario', 'semanal', 'mensal', 'personalizado'
    periodo_inicio DATE,
    periodo_fim DATE,
    titulo VARCHAR(255) NOT NULL,
    resumo_executivo TEXT,
    metricas JSONB, -- {'sentimento_medio': 0.65, 'total_posts': 1250, ...}
    insights TEXT,
    recomendacoes TEXT,
    arquivo_pdf VARCHAR(500),
    status VARCHAR(20) DEFAULT 'Gerado',
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    enviado_em TIMESTAMP
);

-- Tabela de configurações de monitoramento
CREATE TABLE configuracao_monitoramento (
    id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL REFERENCES cliente(id),
    redes_sociais JSONB, -- ['Twitter', 'Instagram', 'Facebook']
    frequencia_coleta INTEGER DEFAULT 15, -- minutos
    horario_inicio TIME DEFAULT '08:00:00',
    horario_fim TIME DEFAULT '18:00:00',
    filtros_geograficos JSONB,
    filtros_idioma JSONB,
    alertas_configuracao JSONB,
    ativo BOOLEAN DEFAULT true,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de métricas agregadas
CREATE TABLE metrica_agregada (
    id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL REFERENCES cliente(id),
    data_metrica DATE NOT NULL,
    rede_social_id INTEGER REFERENCES rede_social(id),
    total_posts INTEGER DEFAULT 0,
    sentimento_medio DECIMAL(3,2),
    posts_positivos INTEGER DEFAULT 0,
    posts_negativos INTEGER DEFAULT 0,
    posts_neutros INTEGER DEFAULT 0,
    alcance_total INTEGER DEFAULT 0,
    engajamento_medio DECIMAL(5,2),
    top_palavras_chave JSONB,
    top_influenciadores JSONB,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de logs de sistema
CREATE TABLE log_sistema (
    id SERIAL PRIMARY KEY,
    tipo_log VARCHAR(50), -- 'coleta', 'analise', 'alerta', 'erro'
    cliente_id INTEGER REFERENCES cliente(id),
    mensagem TEXT,
    dados_adicional JSONB,
    nivel VARCHAR(20), -- 'info', 'warning', 'error'
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Índices para otimização de performance
CREATE INDEX idx_post_cliente_data ON post(cliente_id, data_postagem);
CREATE INDEX idx_post_rede_social ON post(rede_social_id);
CREATE INDEX idx_analise_sentimento_post ON analise_sentimento(post_id);
CREATE INDEX idx_alerta_cliente_status ON alerta(cliente_id, lido);
CREATE INDEX idx_metrica_agregada_cliente_data ON metrica_agregada(cliente_id, data_metrica);
CREATE INDEX idx_palavra_chave_cliente ON palavra_chave(cliente_id, ativo);
