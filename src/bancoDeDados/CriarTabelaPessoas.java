
package bancoDeDados;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class CriarTabelaPessoas {
    //atributos
     private Connection conexao = null;
    
    
    public  void CriarTabela(){
     try{   
         
    conexao = FabricaConexao.getConnection();
    
   // String sql = "DROP TABLE pessoas;";
   String sql = " CREATE TABLE IF NOT EXISTS pessoas("
            + "codigo INT AUTO_INCREMENT PRIMARY KEY,"
            + "nome VARCHAR(80) NOT NULL,"
           + "CONSTRAINT nome_unico UNIQUE (nome)"
            + ");";
    
    Statement stmt = conexao.createStatement();
    
    stmt.execute(sql);
    
    System.out.println("tabela crida com sucesso");
    }
    catch(Exception e){
       throw new RuntimeException(e);
        
    }
    finally{
         try {
             if (conexao != null) {
                 
                 conexao.close();
             }
             
         } catch (SQLException e) {
             System.out.println("erro ao fechar a conexao");
             throw new RuntimeException(e);
         }
     
    
    }
    
    }

}
