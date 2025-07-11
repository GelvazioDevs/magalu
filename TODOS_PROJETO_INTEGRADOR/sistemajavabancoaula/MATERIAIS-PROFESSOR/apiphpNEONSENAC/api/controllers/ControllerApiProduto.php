<?php
use \Psr\Http\Message\ServerRequestInterface as Request;
use Psr\Http\Message\ResponseInterface as Response;

/**
 * Chamada da api Produto
 *
 * User: Gelvazio Camargo
 * Date: 10/12/2020
 * Time: 17:40
 */
require_once("ControllerApiBase.php");
class ControllerApiProduto extends ControllerApiBase {

    public function getProduto(Request $request, Response $response, array $args) {
        $sSql = "SELECT * FROM produto ORDER BY id";
        $aDados = $this->getQuery()->selectAll($sSql);
        return $response->withJson($aDados, 200);
    }

    public function getConsultaProduto(Request $request, Response $response, array $args) {
        $sSql = "SELECT * FROM produto ORDER BY procodigo";
        $aDados = $this->getQuery()->selectAll($sSql);
        return $response->withJson($aDados, 200);
    }
}