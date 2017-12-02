package br.com.dougcunha.healthtrack.dao.interfaces;

import java.util.List;

public interface GenericDAO<T> {

	void cadastrar(T t, int userId);
	void atualizar(T t);
	void remover(int id);
	T buscar(int id);
	List<T> listar(int userId);
}
