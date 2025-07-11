<?php

class ConexaoDBHeroku {

    const HOST = 'ec2-18-204-101-137.compute-1.amazonaws.com';
    const PORT = '5432';
    const DBNAME = 'd3gcuuncl1dsrp';
    const USER = 'zherahydsltxbg';
    const PASS = '8c3c7c4e916e003529d4ac1f5704e6801a5e05be7410b4a0bec9bf0fb28a9dd1';

    private static $conexao = null;

    public static function getInstance() {
        if (is_null(self::$conexao)) {
            self::conecta();
        }
        return self::$conexao;
    }

    public static function conecta() {
        if (is_null(self::$conexao)) {
            self::$conexao = pg_connect('host=' . self::HOST . ' port=' . self::PORT . ' dbname=' . self::DBNAME . ' user=' . self::USER . ' password=' . self::PASS);
            if (self::$conexao === false) {
                echo 'Erro ao comunicar com banco de dados!';
                throw new Exception('Erro ao comunicar com banco de dados!');
            }
        }
        return self::$conexao;
    }

    public static function desconecta() {
        $bFechou = true;
        if (!is_null(self::$conexao)) {
            $bFechou = pg_close(self::$conexao);
            self::$conexao = null;
        }
        return $bFechou;
    }

    public function __destruct() {
        self::desconecta();
    }

}