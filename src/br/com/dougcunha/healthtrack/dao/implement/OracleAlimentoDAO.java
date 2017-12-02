package br.com.dougcunha.healthtrack.dao.implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.dougcunha.healthtrack.dao.interfaces.AlimentoDAO;
import br.com.dougcunha.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.dougcunha.healthtrack.dao.singleton.ConnectionManager;
import br.com.dougcunha.healthtrack.entity.Alimento;
import br.com.dougcunha.healthtrack.entity.TipoAlimento;

class OracleAlimentoDAO implements AlimentoDAO {
	
	private Connection conn;
	private UsuarioDAO uDAO;
	
	@Override
	public void cadastrar(Alimento alimento, int userId) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		String insertQuery = "INSERT INTO T_ALIMENTO (COD_ALIMENTO, T_USUARIO_COD_USUARIO, NM_TIPO, NR_CALORIAS, NM_DESCRICAO, DT_CONSUMO, DT_CADASTRO) VALUES (SQ_ALIMENTO.nextval, ?, ?, ?, ?, ?,sysdate)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setInt(1,userId);
			pstmt.setString(2, alimento.getTipoAlimento().getNome());
			pstmt.setShort(3, alimento.getCaloria());
			pstmt.setString(4, alimento.getDescricao());
			pstmt.setDate(5, new Date(alimento.getData().getTimeInMillis()));
			pstmt.execute();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Alimento alimento) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		String updateQuery = "UPDATE T_ALIMENTO SET NM_TIPO = ?, NR_CALORIAS = ?, NM_DESCRICAO = ?, DT_CONSUMO = ? ,DT_ULTIMA_ATUALIZACAO = sysdate WHERE COD_ALIMENTO = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, alimento.getTipoAlimento().getNome());
			pstmt.setShort(2, alimento.getCaloria());
			pstmt.setString(3, alimento.getDescricao());
			pstmt.setDate(4, new Date(alimento.getData().getTimeInMillis()));
			pstmt.setInt(5, alimento.getId());
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
		conn = ConnectionManager.getInstance().getOracleConnection();
		String deleteQuery = "DELETE FROM T_ALIMENTO WHERE T_ALIMENTO.COD_ALIMENTO = ?";
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
	public Alimento buscar(int alimentoId) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		uDAO = DAOFactory.getUsuarioDAO();
		String selectByIdQuery = "SELECT * FROM T_ALIMENTO WHERE T_ALIMENTO.COD_ALIMENTO = ?";
		 Alimento alimento = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectByIdQuery);
			pstmt.setInt(1, alimentoId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				alimento = new Alimento();
				alimento.setId(rs.getInt("COD_ALIMENTO"));
				alimento.setTipoAlimento(new TipoAlimento(rs.getString("NM_TIPO")));
				alimento.setCaloria(rs.getShort("NR_CALORIAS"));
				alimento.setDescricao(rs.getString("NM_DESCRICAO"));
				Date date = rs.getDate("DT_CONSUMO");
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(date.getTime());
				alimento.setData(cal);
				alimento.setUsuario(uDAO.buscar(rs.getInt("T_USUARIO_COD_USUARIO")));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alimento;
	}

	@Override
	public List<Alimento> listar(int userId) {
		List<Alimento> alimentos = null;
		conn = ConnectionManager.getInstance().getOracleConnection();
		uDAO = DAOFactory.getUsuarioDAO();
		String selectQuery = "SELECT * FROM T_ALIMENTO";
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			ResultSet rs = pstmt.executeQuery();
			alimentos = new ArrayList<Alimento>();
			while (rs.next()) {
				Date date = rs.getDate("DT_CONSUMO");
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(date.getTime());
				Alimento a = new Alimento(cal, uDAO.buscar(rs.getInt("T_USUARIO_COD_USUARIO")), rs.getShort("NR_CALORIAS"), rs.getInt("COD_ALIMENTO"), rs.getString("NM_DESCRICAO"), new TipoAlimento(rs.getString("NM_TIPO")));
				alimentos.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alimentos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
