
package aplicação;

import bancoDeDados.CriarBanco;
import bancoDeDados.CriarTabelaPessoas;
import bancoDeDados.FabricaConexao;
import serviços.NovaPessoa;
import java.sql.Connection;
import java.sql.SQLException;
import serviços.GerarListaDePessoas;

public class Program {
    
    public static void main(String[] args) throws SQLException {
        
        CriarBanco banco = new CriarBanco();
        FabricaConexao f = new FabricaConexao();
        CriarTabelaPessoas p = new CriarTabelaPessoas();
        NovaPessoa n = new NovaPessoa();
        GerarListaDePessoas g = new GerarListaDePessoas();
       
        //banco.CriarBanco();
        //p.CriarTabela();
       // n.cadastrarPessoa();
        g.gerarLista();
       
        
        
        
        
        
        
        
        
    }
   
}
