	package br.unifil.comp2028;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	
	import br.unifil.comp2028.model.user;
	
	public class Factory {
	
		private static String DATABASE = "HotelDB";
		private static String url = "jdbc:mysql://localhost:3306/"+ DATABASE;
		private static String user = "root";
		private static String senha = "";
		
		public static Connection createConnection() throws SQLException {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conexao = DriverManager.getConnection(url, user ,senha);
			return conexao;
		}
	}
