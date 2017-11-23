package br.com.dougcunha.healthtrack.testes;

import java.sql.Connection;

import br.com.dougcunha.healthtrack.dao.implement.OracleAlimentoDAO;
import br.com.dougcunha.healthtrack.entity.Alimento;
import br.com.dougcunha.healthtrack.singleton.ConnectionManager;

public class Testes {
	
	public static void main(String[] args) {
		
		try {
			Connection conn = ConnectionManager.getInstance().getOracleConnection();
			if (conn != null) {
				System.out.println("Connectado com sucesso");
				

			}
		} catch (Exception e) {
			System.out.println("Erro ao conectar com banco");
			e.printStackTrace();
		}
		Alimento alimento = new OracleAlimentoDAO().buscar(1);
		System.out.println(alimento);
		
		
		
	}

}
