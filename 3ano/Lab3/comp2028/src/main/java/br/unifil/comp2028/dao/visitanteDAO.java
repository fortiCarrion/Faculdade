package br.unifil.comp2028.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unifil.comp2028.Factory;
import br.unifil.comp2028.model.reserva;
import br.unifil.comp2028.model.visitante;

public class visitanteDAO implements GenericDAO<visitante> {

	private Connection connection;
	
	public visitanteDAO() throws SQLException {
		connection = Factory.createConnection();

	}

	@Override
	public void save(visitante objeto) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("insert into visitante values(?,?,?,?,?,?);");
		
		try {
			Connection connection = Factory.createConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sql.toString());
			
			prepareStatement.setInt(1, objeto.getIdVisitante());
			prepareStatement.setString(2, objeto.getNome());
			prepareStatement.setString(3, objeto.getTelefone());
			prepareStatement.setString(4, objeto.getEmail());
			prepareStatement.setDate(5, (Date) objeto.getCreate_time());
			prepareStatement.setDate(6, (Date) objeto.getAlter_time());
	
			prepareStatement.executeUpdate();
			prepareStatement.close();
			
			System.out.println("visitante "+objeto.getNome()+" inserido :D");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erro");
			e.printStackTrace();
		}
	}

	@Override
	public void edit(visitante objeto) {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append("update visitante set idVisitante = ?, nome = ?, telefone = ?, email = ?, create_time = ?, alter_time = ? ");
		sql.append("where codReserva = ?;");
		
		try{
		Connection connection = Factory.createConnection();
		PreparedStatement stmt = connection.prepareStatement(sql.toString());
		
		stmt.setInt(1, objeto.getIdVisitante());
		stmt.setString(2, objeto.getNome());
		stmt.setString(3, objeto.getTelefone());
		stmt.setString(4, objeto.getEmail());
		stmt.setDate(5, new Date(objeto.getCreate_time().getTime()));
		stmt.setDate(6, new Date(objeto.getAlter_time().getTime()));
		
		stmt.executeUpdate(); //executar o código
		stmt.close(); //fechar conexão
				
		System.out.println("visitante com id "+objeto.getIdVisitante() +" atualizado :D");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erro");
			e.printStackTrace();
		}
		
	}

	@Override
	public visitante findOne(Long id) {
		// TODO Auto-generated method stub
		
		List<visitante> v = new ArrayList<>();
		visitante visitante;
		
		try {
			//select * from visitante where idVisitante = ?
			StringBuilder sql = new StringBuilder();
			sql.append("select * from visitante where idVisitante = ?;");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
	        
	        stmt.setLong(1, id);
			
	        //executar instrução
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()){
	        	visitante = new visitante();
	        	visitante.setIdVisitante(resultSet.getInt("idVisitante"));
	        	visitante.setNome(resultSet.getString("nome"));
	        	visitante.setTelefone(resultSet.getString("telefone"));
	        	visitante.setEmail(resultSet.getString("email"));
	        	visitante.setCreate_time(resultSet.getDate("create_time"));
	        	visitante.setAlter_time(resultSet.getDate("alter_time"));
	        	v.add(visitante);
			}
	        
	        stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return (br.unifil.comp2028.model.visitante) v;
		
	}

	@Override
	public List<visitante> findAll() {
		// TODO Auto-generated method stub
		
		List<visitante> v = new ArrayList<>();
		visitante visitante;
		
		try {
			//select * from reserva;
			StringBuilder sql = new StringBuilder();
			sql.append("select * from reserva;");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
	        
			//executar instrução
			ResultSet resultSet = stmt.executeQuery();
	        while(resultSet.next()){
	        	visitante = new visitante();
	        	visitante.setIdVisitante(resultSet.getInt("idVisitante"));
	        	visitante.setNome(resultSet.getString("nome"));
	        	visitante.setTelefone(resultSet.getString("telefone"));
	        	visitante.setEmail(resultSet.getString("email"));
	        	visitante.setCreate_time(resultSet.getDate("create_time"));
	        	visitante.setAlter_time(resultSet.getDate("alter_time"));
	        	
	        	v.add(visitante);
	        }
	        stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return v;
		
	}

	@Override
	public boolean remove(visitante objeto) {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from visitante where idVisitante = ?;");
		
		try {
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setInt(1, objeto.getIdVisitante());
			
			stmt.executeUpdate(); //executar delete
			stmt.close(); //fechar conexão
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception	
			e.printStackTrace();
			return false;
		
		
	}

	}
}