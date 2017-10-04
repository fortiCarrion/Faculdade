package br.unifil.comp2028.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unifil.comp2028.Factory;
import br.unifil.comp2028.model.quarto;

public class quartoDAO implements GenericDAO<quarto> {

	@Override
	public void save(quarto objeto) {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into quarto values(?,?,?,?,?,?);");
		
		try {
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setInt(1, objeto.getIdQuarto());
			stmt.setString(2, objeto.getDescricao());
			stmt.setInt(3, objeto.getTipo().getIdTipo());
			stmt.setInt(4, objeto.getCapacidade());
			stmt.setDate(5, (Date) objeto.getCreate_time());
			stmt.setDate(6, (Date) objeto.getAlter_time());
	
			stmt.executeUpdate();
			stmt.close();
			
			System.out.println("quarto "+objeto.getIdQuarto()+" inserido :D");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erro");
			e.printStackTrace();
		}
		
	}

	@Override
	public void edit(quarto objeto) {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append("update quarto set idQuarto = ?, descricaoQuarto = ?, tipo = ?, capacidade = ?, create_time = ?, alter_time = ? ");
		sql.append("where idQuarto = ?;");
		
		try{
		Connection connection = Factory.createConnection();
		PreparedStatement stmt = connection.prepareStatement(sql.toString());
		
		stmt.setInt(1, objeto.getIdQuarto());
		stmt.setString(2, objeto.getDescricao());
		stmt.setInt(3, objeto.getTipo().getIdTipo());
		stmt.setInt(4, objeto.getCapacidade());
		stmt.setDate(5, new Date(objeto.getCreate_time().getTime()));
		stmt.setDate(6, new Date(objeto.getAlter_time().getTime()));
		
		stmt.executeUpdate(); //executar o código
		stmt.close(); //fechar conexão
				
		System.out.println("quarto com id "+objeto.getIdQuarto() +" atualizado :D");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erro");
			e.printStackTrace();
		}
		
	}

	@Override
	public quarto findOne(Long id) {
		// TODO Auto-generated method stub
		
		List<quarto> q = new ArrayList<>();
		quarto quarto;
		
		try {
			//select * from quarto where idQuarto = ?
			StringBuilder sql = new StringBuilder();
			sql.append("select * from visitante where idVisitante = ?;");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
	        
	        stmt.setLong(1, id);
			
	        //executar instrução
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()){
				tipoQuartoDAO dao = new tipoQuartoDAO();
				
	        	quarto = new quarto();
	        	quarto.setIdQuarto(resultSet.getInt("idQuarto"));
	        	quarto.setDescricao(resultSet.getString("descricaoQuarto"));
	        	quarto.setTipo(dao.findOne((long)resultSet.getInt("tipo")));
	        	quarto.setCapacidade(resultSet.getInt("capacidade"));
	        	quarto.setCreate_time(resultSet.getDate("create_time"));
	        	quarto.setAlter_time(resultSet.getDate("alter_time"));
	        	q.add(quarto);
			}
	        
	        stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return (br.unifil.comp2028.model.quarto) q;
		
	}

	@Override
	public List<quarto> findAll() {
		// TODO Auto-generated method stub
		
		List<quarto> q = new ArrayList<>();
		quarto quarto;
		
		try {
			//select * from quarto
			StringBuilder sql = new StringBuilder();
			sql.append("select * from visitante");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
	        //executar instrução
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()){
				tipoQuartoDAO dao = new tipoQuartoDAO();
				
				quarto = new quarto();
	        	quarto.setIdQuarto(resultSet.getInt("idQuarto"));
	        	quarto.setDescricao(resultSet.getString("descricaoQuarto"));
	        	quarto.setTipo(dao.findOne((long)resultSet.getInt("tipo")));
	        	quarto.setCapacidade(resultSet.getInt("capacidade"));
	        	quarto.setCreate_time(resultSet.getDate("create_time"));
	        	quarto.setAlter_time(resultSet.getDate("alter_time"));
	        	q.add(quarto);
			}
	        
	        stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return q;
		
		
	}

	@Override
	public boolean remove(quarto objeto) {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from quarto where idQuarto = ?;");
		
		try {
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setInt(1, objeto.getIdQuarto());
			
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
