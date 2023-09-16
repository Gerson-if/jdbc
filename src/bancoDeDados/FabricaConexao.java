
package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    
    
    public static Connection getConnection(){
     try {  
      String url = (String) "jdbc:mysql://localhost/curso_java?verifyServerCertificate=false&useSSL=true"; // Substitua "nome_do_banco_de_dados" pelo nome real do banco
        final String usuario = "root";
        final String senha = "root";

        return DriverManager.getConnection(url, usuario, senha);
    
      }
      catch(SQLException e){
          System.out.println("erro ao conectar ao banco de dados");
          throw new RuntimeException(e); //exeção nao checada
          
      }
        
    }
    
}
