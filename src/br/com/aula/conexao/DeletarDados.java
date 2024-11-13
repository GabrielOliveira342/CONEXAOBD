package br.com.aula.conexao;
//import para conexão do banco de dados 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarDados {
	public static void main(String[] args) {
		Connection conexao = ConexaoBD.conectar();//conecta com o banco de dados 
		if(conexao != null) { //verifica a conexão 
			String sql = "DELETE FROM alunos WHERE id = ?"; //SQL de exclusão
			Scanner scanner = new Scanner(System.in);
			try {
				//solicita o ID para ser deletado
				System.out.println("Digite o ID do aluno que deseja deletar: ");
				int id = scanner.nextInt();
				
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, id);// Define o valor do parâmetro 'id'
				//executa o comando de delete 
				int rowsDeleted = stmt.executeUpdate();
				
				if(rowsDeleted > 0 ) {//verifica se alguma linha foi excluida 
					System.out.println("Registro deletado com sucesso! "); //mensagem de sucesso
				} else {//caso id não seja encontradp
					System.out.println("Nenhum registro encontrado com o ID especificado. ");
				}
			}catch (SQLException e ) {//caso ocorra um erro no banco para excluir 
				System.err.println("Erro ao deletar dados: " +e.getMessage());
			}finally {
				try {
					if(conexao != null ) conexao.close();
				}catch (SQLException e) { //caso ocorra erro para conectar no banco de dados 
					System.err.println("Erro ao fechar conexão: "+ e.getMessage());
				}
				scanner.close();
			}
			
		}

	}

}
