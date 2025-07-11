package View;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {

    private static final String DRIVER   = "org.postgresql.Driver";
    private static final String BANCO    = "postgres";
    private static final String CONEXAO  = "jdbc:postgresql://db.znohddxhjszyuqysouny.supabase.co/" + BANCO;
    private static final String USUARIO  = "postgres";
    private static final String SENHA    = "SENAC2022PROJ";

    public static void main(String args[]) {
        // testa ConexaoBanco
        //#BANCO DE DADOS LOCAL
        //#spring.datasource.url= jdbc:postgresql://localhost:5432/postgres
        //#spring.datasource.username= postgres
        //#spring.datasource.password= postgres
        
        //#ELEPHANTSQL
        //#spring.datasource.url= jdbc:postgresql://motty.db.elephantsql.com:5432/dfgxpned
        //#spring.datasource.username= dfgxpned
        //#spring.datasource.password= Qn0rrW9uSnJ4ZioM7CmZUKaZGXsH1hnj

        // SUPABASE
        String driver  = "org.postgresql.Driver";
        String url     = "jdbc:postgresql://db.znohddxhjszyuqysouny.supabase.co/postgres";
        String usuario = "postgres";
        String senha   = "SENAC2022PROJ";

        String lista_dados = "";
        String lista_dados_json = "";

        Connection conexao;
        Statement statement;
        ResultSet resultset;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conectou com o PostgreSQL!");

            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                                ResultSet.CONCUR_READ_ONLY);

            resultset = statement.executeQuery("select * from tblogin limit 50");

            while (resultset.next()) {
                String id       = resultset.getString("logusuario");
                String name  = resultset.getString("logsenha");
               

                lista_dados_json = lista_dados_json + "{" +
                        "\"id\":\"" + id +"\"," +
                        "\"name\":\"" + name +"\"," +
                        "}";
            }
            System.out.println(lista_dados);
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver não localizado: " + Driver);
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null, "Deu erro na conexão com a fonte de dados: " + Fonte);
        }
    }

    public static Connection getConexao() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(CONEXAO, USUARIO, SENHA);
        } catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Erro de driver! \n" + erro.getMessage());
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de Conexão! \n" + erro.getMessage());
        }
        return conn;
    }

    public static void closeAll(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão! \n " + erro.getMessage());
        }
    }
}
