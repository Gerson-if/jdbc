package serviços;

import bancoDeDados.FabricaConexao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

    public void cadastrarPessoa() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Informe um nome: ");
            String name = sc.nextLine();
            System.out.print("Informe um número: ");
            int numero = sc.nextInt();

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

        } finally {
            sc.close();
        }
    }
}
