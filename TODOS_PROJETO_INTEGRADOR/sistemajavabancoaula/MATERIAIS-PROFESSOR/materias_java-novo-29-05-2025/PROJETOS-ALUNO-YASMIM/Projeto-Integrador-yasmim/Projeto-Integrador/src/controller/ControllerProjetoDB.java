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
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.ModelProjeto;

/**
 *
 * @author yasmi
 */
public class ControllerProjetoDB extends ControllerDBPadrao{
      
        private static final String
        sqlTodos = "select * from public.tbprojeto";
    
    public ArrayList<ModelProjeto> getTodos() {
        ArrayList listaDados = new ArrayList();
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;        
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlTodos);
            
            while (rs.next()) {
                // Pega valor inteiro
                int codigo = rs.getInt("procodigo");
                int status = rs.getInt("prostatus");
                
                // Pega valores String(texto)
                String nome = rs.getString("pronome");
                String descricao = rs.getString("prodescricao");
                
                // pega valores de Data(dd/mm/aaaa)
                Date prazodate = rs.getDate("prodataprazo");
                Date entregadata = rs.getDate("prodataentrega");
                                
                ModelProjeto projeto = new ModelProjeto(codigo, nome, prazodate, entregadata, descricao, status);

                 
                listaDados.add(projeto);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no sql, getTodos():\n" + erro.getMessage());
        } finally {
            Conexao.closeAll(conn);
        }
        return listaDados;
    }
    
    public boolean excluirProduto(int codigoProjeto) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        boolean executou = false;
        
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            pstmt = conn.prepareStatement("delete from tbprojeto where procodigo = ?");
            pstmt.setInt(1, codigoProjeto);
            pstmt.executeUpdate();
            
            executou = true;            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        
        return executou;
    }
    
    
    public ModelProjeto getProjeto(int codigoProjeto) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ModelProjeto projetoBancoDados = new ModelProjeto();
        
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select procodigo,pronome, proprazoentrega, prodescricao "
                    + "from tbprojeto where procodigo = " + codigoProjeto);
            if(rs.next()) {
               int codigo = rs.getInt("procodigo");
                int status = rs.getInt("prostatus");
                
                // Pega valores String(texto)
                String nome = rs.getString("pronome");
                String descricao = rs.getString("prodescricao");
                
                // pega valores de Data(dd/mm/aaaa)
                Date prazodate = rs.getDate("prodataprazo");
                Date entregadata = rs.getDate("proprodataentrega");
                                
                                
                ModelProjeto projeto = new ModelProjeto(codigo, nome, prazodate, entregadata, descricao, status);

                
                projetoBancoDados = projeto;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        
        return projetoBancoDados;
    }
    
     public boolean gravarAlteracaoProjeto(ModelProjeto projeto) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        boolean executou = false;
          
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            
            pstmt = conn.prepareStatement
                (" update tbprojeto set "
                    + " pronome = ?,"
                    + " prodescricao = ?"
                    + " prodataprazo = ?"
                    + " where procodigo = ?");
            
            
            
            pstmt.setString(1, projeto.getPronome());
            pstmt.setString(2, projeto.getDescricao());
            pstmt.setDate (3, (java.sql.Date) projeto.getProdataprazo());
            
            
            pstmt.executeUpdate();
            
            executou = true;            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + erro);
        } finally {
            Conexao.closeAll(conn);
        }
        
        return executou;
    }
     
     public boolean gravarNovoProjeto(ModelProjeto projeto) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        boolean executou = false;
        
        try {
            conn = Conexao.getConexao();
            stmt = conn.createStatement();
            
            pstmt = conn.prepareStatement
                (" insert into tbprojeto "
                    + "(procodigo, pronome, prodataprazo, prodescricao) "
                    + "values(?, ?, ?, ?)");
            
            pstmt.setInt(1, projeto.getProcodigo());
            pstmt.setString(2, projeto.getDescricao());
            pstmt.setString(3, projeto.getPronome());
            pstmt.setDate(4, (java.sql.Date) projeto.getProdataprazo());
            
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
