
package aplicação;

import bancoDeDados.CriarBanco;
import bancoDeDados.CriarTabelaPessoas;
import bancoDeDados.FabricaConexao;
import serviços.NovaPessoa;
import java.sql.Connection;
import java.sql.SQLException;
import serviços.ConsultarPessoas;

public class Program {
    
    public static void main(String[] args) {
        
        try{
        CriarBanco banco = new CriarBanco();
        FabricaConexao f = new FabricaConexao();
        CriarTabelaPessoas p = new CriarTabelaPessoas();
        NovaPessoa n = new NovaPessoa();
        ConsultarPessoas c = new ConsultarPessoas();
        
       
        banco.CriarBanco();
        p.CriarTabela();
        n.cadastrarPessoa();
        c.consultarPessoas();
        
        }
        catch(SQLException e){
            System.out.println("erro ao executar programa");
            throw new RuntimeException(e);
        }
        finally{
            try {
                
            } catch (Exception e) {
                System.out.println("erro ao desalocar recursos");
                e.printStackTrace();
            }
        
        
        }
        
        
       
        
        
        
        
        
        
        
        
    }
   
}
