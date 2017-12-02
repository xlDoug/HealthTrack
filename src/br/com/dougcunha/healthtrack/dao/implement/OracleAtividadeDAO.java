package br.com.dougcunha.healthtrack.dao.implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.dougcunha.healthtrack.dao.interfaces.AtividadeDAO;
import br.com.dougcunha.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.dougcunha.healthtrack.dao.singleton.ConnectionManager;
import br.com.dougcunha.healthtrack.entity.Atividade;
import br.com.dougcunha.healthtrack.entity.TipoAtividade;

class OracleAtividadeDAO implements AtividadeDAO{
	private Connection conn;
	private UsuarioDAO uDAO;
	
	@Override
	public void cadastrar(Atividade atividade, int userId) {
		uDAO = DAOFactory.getUsuarioDAO();
		conn = ConnectionManager.getInstance().getOracleConnection();
		String insertSQL = "INSERT INTO T_ATIVIDADE (COD_ATIVIDADE, T_USUARIO_COD_USUARIO, NM_TIPO_ATIVIDADE, NM_DESCRICAO, NR_CALORIAS_CONSUMIDAS, DT_REALIZACAO_ATIVIDADE, DT_CADASTRO) VALUES(SQ_ATIVIDADE.NEXTVAL, ?,?,?,?,?,sysdate)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(insertSQL);
			pstmt.setInt(1, userId); //TODO: CODIGO DO USUARIO AQUI
			pstmt.setString(2, atividade.getTipoAtividade().getNome());
			pstmt.setString(3, atividade.getDescricao());
			pstmt.setShort(4, atividade.getCaloria());
			pstmt.setDate(5, new Date(atividade.getData().getTimeInMillis()));
			pstmt.execute();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Atividade atividade) {
		uDAO = DAOFactory.getUsuarioDAO();
		conn = ConnectionManager.getInstance().getOracleConnection();		
		String updateSQL = "UPDATE T_ATIVIDADE SET NM_TIPO_ATIVIDADE = ?, NM_DESCRICAO = ?, NR_CALORIAS_CONSUMIDAS = ?, DT_REALIZACAO_ATIVIDADE = ?, DT_ULTIMA_ATUALIZACAO = sysdate WHERE COD_ATIVIDADE = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, atividade.getTipoAtividade().getNome());
			pstmt.setString(2, atividade.getDescricao());
			pstmt.setShort(3, atividade.getCaloria());
			pstmt.setDate(4, new Date(atividade.getData().getTimeInMillis()));
			pstmt.setInt(5, atividade.getId());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remover(int id) {
		uDAO = DAOFactory.getUsuarioDAO();
		conn = ConnectionManager.getInstance().getOracleConnection();	
		String deleteSQL = "DELETE FROM T_ATIVIDADE WHERE COD_ATIVIDADE = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
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
	public Atividade buscar(int id) {
		uDAO = DAOFactory.getUsuarioDAO();
		conn = ConnectionManager.getInstance().getOracleConnection();
		Atividade atividade = null;
		String selectQuery = "SELECT * FROM T_ATIVIDADE WHERE COD_ATIVIDADE = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Date date = rs.getDate("DT_REALIZACAO_ATIVIDADE");
				Calendar instance = Calendar.getInstance();
				instance.setTimeInMillis(date.getTime());
				atividade = new Atividade(instance, rs.getString("NM_DESCRICAO"), uDAO.buscar(rs.getInt("T_USUARIO_COD_USUARIO")), rs.getShort("NR_CALORIAS_CONSUMIDAS"), rs.getInt("COD_ATIVIDADE"), new TipoAtividade(rs.getString("NM_TIPO_ATIVIDADE")));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return atividade;
	}

	@Override
	public List<Atividade> listar(int userId) {
		uDAO = DAOFactory.getUsuarioDAO();
		conn = ConnectionManager.getInstance().getOracleConnection();		
		String selectAll = "SELECT * FROM T_ATIVIDADE WHERE T_USUARIO_COD_USUARIO = ?";
		List<Atividade> atividades = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAll);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			atividades = new ArrayList<Atividade>();
			while (rs.next()) {
				Date date = rs.getDate("DT_REALIZACAO_ATIVIDADE");
				Calendar instance = Calendar.getInstance();
				instance.setTimeInMillis(date.getTime());
				Atividade a = new Atividade(instance, rs.getString("NM_DESCRICAO"), uDAO.buscar(rs.getInt("T_USUARIO_COD_USUARIO")), rs.getShort("NR_CALORIAS_CONSUMIDAS"), rs.getInt("COD_ATIVIDADE"), new TipoAtividade(rs.getString("NM_TIPO_ATIVIDADE")));
				atividades.add(a);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return atividades;
	}

}
