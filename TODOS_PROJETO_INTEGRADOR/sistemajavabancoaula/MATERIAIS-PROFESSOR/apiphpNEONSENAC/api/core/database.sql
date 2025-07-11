CREATE TABLE public.usuario (
	usucodigo serial4 NOT NULL,
	usunome varchar(200) NOT NULL,
	usulogin varchar(200) NULL,
	ususenha varchar(200) NULL,
	usuemail varchar(200) NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (usucodigo)
);

CREATE TABLE public.produto (
	id serial4 NOT NULL,
	descricao varchar(300) NOT NULL,
	precocusto numeric(10, 2) NULL,
	precovenda numeric(10, 2) NULL,
	CONSTRAINT produto_pkey PRIMARY KEY (id)
);

CREATE TABLE pessoa (
    codigo serial NOT NULL,
    nome varchar(50) NOT NULL,
    endereco varchar(60) NULL,
    cpf varchar(20) NULL,
    CONSTRAINT pessoa_pkey PRIMARY KEY (codigo)
);

-- produtos
INSERT INTO public.produto
(id, descricao, precocusto, precovenda)
VALUES(1, 'ARROZ', 10.00, 15.00);
INSERT INTO public.produto
(id, descricao, precocusto, precovenda)
VALUES(2, 'FEIJÃO', 4.00, 7.00);
INSERT INTO public.produto
(id, descricao, precocusto, precovenda)
VALUES(3, 'CARNE DE FRANGO', 5.00, 8.00);

-- nao deixa duplicar o login
CREATE UNIQUE INDEX si_usulogin ON public.usuario USING btree (usulogin);

INSERT INTO public.usuario
(usunome, usulogin, ususenha, usuemail)
VALUES('admin', 'admin', '123456', 'admin@email.com');

INSERT INTO public.usuario
(usunome, usulogin, ususenha, usuemail)
VALUES('loja', 'loja', '123456', 'loja@email.com');

INSERT INTO public.usuario
(usunome, usulogin, ususenha, usuemail)
VALUES('caixa', 'caixa', '123456', 'caixa@email.com');

INSERT INTO public.usuario(usunome, usulogin, ususenha, usuemail)
VALUES('Gelvazio Camargo', 'gelvazio', '123456', 'gelvazio@email.com');

INSERT INTO public.usuario(usunome, usulogin, ususenha, usuemail)
VALUES('Lorenzo Cellarius', 'lorenzo', '123456', 'lorenzo@email.com');

INSERT INTO public.usuario(usunome, usulogin, ususenha, usuemail)
VALUES('Maico Cellarius', 'maico', '123456', 'maico@email.com');

INSERT INTO public.usuario(usunome, usulogin, ususenha, usuemail)
VALUES('Jessica Moratelli', 'jessica', '123456', 'jessica@email.com');

INSERT INTO public.usuario(usunome, usulogin, ususenha, usuemail)
VALUES('Aldo Rosario', 'aldo', '123456', 'aldo@email.com');

INSERT INTO public.usuario(usunome, usulogin, ususenha, usuemail)
VALUES('Taila Cellarius', 'taila', '123456', 'taila@email.com');

-- pessoas
INSERT INTO public.pessoa
(nome, endereco, cpf)
VALUES('Gelvazio', 'Estrada São Jose, Santana, 540, Rio do Sul, SC', '061.023.145-77');

INSERT INTO public.pessoa
(nome, endereco, cpf)
VALUES('Jessica', 'Estrada São Jose, Santana, 540, Rio do Sul, SC', '061.023.145-77');

INSERT INTO public.pessoa
(nome, endereco, cpf)
VALUES('Debora', 'Estrada São Jose, Santana, 540, Rio do Sul, SC', '061.023.145-77');

INSERT INTO public.pessoa
(nome, endereco, cpf)
VALUES('Taila', 'Estrada São Jose, Santana, 540, Rio do Sul, SC', '061.023.145-77');

INSERT INTO public.pessoa
(nome, endereco, cpf)
VALUES('Maico', 'Estrada São Jose, Santana, 540, Rio do Sul, SC', '061.023.145-77');

INSERT INTO public.pessoa
(nome, endereco, cpf)
VALUES('Aldo', 'Estrada São Jose, Santana, 540, Rio do Sul, SC', '061.023.145-77');