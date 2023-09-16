
package bancoDeDados;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class CriarBanco {


        // TODO code application logic here
        public void CriarBanco() throws SQLException{
        String url = (String) "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true"; // Substitua "nome_do_banco_de_dados" pelo nome real do banco
        final String usuario = "root";
        final String senha = "root";

        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        
        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java"); //comando sql
        
        System.out.println("banco criado com sucesso!!!");
        
        conexao.close();
        
        }
        
}
