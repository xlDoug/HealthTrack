package br.com.dougcunha.healthtrack.dao.interfaces;

import java.util.List;

import br.com.dougcunha.healthtrack.dao.GenericDAO;
import br.com.dougcunha.healthtrack.entity.Alimento;

public interface AlimentoDAO extends GenericDAO<Alimento> {
	
	void cadastrar(Alimento alimento);
	void atualizar(Alimento alimento);
	void remover(int id);
	Alimento buscar(int id);
	List<Alimento> listar();

}
