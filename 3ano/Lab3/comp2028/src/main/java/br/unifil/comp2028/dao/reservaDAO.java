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

public class reservaDAO implements GenericDAO<reserva> {

	@Override
	public void save(reserva objeto) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("insert into reserva values(?,?,?,?,?,?,?,?,?);");
		
		try {
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setInt(1, objeto.getCodReserva());
			stmt.setInt(2, objeto.getIdQuarto());
			stmt.setDate(3, new Date(objeto.getData_entrada().getTime()));
			stmt.setDate(4, new Date(objeto.getData_saida().getTime()));
			stmt.setString(5, objeto.getPagamento());
			stmt.setString(6, objeto.getStatus());
			stmt.setDate(7, new Date(objeto.getCreate_time().getTime()));
			stmt.setDate(8, new Date(objeto.getAlter_time().getTime()));
			stmt.setInt(9, objeto.getCodReserva());
				
			stmt.executeUpdate();
			stmt.close();
			
			System.out.println("reserva número "+ objeto.getCodReserva() +" inserido :D");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erro");
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void edit(reserva objeto) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("update reserva set idVisitante = ?, idQuarto = ?, data_entrada = ?, entrada_saida = ?, pagamento = ?,");
		sql.append("status = ?, create_time= ?, alter_time = ?");
		sql.append("where codReserva = ?;");
		
		try{
		Connection connection = Factory.createConnection();
		PreparedStatement stmt = connection.prepareStatement(sql.toString());
		
		stmt.setInt(1, objeto.getIdVisitante());
		stmt.setInt(2, objeto.getIdQuarto());
		stmt.setDate(3, new Date(objeto.getData_entrada().getTime()));
		stmt.setDate(4, new Date(objeto.getData_saida().getTime()));
		stmt.setString(5, objeto.getPagamento());
		stmt.setString(6, objeto.getStatus());
		stmt.setDate(7, new Date(objeto.getCreate_time().getTime()));
		stmt.setDate(8, new Date(objeto.getAlter_time().getTime()));
		stmt.setInt(9, objeto.getCodReserva());
		
		stmt.executeUpdate(); //executar o código
		stmt.close(); //fechar conexão
				
		System.out.println("reserva "+objeto.getCodReserva() +" atualizado :D");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public reserva findOne(Long id) {
		// TODO Auto-generated method stub
		List<reserva> r = new ArrayList<>();
		reserva reserva;
		
		try {
			//select * from reserva where id = ?
			StringBuilder sql = new StringBuilder();
			sql.append("select * from reserva where codReserva = ?;");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
	        
	        stmt.setLong(1, id);
			
	        //executar instrução
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()){
	        	reserva = new reserva();
	        	reserva.setCodReserva(resultSet.getInt("codReserva"));
	        	reserva.setIdVisitante(resultSet.getInt("idVisitante"));
	        	reserva.setIdQuarto(resultSet.getInt("idQuarto"));
	        	reserva.setData_entrada(resultSet.getDate("data_entrada"));
	        	reserva.setData_saida(resultSet.getDate("data_saida"));
	        	reserva.setPagamento(resultSet.getString("pagamento"));
	        	reserva.setStatus(resultSet.getString("status"));
	        	reserva.setCreate_time(resultSet.getDate("create_time"));
	        	reserva.setAlter_time(resultSet.getDate("alter_time"));
	        	r.add(reserva);
			}
	        
	        stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return (br.unifil.comp2028.model.reserva) r;
	}

	@Override
	public List<reserva> findAll() {
		// TODO Auto-generated method stub
		List<reserva> r = new ArrayList<>();
		reserva reserva;
		
		try {
			//select * from reserva;
			StringBuilder sql = new StringBuilder();
			sql.append("select * from reserva;");
			
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
	        
			//executar instrução
			ResultSet resultSet = stmt.executeQuery();
	        while(resultSet.next()){
	        	reserva = new reserva();
	        	reserva.setCodReserva(resultSet.getInt("codReserva"));
	        	reserva.setIdVisitante(resultSet.getInt("idVisitante"));
	        	reserva.setIdQuarto(resultSet.getInt("idQuarto"));
	        	reserva.setData_entrada(resultSet.getDate("data_entrada"));
	        	reserva.setData_saida(resultSet.getDate("data_saida"));
	        	reserva.setPagamento(resultSet.getString("pagamento"));
	        	reserva.setStatus(resultSet.getString("status"));
	        	reserva.setCreate_time(resultSet.getDate("create_time"));
	        	reserva.setAlter_time(resultSet.getDate("alter_time"));
	        	
	        	r.add(reserva);
	        }
	        stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
	

	@Override
	public boolean remove(reserva objeto) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("delete from reserva where codReserva = ?;");
		
		try {
			Connection connection = Factory.createConnection();
			PreparedStatement stmt = connection.prepareStatement(sql.toString());
			
			stmt.setInt(1, objeto.getCodReserva());
			
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
