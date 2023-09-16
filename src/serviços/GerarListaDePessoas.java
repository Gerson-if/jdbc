
package serviços;

import bancoDeDados.FabricaConexao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class GerarListaDePessoas {
       //atributos
    private Connection conexao = null;
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public void gerarLista(){
        try {
            
            conexao = FabricaConexao.getConnection();
            String sql = "SELECT nome, codigo FROM pessoas;";
             stmt = conexao.createStatement(); // conexao com db
             rs = stmt.executeQuery(sql); // consulta no db usa a var sql
             stmt.execute(sql); // executa a instrução sql
             
             while (rs.next()) {  // Essa funcao gera uma lista do Db               
                String nome = rs.getString("nome"); 
                int codigo = rs.getInt("codigo");
                 System.out.println("Nome" + nome + ", Codigo " + codigo);
                 
            }
             
            
            
        } catch (SQLException e) { //tratamento de exeção
            
            System.out.println("erro ao listar " + e.getMessage());
            throw  new RuntimeException(e);
        }
        finally{ // metodo final desalocar recursos 
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) { // tratamento de erros caso de erro ao desalocar memoria
                System.out.println("Erro ao fechar recursos" + e.getMessage());
                
            }
        
        }
    
    
    
    }
    
    
}
