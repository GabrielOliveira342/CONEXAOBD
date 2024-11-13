package br.com.aula.conexao;
//import para conexão do banco de dados 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirDados {
	public static void main (String[] args) {
	Connection conexao = ConexaoBD.conectar();//estabelece conexão com o banco de dados 
		if(conexao != null) { //verifica a conexão 
		String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";//comando SQL
		try {
			// executar a consulta SQL de inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);
			//ja define os valores dos parametros
			stmt.setString(1, "João da Silva"); //nome
			stmt.setInt(2, 20);//idade 
			stmt.executeUpdate();// executa a inserção no banco de dados
			
			stmt.setString(1, "Maria Souza");
			stmt.setInt(2, 22);
			stmt.executeUpdate();
		
			stmt.setString(1, "Pedro Santos");
			stmt.setInt(2, 25);
			stmt.executeUpdate();
			
			System.out.println("Dados inseridos com sucessor!");//retorna mesnagem de sucesso
		} catch (SQLException e) {//caso ocorra erro em criar no banco de dados 
			System.err.println("Erro ao inserir dados: "+ e.getMessage());//erro no banco de dados 
		} finally {
			try {
				if(conexao != null) conexao.close();
			} catch (SQLException e) {//caso ocorra erro na conexão com o banco de dados 
				System.err.println("Erro ao fechar conexão: "+ e.getMessage());
			}
		}
	}
	}
}