package br.unifil.comp2028.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unifil.comp2028.Factory;
import br.unifil.comp2028.model.user;

public class userDAO implements GenericDAO<user> {

	@Override
	public void save(user objeto) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("insert into user values(?,?);");

		try {
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setString(1, objeto.getUsername());
			stmt.setString(2, objeto.getPassword());

			stmt.executeUpdate();
			stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erro");
			e.printStackTrace();
		}
	}

	@Override
	public void edit(user objeto) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("update user set username = ?, password = ? where username = ?;");
		
		try {
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setString(1, objeto.getUsername());
			stmt.setString(2, objeto.getPassword());
			stmt.setString(3, objeto.getUsername());
			
			stmt.executeQuery();
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erro");
			e.printStackTrace();
		}

	}
	
	@Override
	/**
	 * Método não implementado pois ainda não temos um campo sendo para userId.
	 */
	public user findOne(Long id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public user findOne(String username){
		List<user> u = new ArrayList<>();
		user user;
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select * from user where username = ?;");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setString(1, username);
			
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()){
				user = new user();
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				u.add(user);
			}
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		return null;
		
	}
	
	@Override
	public List<user> findAll() {
		// TODO Auto-generated method stub
		List<user> u = new ArrayList<>();
		user user;
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select * from user;");
			
			Connection connetion = Factory.createConnection();
			PreparedStatement stmt = connetion.prepareStatement(sql.toString());
			
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()){
				user = new user();
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				u.add(user);
			}
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erro");
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public boolean remove(user objeto) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("delete from user where username = ?;");
		
		try {
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setString(1, objeto.getUsername());
			
			stmt.executeUpdate(); //executar delete
			stmt.close(); //fechar conexão
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erro");
			e.printStackTrace();
			
			return false;
		}
		
	}
}
