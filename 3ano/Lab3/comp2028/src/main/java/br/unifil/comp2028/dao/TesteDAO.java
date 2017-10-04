package br.unifil.comp2028.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unifil.comp2028.Factory;
import br.unifil.comp2028.model.Teste;

public class TesteDAO {

	public boolean inserir(Teste teste){
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("insert into teste values( ? , ? );");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setInt(1, teste.getId());
	        stmt.setString(2, teste.getName());
	        stmt.executeUpdate();
	        stmt.close();
	        return true;
	        
		} catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Teste teste){
		
		try{
			StringBuilder sql = new StringBuilder();
			sql.append("update teste set value = ? where id = ?");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setString(1, teste.getName());
	        stmt.setInt(2,teste.getId());
	        stmt.executeUpdate();
	        stmt.close();
	        return true;
	        
		} catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(int id){

		try{
			StringBuilder sql = new StringBuilder();
			sql.append("delete from teste where id = ?");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
	        stmt.setInt(1,id);
	        stmt.executeUpdate();
	        stmt.close();
	        return true;
	        
		} catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	public List<Teste> testes(){
		List<Teste> t = new ArrayList<>();
		Teste teste;
		
		
		try {
			//select * from teste;
			StringBuilder sql = new StringBuilder();
			sql.append("select * from teste");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
	        ResultSet resultSet = stmt.executeQuery();
	        
	        while(resultSet.next()){
	        	teste = new Teste();
	        	teste.setId(resultSet.getInt("id"));
	        	teste.setName(resultSet.getString("value"));
	        	t.add(teste);
	        }
	        
	        stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return t;
	}
}

