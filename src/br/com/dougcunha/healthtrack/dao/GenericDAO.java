package br.com.dougcunha.healthtrack.dao;

import java.util.List;

public interface GenericDAO<T> {

	void cadastrar(T t);
	void atualizar(T t);
	void remover(int id);
	T buscar(int id);
	List<T> listar();
}
