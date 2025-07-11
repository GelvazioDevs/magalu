/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import View.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelCadastro;
/**
 *
 * @author yasmi
 */
public class ControllerCadastroDB extends ControllerDBPadrao {

    private static final String
        sqlTodos = "select * from public.tbcadastro order by procodigo";

    public ArrayList<ModelCadastro> getTodos() {
        ArrayList listaDados = new ArrayList();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlTodos);

            while (rs.next()) {

                String nome = rs.getString ("cadnome");
                String telefone = rs.getString ("cadtelefone");
                String cpf = rs.getString ("cadcpf");
                String email = rs.getString ("cademail");
                String user = rs.getString ("cadusuario");
                String senha = rs.getString ("cadsenha");



                ModelCadastro cadastro = new ModelCadastro(nome,telefone,cpf,email,user,senha);

                listaDados.add(cadastro);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no sql, getTodos():\n" + erro.getMessage());
        } finally {
            Conexao.closeAll(conn);
        }
        return listaDados;
    }

    public boolean excluirProduto(int codigoProduto) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        boolean executou = false;

        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            pstmt = conn.prepareStatement("delete from tbproduto where procodigo = ?");
            pstmt.setInt(1, codigoProduto);
            pstmt.executeUpdate();

            executou = true;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }

        return executou;
    }

    public boolean gravarNovoCadastro(ModelCadastro cadastro) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        boolean executou = false;

        //TEM QUE FAZER A VALIDAÇÃO DAS SENHAS COMPATIVEIS

        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();

            pstmt = conn.prepareStatement
                (" insert into public.tbcadastropessoa "
                    + "(cadnome, cadtelefone, cadcpf, cademail, cadusuario, cadsenha) "
                    + "values(?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, cadastro.getNome());
            pstmt.setString(2, cadastro.getTelefone());
            pstmt.setString(3, cadastro.getCpf());
            pstmt.setString(4, cadastro.getEmail());
            pstmt.setString(5, cadastro.getUsuario());
            pstmt.setString(6, cadastro.getSenha());

            pstmt.executeUpdate();

            executou = true;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }

        return executou;
    }

}
