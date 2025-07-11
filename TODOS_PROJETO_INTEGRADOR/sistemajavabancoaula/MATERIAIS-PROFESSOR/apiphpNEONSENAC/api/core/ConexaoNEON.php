<?php

class ConexaoNEON {

    // https://neon.tech/
    // gelvaziosenac2022@gmail.com
    const HOST = 'ep-jolly-night-actix78a-pooler.sa-east-1.aws.neon.tech';
    const PORT = '5432';
    const DBNAME = 'neondb';
    const USER = 'neondb_owner';
    const PASS = 'npg_eZ1YfzWS4VHg';

    private static $conexao = null;

    public static function getInstance() {
        if (is_null(self::$conexao)) {
            self::conecta();
        }
        return self::$conexao;
    }

    public static function conecta() {
        if (is_null(self::$conexao)) {
            $idProjeto = 'ep-jolly-night-actix78a-pooler';
            $conn = pg_connect("host=ep-jolly-night-actix78a-pooler.sa-east-1.aws.neon.tech
                    port=5432
                    dbname=neondb
                    user=neondb_owner
                    password=npg_eZ1YfzWS4VHg
                    sslmode=require
                    options='endpoint=$idProjeto'");

            self::$conexao = $conn;
            if (self::$conexao === false) {
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