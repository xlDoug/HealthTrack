package br.com.dougcunha.healthtrack.dao.implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.dougcunha.healthtrack.dao.interfaces.PressaoArterialDAO;
import br.com.dougcunha.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.dougcunha.healthtrack.dao.singleton.ConnectionManager;
import br.com.dougcunha.healthtrack.entity.PressaoArterial;

class OraclePressaoArterialDAO implements PressaoArterialDAO{
	private Connection conn;
	private UsuarioDAO uDAO;
	
	@Override
	public void cadastrar(PressaoArterial pressaoArterial, int userId) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		String insertQuery = "INSERT INTO T_PRESSAO (COD_PRESSAO, T_USUARIO_COD_USUARIO, NR_PRESSAO_SISTOLICA, NR_PRESSAO_DIASTOLICA, DT_MEDICAO, NM_SITUACAO, DT_CADASTRO) VALUES"
				+ "(SQ_PRESSAO.NEXTVAL, ?,?,?,?,?,sysdate)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setInt(1, userId);//TODO: Substituir pela id da session
			pstmt.setFloat(2, pressaoArterial.getSistolica());
			pstmt.setFloat(3, pressaoArterial.getDiastolica());
			pstmt.setDate(4, new Date(pressaoArterial.getData().getTimeInMillis()));
			pstmt.setString(5, pressaoArterial.calcularSituacao(pressaoArterial.getDiastolica(), pressaoArterial.getSistolica()));
			pstmt.execute();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(PressaoArterial pressaoArterial) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		String updateQuery = "UPDATE T_PRESSAO SET NR_PRESSAO_SISTOLICA = ?, NR_PRESSAO_DIASTOLICA = ?, DT_MEDICAO = ?, NM_SITUACAO = ?, DT_ATUALIZACAO = SYSDATE WHERE COD_PRESSAO = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setFloat(1, pressaoArterial.getSistolica());
			pstmt.setFloat(2, pressaoArterial.getDiastolica());
			pstmt.setDate(3, new Date(pressaoArterial.getData().getTimeInMillis()));
			pstmt.setString(4, pressaoArterial.calcularSituacao(pressaoArterial.getDiastolica(), pressaoArterial.getSistolica()));
			pstmt.setInt(5, pressaoArterial.getId());
			pstmt.execute();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remover(int id) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		String deleteQuery = "DELETE FROM T_PRESSAO WHERE COD_PRESSAO = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, id);
			pstmt.execute();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public PressaoArterial buscar(int id) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		uDAO = DAOFactory.getUsuarioDAO();
		String insertQuery = "SELECT * FROM T_PRESSAO WHERE COD_PRESSAO = ?";
		PressaoArterial p = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Calendar cal = Calendar.getInstance();
				Date dt = rs.getDate("DT_MEDICAO");
				cal.setTimeInMillis(dt.getTime());
				p = new PressaoArterial(rs.getInt("COD_PRESSAO"),cal , uDAO.buscar(rs.getInt("T_USUARIO_COD_USUARIO")), rs.getFloat("NR_PRESSAO_SISTOLICA"), rs.getFloat("NR_PRESSAO_DIASTOLICA"));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<PressaoArterial> listar(int userId) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		uDAO = DAOFactory.getUsuarioDAO();
		String selectAll = "SELECT * FROM T_PRESSAO WHERE T_USUARIO_COD_USUARIO = ?";
		List<PressaoArterial> listaPressao = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAll);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			listaPressao = new ArrayList<PressaoArterial>();
			while (rs.next()) {
				Calendar cal = Calendar.getInstance();
				Date dt = rs.getDate("DT_MEDICAO");
				cal.setTimeInMillis(dt.getTime());
				PressaoArterial p = new PressaoArterial(rs.getInt("COD_PRESSAO"),cal , uDAO.buscar(rs.getInt("T_USUARIO_COD_USUARIO")), rs.getFloat("NR_PRESSAO_SISTOLICA"), rs.getFloat("NR_PRESSAO_DIASTOLICA"));
				listaPressao.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaPressao;
	}

}
