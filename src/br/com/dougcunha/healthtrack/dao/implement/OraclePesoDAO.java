package br.com.dougcunha.healthtrack.dao.implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.dougcunha.healthtrack.dao.interfaces.PesoDAO;
import br.com.dougcunha.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.dougcunha.healthtrack.dao.singleton.ConnectionManager;
import br.com.dougcunha.healthtrack.entity.Peso;
import br.com.dougcunha.healthtrack.entity.Usuario;

class OraclePesoDAO implements PesoDAO{
	private Connection conn;
	private UsuarioDAO userDAO;
	
	@Override
	public void cadastrar(Peso peso, int userId) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		String insertPeso = "INSERT INTO T_PESO(COD_PESO, T_USUARIO_COD_USUARIO, NR_PESO_KG, DT_PESAGEM, DT_CADASTRO) values (PESOID_SEQ.NEXTVAL,?,?,?,sysdate)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(insertPeso);
			pstmt.setInt(1, peso.getUsuario().getId());
			pstmt.setFloat(2, peso.getPeso());						
			pstmt.setDate(3, new Date(peso.getData().getTimeInMillis()));
			pstmt.execute();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Peso peso) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		String updateSQL = "UPDATE T_PESO SET NR_PESO_KG = ?, DT_PESAGEM = ?, DT_ULTIMA_ATUALIZACAO = sysdate WHERE COD_PESO = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(updateSQL);
			pstmt.setFloat(1, peso.getPeso());
			pstmt.setDate(2, new Date(peso.getData().getTimeInMillis()));
			pstmt.setInt(3, peso.getId());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(int id) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		String deleteSQL = "DELETE FROM T_PESO WHERE T_PESO.COD_PESO = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, id);
			pstmt.execute();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Peso> listar(int userId) {
		String selectAllPeso = "SELECT * FROM T_PESO WHERE T_PESO.T_USUARIO_COD_USUARIO = ? ORDER BY T_PESO.COD_PESO DESC";
		conn = ConnectionManager.getInstance().getOracleConnection();
		userDAO = DAOFactory.getUsuarioDAO();
		Calendar dtPesagem;
		List<Peso> pesos = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAllPeso);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			pesos = new ArrayList<Peso>();
			while (rs.next()) {
				Date date = rs.getDate("DT_PESAGEM");
				dtPesagem = Calendar.getInstance();
				dtPesagem.setTimeInMillis(date.getTime());
				Usuario usuario = userDAO.buscar(rs.getInt("T_USUARIO_COD_USUARIO"));
				Peso p = new Peso(rs.getInt("COD_PESO"), dtPesagem, usuario, rs.getFloat("NR_PESO_KG"));
				pesos.add(p);
			}
			pstmt.close();
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pesos;
	}

	@Override
	public Peso buscar(int pesoId) {
		Peso p = null;
		Calendar dtPesagem;
		conn = ConnectionManager.getInstance().getOracleConnection();
		userDAO = DAOFactory.getUsuarioDAO();
		String sqlSelect = "SELECT * FROM T_PESO WHERE T_PESO.COD_PESO = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setInt(1, pesoId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				p = new Peso();
				p.setId(rs.getInt("COD_PESO"));
				p.setUsuario(userDAO.buscar(rs.getInt("T_USUARIO_COD_USUARIO")));
				p.setPeso(rs.getFloat("NR_PESO_KG"));
				Date date = rs.getDate("DT_PESAGEM");
				dtPesagem = Calendar.getInstance();
				dtPesagem.setTimeInMillis(date.getTime());
				p.setData(dtPesagem);
				rs.close();
				pstmt.close();
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

}
