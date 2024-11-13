package br.com.aula.conexao;
//import para conexão com o banco de dados 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LerDados {
	public static void main(String[] args) {
		Connection conexao = ConexaoBD.conectar();//estabelece conexão com o banco de dados
		if(conexao != null) { //verifica conexão 
			String sql = "SELECT * FROM alunos"; //comando em SQL
			try {
				//prepara a consulta SQL utilizando o PreparedStatement
				PreparedStatement stmt = conexao.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();//exculta a consulta e armazena o resultado
				
				System.out.println("Registros de tabela 'aulnos': ");//mensagem indicando os registros 
				//recuperam os dados das colunas 'id', 'nome' e 'idade'  
				while (rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					int idade = rs.getInt("idade");
					//exibe os dados na tela 
					System.out.println("ID: "+id+", Nome: "+nome+ ", Idade: "+idade);
				}
			}catch (SQLException e) { //caso ocorra erro no banco de dados 
				System.err.println("Erro de ler dados: "+e.getMessage());
			}finally {
				try {
					if (conexao != null) conexao.close();
				} catch (SQLException e) {//caso ocorra erro na conexão com o banco de dados 
					System.err.println("Erro ao fechar conexão: "+ e.getMessage());
				}
			}
		}
	}

}
