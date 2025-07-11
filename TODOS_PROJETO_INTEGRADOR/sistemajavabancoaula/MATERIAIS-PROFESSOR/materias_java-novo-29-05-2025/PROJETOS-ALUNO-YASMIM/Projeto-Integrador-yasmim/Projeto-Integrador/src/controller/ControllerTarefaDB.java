package controller;

import View.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ModelTarefa;
//import model.ModelItem;
//import view.Conexao;

/**
 *
 * @author Gelvazio Camargo
 */
public class ControllerTarefaDB {

    private static final String
        sqlTodos = "select * from public.tbtarefa";

    public ArrayList<ModelTarefa> getTodasTarefaPorStatus(int status) {
        ArrayList listaDados = new ArrayList();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            String sqlTarefasPorStatus = "select * from public.tbtarefa where status = " + status;

            rs = stmt.executeQuery(sqlTarefasPorStatus);

            while (rs.next()) {
                // Pega valor inteiro
                int codigo = rs.getInt("codigo");
                String Descricao = rs.getString("descricao");
                int procodigo = rs.getInt("procodigo");
                status = rs.getInt("status");

                ModelTarefa tasks = new ModelTarefa(codigo, Descricao, procodigo, status);
               listaDados.add(tasks);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no sql, getTodasTarefaPorStatus():\n" + erro.getMessage());
        } finally {
            Conexao.closeAll(conn);
        }
        return listaDados;
    }
//public ArrayList getTodos() {
//        ArrayList listaDados = new ArrayList();
//        
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        
//        try {
//            conn = Conexao.getConexao();
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sqlTodos);
//            
//            while (rs.next()) {
//                // Pega valor inteiro
//                int codigo = rs.getInt("pescodigo");
//                
//                // Pega valores String(texto)
//                String nome = rs.getString("pesnome");
//                String endereco = rs.getString("pesendereco");
//                String cpf = rs.getString("pescpf");
//                
//                
//                ModelPessoa pessoa = new ModelPessoa(codigo, nome, endereco, cpf);
//                
//                listaDados.add(pessoa);
//            }
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro no sql, getTodos():\n" + erro.getMessage());
//        } finally {
//            Conexao.closeAll(conn);
//        }
//        return listaDados;
//    }

}
