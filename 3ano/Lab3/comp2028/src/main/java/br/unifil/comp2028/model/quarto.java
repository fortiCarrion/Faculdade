package br.unifil.comp2028.model;

import java.io.Serializable;
import java.sql.Date;

public class quarto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idQuarto;
	private String descricao;
	private tipo_quarto tipo;
	private int capacidade;
	private Date create_time;
	private Date alter_time;
	
	
	public int getIdQuarto() {
		return idQuarto;
	}
	public void setIdQuarto(int idQuarto) {
		this.idQuarto = idQuarto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public tipo_quarto getTipo() {
		return tipo;
	}
	public void setTipo(tipo_quarto tipo) {
		this.tipo = tipo;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getAlter_time() {
		return alter_time;
	}
	public void setAlter_time(Date alter_time) {
		this.alter_time = alter_time;
	}
	
	
	
}
