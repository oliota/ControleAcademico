package br.com.controle.academico.rubem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoProway {

	private static String connectionUrl = "jdbc:sqlserver://localhost:52718;databaseName=EscolaProway;";
	private static String login = "admin";
	private static String senha = "123";
	public static Connection con;
	
	static public Connection ConectarBd() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Não há um drive JDBC adicionado no projeto");
			System.out.println("Download:");
			System.out.println(
					"https://docs.microsoft.com/pt-br/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15");
			System.out.println("Adiconar referencia ao projeto");
		}
		

		try {
			con= DriverManager.getConnection(connectionUrl, login, senha);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao conectar no banco de dados SQLSERVER, verifique a mensagem de erro acima");
			return null;
		}
	}

	static public ResultSet ConsultarBD( String sql) {
		Statement statement;
		try {
			statement = con.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao realizar a consulta no banco de dados");
			System.out.println("Sql utilizado:");
			System.out.println(sql);
			return null;
		} 
	}
	
	static public boolean ExecutarComandoBD(String sql) {
		Statement statement;
		try {
			statement = con.createStatement();
			statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}
}
