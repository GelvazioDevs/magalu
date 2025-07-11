/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import View.Conexao;
import javax.swing.JOptionPane;
/**
 *
 * @author yasmi
 */
public class ControllerDBPadrao {
    
    public int getUltimoCodigo(String tabela, String coluna) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int codigo = 0;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            String sequence = tabela + "_" + coluna + "_seq";
            rs = stmt.executeQuery("select nextval('public." + sequence + "') as codigo");
            while (rs.next()) {
                codigo = rs.getInt("codigo");
            }
        } catch (SQLException erro) {
            System.out.println("Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        return codigo;
    }
    
     public int getUsuario(String tabela, String coluna) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int user = 0;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            String sequence = tabela + "_" + coluna + "_seq";
            rs = stmt.executeQuery("select cadusuario as usuario from tbcadastro");
            if (rs.next()) {
                user = rs.getInt("");
            } else {
                JOptionPane.showMessageDialog(null,"Nome de Usuário já existente");
            }
        } catch (SQLException erro) {
            System.out.println("Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        return user;
    }
    
}
