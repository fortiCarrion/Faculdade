package br.unifil.comp2028.dao;

import java.util.List;

public interface GenericDAO<T> {

	void save(T objeto);
	void edit(T objeto);
	T findOne(Long id);
	List<T> findAll();
	boolean remove(T objeto);
	
}
