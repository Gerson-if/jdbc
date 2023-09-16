
package serviços;
import Entidades.Pessoa;
import bancoDeDados.FabricaConexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas {
     //atributos
     private Connection conexao = null;
     private Statement stmt = null;
     private ResultSet resultado = null;
    
    
    
    
    public void consultarPessoas(){
        try {
            conexao = FabricaConexao.getConnection();
            String sql = "SELECT * FROM pessoas;";
            
            stmt = conexao.createStatement();
            resultado = stmt.executeQuery(sql);
            
            List<Pessoa> pessoas = new ArrayList<>(); //criamos aqui um array de pessoas uma lista do tipo Pessoas
            
            while (resultado.next()) { // o metodo next(), retona true ou false depois de percorrer toda a lista               
                int codigo = resultado.getInt("codigo");
                String nome = resultado.getString("nome");
                pessoas.add(new Pessoa(codigo, nome)); //aqui criamos uma nova, passando os parametros para o construtor
                  
            }
            System.out.println("Executando consulta ");
            
            for (Pessoa p : pessoas) { //aqui usamos um for ech
                System.out.println(p.getCodigo() + " ==> " + p.getNome());
                
            }
            
            
        } catch (SQLException e) {
            System.out.println("erro ao executar consulta");
            throw new RuntimeException(e);
        }
        finally{ //desalocando recursos
            try {
                if (conexao != null) {
                    
                  conexao.close();
                }
                if (stmt != null) {
                    
                  stmt.close();
                }
                if (resultado != null) {
                    
                   resultado.close();
                }
                
            } catch (SQLException e) {
                System.out.println("erro ao fechar conexao");
                throw  new RuntimeException(e);
            }
        
        
        }
  
       
        
     
    }

    
}
