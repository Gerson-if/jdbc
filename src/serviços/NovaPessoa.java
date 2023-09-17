package serviços;

import bancoDeDados.FabricaConexao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

    public void cadastrarPessoa( String nome, int codigo) {

        try {
            
            String name = nome;
            int numero = codigo;

            Connection conexao = FabricaConexao.getConnection(); // criamos uma nova conection com o db

            String sql = "INSERT INTO pessoas (nome, codigo) VALUES (?, ?)"; // insrução sql
            PreparedStatement stmt = conexao.prepareStatement(sql); // prepapamos a intrução de forma segura
            stmt.setString(1, name); // passamos os parametros para essas duas funçoes das instruçoes sql
            stmt.setInt(2, numero);

            stmt.execute();

            System.out.println("Pessoa incluída com sucesso!");

        } catch (SQLException e) { //tratamento de erros
            System.out.println("Erro ao inserir pessoa: " + e.getMessage());
            throw new RuntimeException(e);

        }
    }
}
