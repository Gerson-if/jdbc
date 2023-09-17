package aplicação;

import bancoDeDados.CriarBanco;
import bancoDeDados.CriarTabelaPessoas;
import bancoDeDados.FabricaConexao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import serviços.ConsultarPessoas;
import serviços.NovaPessoa;
import java.sql.Connection;
import java.util.InputMismatchException;
import serviços.PesquisarPessoa;

public class Menu {
    // atributos 

    Scanner sc = new Scanner(System.in);
    String clear = "ESC[2J";

    public void menu() {
        try {
            CriarBanco banco = new CriarBanco();
            CriarTabelaPessoas p = new CriarTabelaPessoas();
            NovaPessoa n = new NovaPessoa();
            ConsultarPessoas c = new ConsultarPessoas();
            PesquisarPessoa c2 = new PesquisarPessoa();
            

            int valor = 0;

            do {
                System.out.println("Precione enter para iniciar");
                sc.nextLine();
                System.out.println("      M E N U      ");
                System.out.println("-------------------");
                System.out.println(" 1 CRIAR BANCO DE DADOS ");
                System.out.println(" 2 CRIAR NOVA TABELA ");
                System.out.println(" 3 CADASTRAR PESSOA ");
                System.out.println(" 4 LISTAR TODAS AS PESSOAS ");
                System.out.println(" 5 PESQUISAR PESSOA");
                System.out.println(" 6 EDITAR PESSOAS ");
                System.out.println(" 7 SAIR ");
                System.out.print("OQUE DESEJA FAZER ? : ");
                valor = sc.nextInt();

                switch (valor) {

                    case 1:
                        try {
                        banco.CriarBanco();
                    } catch (SQLException e) {
                        System.out.println("erro ao criar Banco de dados ");

                    }

                    break;

                    case 2:
                    
                       try {
                        p.CriarTabela();
                    } catch (Exception e) {
                        System.out.println("Erro ao Criar tabela no banco de dados");
                        throw new RuntimeException(e);
                    }

                    break;

                    case 3:
                        try {
                        sc.nextLine();
                        System.out.print("Digite o nome da pessoa : ");
                        String nome = sc.nextLine();
                        System.out.print("Digite o codigo da pessoa: ");
                        int codigo = sc.nextInt();

                        n.cadastrarPessoa(nome, codigo);

                    } catch (IllegalStateException e) {

                        System.out.println("erro ao cadastrar pessoa");
                        e.printStackTrace();

                    }
                     

                    break;

                    case 4:

                        c.consultarPessoas();

                        break;

                    case 5:
                        try{ 
                        sc.nextLine();
                        System.out.print("pesquisar por : ");
                        String pesquisa = sc.nextLine();
                        c2.consultarPessoas(pesquisa);
                        }
                        catch(IllegalStateException e){
                            System.out.println("argumentos de pesquisa invalidos");
                            e.printStackTrace();
                        
                        }
                        break;

                    case 6:

                        break;
                        
                    case 7:
                        
                         valor = 7;
                         
                        break;

                }

              
            } while (valor != 7);

        } catch (IllegalStateException e) {
            System.out.println("voce digitou opçoes invalidas "
                    + e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("escolha um numero com a opçao desejeda nao letras");
            e.printStackTrace();
           

        } finally {
            try {
                if (sc != null) {
                    sc.close();
                }
            } catch (Exception e) {
                System.out.println("erro ao desalocar recursos");
                e.printStackTrace();
            }
        }
    }
}
