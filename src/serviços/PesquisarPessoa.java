
package serviços;
import bancoDeDados.FabricaConexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import Entidades.Pessoa;



public class PesquisarPessoa {
     private PreparedStatement stmt = null;
     private Connection conexao = null;
     private ResultSet resultado = null;
     private String tes;
     public void consultarPessoas(String pesquisa){
         
         try {
             
             //logica da consulta sql 
             conexao = FabricaConexao.getConnection();
             String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";
             
             stmt = conexao.prepareStatement(sql);
             stmt.setString(1, "%" + pesquisa + "%");
             resultado = stmt.executeQuery();
             
             
             
             List<Pessoa> pessoa = new ArrayList<>();
               
             while (resultado.next()) {                 
                 String nome = resultado.getString("nome");
                 pessoa.add(new Pessoa(nome));
             }
              System.out.println("resultado da busca ");
             for (Pessoa p : pessoa) {
                 
                 System.out.println("nomes econtrados : " + p.getNome());
                 
             }
             
             
             
         } catch (SQLException e) {
             System.out.println("Erro na consulta da tabela  " + e.getMessage());
             System.out.println(resultado);
             throw new RuntimeException(e);
             
         }
     
     
     }
    
}
