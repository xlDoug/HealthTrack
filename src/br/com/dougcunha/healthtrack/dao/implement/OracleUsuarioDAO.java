package br.com.dougcunha.healthtrack.dao.implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.dougcunha.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.dougcunha.healthtrack.dao.singleton.ConnectionManager;
import br.com.dougcunha.healthtrack.entity.Usuario;

class OracleUsuarioDAO implements UsuarioDAO {

	private Connection conn;

	@Override
	public Usuario buscar(int id) {
		conn = ConnectionManager.getInstance().getOracleConnection();
		Usuario u = null;
		String sqlSelectUser = "SELECT * FROM T_USUARIO where COD_USUARIO = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sqlSelectUser);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				u = new Usuario();
				u.setId(rs.getInt("COD_USUARIO"));
				u.setNome(rs.getString("NM_NOME"));
				u.setEmail(rs.getString("NM_EMAIL_CONTATO"));
				Date dtNasc = rs.getDate("DT_NASCIMENTO");
				Calendar cal = Calendar.getInstance();
				cal.setTime(dtNasc);
				u.setDtNasc(cal);
				u.setSenha(rs.getString("NM_HASH_SENHA"));
				u.setAltura(rs.getFloat("NR_ALTURA_CM"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}



}
