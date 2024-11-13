package br.com.aula.conexao;
//import para conexão com o banco de dados 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	//define  informações de conexão com o banco de dados (URL, usuário e senha).
	private static final String URL = "jdbc:mysql://localhost:3306/aula_java_db";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	public static Connection conectar() { //metodo para a conexão do banco 
		Connection conexao = null;
		try {
			//carrega o driver JDBC necessario para conectar no banco 
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA); //realiza a conexão
			System.out.println("Conexão realizada com sucesso! ");
		} catch(ClassNotFoundException e) { //captura a exceção caso o driver JDBC não seja encontrado
			System.err.println("Driver não encontrado: " + e.getMessage());
		} catch (SQLException e) { //Captura qualquer exceção SQL
			System.err.println("Erro ao conectar: "+ e.getMessage());
		}
		return conexao;
		
		
	}
	//metodo para testar a conexão
	public static void main(String[]args) {
		conectar();//chama o metodo 
	}
}
