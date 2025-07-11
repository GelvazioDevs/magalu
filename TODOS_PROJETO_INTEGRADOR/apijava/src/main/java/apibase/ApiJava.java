package apibase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiJava {

	public static void main(String[] args) {
		SpringApplication.run(ApiJava.class, args);		
	}	
}

// Rotas para programar
// - Listar todos os clientes: GET /api/v1/cliente
// - Inserir um novo cliente: POST /api/v1/cliente
// - Atualizar um cliente: PUT /api/v1/cliente/{id}
// - Deletar um cliente: DELETE /api/v1/cliente/{id}

// - Listar todos os produtos: GET /api/v1/produto
// - Inserir um novo produto: POST /api/v1/produto
// - Atualizar um produto: PUT /api/v1/produto/{id}
// - Deletar um produto: DELETE /api/v1/produto/{id}
// - Buscar um produto por ID: GET /api/v1/produto/{id}

// - Listar todos os usuários: GET /api/v1/usuario
// - Inserir um novo usuário: POST /api/v1/usuario
// - Atualizar um usuário: PUT /api/v1/usuario/{id}
// - Deletar um usuário: DELETE /api/v1/usuario/{id}
// - Buscar um usuário por ID: GET /api/v1/usuario/{id}
// - Criar a rota de Login do usuario: POST /api/v1/usuario/login

// - Listar todas as regiões: GET /api/v1/regiao
// - Inserir uma nova região: POST /api/v1/regiao
// - Atualizar uma região: PUT /api/v1/regiao/{id}	
// - Deletar uma região: DELETE /api/v1/regiao/{id}
// - Buscar uma região por ID: GET /api/v1/regiao/{id}
// - Buscar uma região por descricao: GET /api/v1/regiao/descricao/{descricao}

// - Listar todas as cidades: GET /api/v1/cidade
// - Inserir uma nova cidade: POST /api/v1/cidade
// - Atualizar uma cidade: PUT /api/v1/cidade/{id}
// - Deletar uma cidade: DELETE /api/v1/cidade/{id}
// - Buscar uma cidade por ID: GET /api/v1/cidade/{id}

// - Buscar uma cidade por descricao: GET /api/v1/cidade/descricao/{descricao}
// - Buscar uma cidade por uf: GET /api/v1/cidade/uf/{uf
// - Buscar uma cidade por regiao_id: GET /api/v1/cidade/regiao/{regiao_id}
// - Buscar uma cidade por descricao e uf: GET /api/v1/cidade/descricao/{descricao}/uf/{uf}

// - Listar  todos os vendedores: GET /api/v1/vendedor
// - Inserir um novo vendedor: POST /api/v1/vendedor
// - Atualizar um vendedor: PUT /api/v1/vendedor/{id}
// - Deletar um vendedor: DELETE /api/v1/vendedor/{id}
// - Buscar um vendedor por ID: GET /api/v1/vendedor/{id}

// FATURAMENTOS
// - Listar todos os pedidos: GET /api/v1/pedido
// - Inserir um novo pedido: POST /api/v1/pedido
// - Atualizar um pedido: PUT /api/v1/pedido/{id}
// - Deletar um pedido: DELETE /api/v1/pedido/{id}
// - Buscar um pedido por ID: GET /api/v1/pedido/{id}

// Listar todas as notas de entrada: GET /api/v1/notaentrada
// Inserir uma nova nota de entrada: POST /api/v1/notaentrada
// Atualizar uma nota de entrada: PUT /api/v1/notaentrada/{id}
// Deletar uma nota de entrada: DELETE /api/v1/notaentrada/{id}
// Buscar uma nota de entrada por ID: GET /api/v1/notaentrada/{id}

// Listar todas as notas de venda: GET /api/v1/venda 
// Inserir uma nova nota de venda: POST /api/v1/venda
// Atualizar uma nota de venda: PUT /api/v1/venda/{id}
// Deletar uma nota de venda: DELETE /api/v1/venda/{id}
// Buscar uma nota de venda por ID: GET /api/v1/venda/{id}

// Listar todas as contas a pagar: GET /api/v1/contapagar
// Inserir uma nova conta a pagar: POST /api/v1/contapagar
// Atualizar uma conta a pagar: PUT /api/v1/contapagar/{id}
// Deletar uma conta a pagar: DELETE /api/v1/contapagar/{id}
// Buscar uma conta a pagar por ID: GET /api/v1/contapagar/{id}
// Listar um contas a pagar por cliente: GET /api/v1/contapagar/cliente/{id}

// - Listar todas as contas a receber: GET /api/v1/contareceber
// - Inserir uma nova conta a receber: POST /api/v1/contareceber
// - Atualizar uma conta a receber: PUT /api/v1/contareceber/{id}
// - Deletar uma conta a receber: DELETE /api/v1/contareceber/{id}
// - Buscar uma conta a receber por ID: GET /api/v1/contareceber/{id}
// - Listar um contas a receber por cliente: GET /api/v1/contareceber/cliente/{id}

// Executar uma baixa de uma conta a pagar: POST /api/v1/contapagar/baixa/{id}
// Executar uma baixa de uma conta a receber: POST /api/v1/contareceber/baixa/{id}

// Relatorios
// - Listar todos os relatorios disponiveis: GET /api/v1/relatorio

// - Listar relatorio de vendas por vendedor: GET /api/v1/relatorio/vendas/vendedor/{id}
// - Listar relatorio de vendas por cliente: GET /api/v1/relatorio/vendas/cliente/{id}
// - Listar relatorio de vendas por produto: GET /api/v1/relatorio/vendas/produto/{id}
// - Listar relatorio de vendas por periodo: GET /api/v1/relatorio/vendas/periodo/{dataInicial}/{dataFinal}

// - Listar relatorio de compras por fornecedor: GET /api/v1/relatorio/compras/fornecedor/{id}
// - Listar relatorio de compras por produto: GET /api/v1/relatorio/compras/produto/{id}
// - Listar relatorio de compras por periodo: GET /api/v1/relatorio/compras/periodo/{dataInicial}/{dataFinal}

// - Listar relatorio de contas a pagar por fornecedor: GET /api/v1/relatorio/contasapagar/fornecedor/{id}
// - Listar relatorio de contas a pagar por periodo: GET /api/v1/relatorio/contasapagar/periodo/{dataInicial}/{dataFinal}
// - Listar relatorio de contas a pagar por vencimento: GET /api/v1/relatorio/contasapagar/vencimento/{dataVencimento}
// - Listar relatorio de contas a pagar por produto: GET /api/v1/relatorio/contasapagar/produto/{id}

// - Listar relatorio de contas a receber por cliente: GET /api/v1/relatorio/contasareceber/cliente/{id}
// - Listar relatorio de contas a receber por periodo: GET /api/v1/relatorio/contasareceber/periodo/{dataInicial}/{dataFinal}
// - Listar relatorio de contas a receber por vendedor: GET /api/v1/relatorio/contasareceber/vendedor/{id}
// - Listar relatorio de contas a receber por produto: GET /api/v1/relatorio/contasareceber/produto/{id}
// - Listar relatorio de contas a receber por vencimento: GET /api/v1/relatorio/contasareceber/vencimento/{dataVencimento}

// - Listar todos os usuarios ativos: GET /api/v1/usuario/ativos
// - Listar todos os usuarios inativos: GET /api/v1/usuario/inativos
// - Listar todos os usuarios bloqueados: GET /api/v1/usuario/bloqueados


