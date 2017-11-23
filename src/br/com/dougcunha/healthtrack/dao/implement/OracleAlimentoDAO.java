package br.com.dougcunha.healthtrack.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.dougcunha.healthtrack.dao.interfaces.AlimentoDAO;
import br.com.dougcunha.healthtrack.entity.Alimento;
import br.com.dougcunha.healthtrack.singleton.ConnectionManager;

public class OracleAlimentoDAO implements AlimentoDAO {
	
	private Connection conn;
	
	@Override
	public void cadastrar(Alimento alimento) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		String insertQuery = "INSERT INTO T_ALIMENTO (COD_ALIMENTO, T_USUARIO_COD_USUARIO, NM_TIPO, NR_CALORIAS, NM_DESCRICAO, DT_CONSUMO, DT_CADASTRO, DT_ULTIMA_ATUALIZACAO) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			//TODO: Make parameters
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(Alimento alimento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alimento buscar(int alimentoId) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		String selectQuery = "SELECT * FROM RM78342.T_ALIMENTO WHERE RM78342.T_ALIMENTO.T_USUARIO_COD_USUARIO = 1 AND RM78342.T_ALIMENTO.COD_ALIMENTO = ?";
		 
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, alimentoId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Alimento alimento = new Alimento();
				alimento.setId(rs.getInt("COD_ALIMENTO"));
				alimento.setCaloria(rs.getShort("NR_CALORIAS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<Alimento> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
