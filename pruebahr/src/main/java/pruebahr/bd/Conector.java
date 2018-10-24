package pruebahr.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	
	private String usuario = "HR";
	private String password = "HR";
	private String cadena ="jdbc:oracle:thin:@localhost:1521:XE";
	private String driver ="oracle.jdbc.OracleDriver";
	public Connection con;
	
	public void conectar() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		con=DriverManager.getConnection(cadena, usuario, password);
	}
	public void desconectar() throws SQLException{
		con.close();
	}

}
