package BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Deletes {
	static conexionBD bd = new conexionBD();
	static Connection conexion = bd.obtenerConexion();
	PreparedStatement insert = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public Deletes() {
		
	}
	
	public int eliminarJugador(String nombre) {
		try {
			insert = conexion.prepareStatement("DELETE FROM JUGADORES WHERE nombre = (?)");
			insert.setString(1, nombre);
			insert.executeUpdate();
			return insert.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
}
