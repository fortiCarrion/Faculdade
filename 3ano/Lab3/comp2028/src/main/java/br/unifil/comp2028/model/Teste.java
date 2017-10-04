package br.unifil.comp2028.model;

/*
 * POJO - Plain Old Java Object 
 * 
 */

public class Teste {

	private int id;
	private String name;
	
	public Teste(){
		
	}
	
	public Teste(int id, String name){
		setId(id);
		setName(name);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
