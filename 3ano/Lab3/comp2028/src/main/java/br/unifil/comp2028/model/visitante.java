package br.unifil.comp2028.model;

import java.io.Serializable;
import java.util.Date;

public class visitante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idVisitante;
	private String nome;
	private String telefone;
	private String email;
	private Date create_time;
	private Date alter_time;
	public int getIdVisitante() {
		return idVisitante;
	}
	public void setIdVisitante(int idVisitante) {
		this.idVisitante = idVisitante;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
