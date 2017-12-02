package br.com.dougcunha.healthtrack.dao.implement;

import br.com.dougcunha.healthtrack.dao.interfaces.AlimentoDAO;
import br.com.dougcunha.healthtrack.dao.interfaces.AtividadeDAO;
import br.com.dougcunha.healthtrack.dao.interfaces.PesoDAO;
import br.com.dougcunha.healthtrack.dao.interfaces.PressaoArterialDAO;
import br.com.dougcunha.healthtrack.dao.interfaces.UsuarioDAO;

public class DAOFactory {

	public static AlimentoDAO getAlimentoDAO() {
		return new OracleAlimentoDAO();
	}

	public static AtividadeDAO getAtividadeDAO() {
		return new OracleAtividadeDAO();
	}

	public static PesoDAO getPesoDAO() {
		return new OraclePesoDAO();
	}

	public static PressaoArterialDAO getPressaoArterialDAO() {
		return new OraclePressaoArterialDAO();
	}

	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}

}
