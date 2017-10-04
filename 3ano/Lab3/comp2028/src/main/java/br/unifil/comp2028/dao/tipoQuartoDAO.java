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
import br.unifil.comp2028.model.tipo_quarto;

public class tipoQuartoDAO implements GenericDAO<tipo_quarto> {

	@Override
	public void save(tipo_quarto objeto) {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into tipo_quarto values(?,?,?,?,?);");
		
		try {
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setInt(1, objeto.getIdTipo());
			stmt.setString(2, objeto.getDescricao());
			stmt.setDate(3, (Date) objeto.getCreate_time());
			stmt.setDate(4, (Date) objeto.getAlter_time());
			stmt.setString(5, objeto.getValor());
			
			stmt.executeUpdate();
			stmt.close();
			
			System.out.println("tipoQuarto "+objeto.getIdTipo()+" inserido :D");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erro");
			e.printStackTrace();
		}
		
	}

	@Override
	public void edit(tipo_quarto objeto) {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append("update tipo_quarto set idTipo = ?, descricao = ?, create_time = ?, alter_time = ?, valor = ?;");
		
		try {
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setInt(1, objeto.getIdTipo());
			stmt.setString(2, objeto.getDescricao());
			stmt.setDate(3, (Date) objeto.getCreate_time());
			stmt.setDate(4, (Date) objeto.getAlter_time());
			stmt.setString(5, objeto.getValor());
			
			stmt.executeUpdate();
			stmt.close();
			
			System.out.println("tipoQuarto "+objeto.getIdTipo()+" atualizado :D");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erro");
			e.printStackTrace();
		}
		
	}

	@Override
	public tipo_quarto findOne(Long id) {
		// TODO Auto-generated method stub
		
		List<tipo_quarto> tq = new ArrayList<>();
		tipo_quarto tipo_quarto;
		
		try {
			//select * from tipo_quarto where idTipo = ?
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tipo_quarto where idTipo = ?;");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
	        
	        stmt.setLong(1, id);
			
	        //executar instrução
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()){
	        	tipo_quarto = new tipo_quarto();
	        	tipo_quarto.setIdTipo(resultSet.getInt("idTipo"));
	        	tipo_quarto.setDescricao(resultSet.getString("descricaoQuarto"));
	        	tipo_quarto.setCreate_time(resultSet.getDate("create_time"));
	        	tipo_quarto.setAlter_time(resultSet.getDate("alter_time"));
	        	tipo_quarto.setValor(resultSet.getString("valor"));
	        	tq.add(tipo_quarto);
			}
	        
	        stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return (br.unifil.comp2028.model.tipo_quarto) tq;
		
	}

	@Override
	public List<tipo_quarto> findAll() {
		// TODO Auto-generated method stub
		
		List<tipo_quarto> tq = new ArrayList<>();
		tipo_quarto tipo_quarto;
		
		try {
			//select * from tipo_quarto;
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tipo_quarto ;");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
	        
			
	        //executar instrução
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()){
	        	tipo_quarto = new tipo_quarto();
	        	tipo_quarto.setIdTipo(resultSet.getInt("idTipo"));
	        	tipo_quarto.setDescricao(resultSet.getString("descricaoQuarto"));
	        	tipo_quarto.setCreate_time(resultSet.getDate("create_time"));
	        	tipo_quarto.setAlter_time(resultSet.getDate("alter_time"));
	        	tipo_quarto.setValor(resultSet.getString("valor"));
	        	tq.add(tipo_quarto);
			}
	        
	        stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return tq;
		
	}

	@Override
	public boolean remove(tipo_quarto objeto) {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from tipo_quarto where idTipo = ?;");
		
		try {
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setInt(1, objeto.getIdTipo());
			
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