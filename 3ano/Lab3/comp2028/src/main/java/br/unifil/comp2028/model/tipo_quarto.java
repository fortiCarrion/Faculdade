package br.unifil.comp2028.model;

import java.io.Serializable;
import java.sql.Date;

public class tipo_quarto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idTipo;
	private String descricao;
	private Date create_time;
	private Date alter_time;
	private String valor;
	
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
}
