package br.com.dougcunha.healthtrack.dao.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
	
	private static ConnectionManager connectionManager;
	private ConnectionManager() {};
	
	public static ConnectionManager getInstance() {
		if (connectionManager == null) {
			connectionManager = new ConnectionManager();
		}
		return connectionManager;
	}
	
	public Connection getOracleConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","RM78342","121192");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}



















