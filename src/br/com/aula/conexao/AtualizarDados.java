package br.com.aula.conexao;
//import para a conexão com o banco de dado 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarDados {
	public static void main(String[] args) {
		Connection conexao = ConexaoBD.conectar();//conecta com o banco 
		if (conexao != null) { //verificação da conexão
			String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?";
			Scanner scanner = new Scanner(System.in); //scanner para receber informção do usuario 
			
			try {
				//solicita os usuario o ID para atualizar
				System.out.println("Digite o ID do aluno que deseja atualizar: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				//atulização do nome 
				System.out.println("Digite o novo nome do aluno: ");
				String nome = scanner.nextLine();
				//atulização da idade 
				System.out.println("Digite a nova idade do aluno: ");
				int idade = scanner.nextInt();
				//cria um PreparedStatement para atulizar o banco no SQL
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.setInt(2, idade);
				stmt.setInt(3, id);
				//armazena o numero de linhas efetadas 
				int rowsUpdate = stmt.executeUpdate();
				
				//verifica se alguma linha foi alterada do banco 
				if(rowsUpdate > 0) {
					System.out.println("Registro atualizado com sucesso! ");
				} else {
					System.out.println("Nenhum registro encontrado com o ID especificado. ");
				}
			}catch (SQLException e) { //caso ocorra algum erro na execução 
				System.err.println("Erro ao atualizar dados: "+ e.getMessage());
			}finally {
				try {
					if(conexao != null ) conexao.close();
				}catch (SQLException e) { //caso acorra ao fechar a conexão
					System.err.println("Erro ao fechar conexão: " + e.getMessage());
				}
				scanner.close();
			}
		}
	}

}
