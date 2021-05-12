package BDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserts {
	static conexionBD bd = new conexionBD();
	static Connection conexion = bd.obtenerConexion();
	PreparedStatement insert = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public Inserts() {
		
	}
	public void inserPartida(){
		try {
			insert = conexion.prepareStatement("INSERT INTO PARTIDA VALUES ()");
			insert.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertJugadors(String nombre) {
		try {
			insert = conexion.prepareStatement("INSERT INTO JUGADORES VALUES (?)");
			insert.setString(1, nombre);
			insert.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void insertParticipan(String nombre, int idUltimaPartida) {
		try {
			insert = conexion.prepareStatement("INSERT INTO PARTICIPAN VALUES (?, ?)");
			insert.setString(1, nombre);
			insert.setInt(2, idUltimaPartida);
			insert.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertRondas(int ronda, int idUltimaPartida) {
		try {
			insert = conexion.prepareStatement("INSERT INTO RONDAS VALUES (?,?)");
			insert.setInt(1, ronda);
			insert.setInt(2, idUltimaPartida);
			insert.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertJuegan(int ronda, int idUltimaPartida, String nombre, int idPrgunta, int puntos, boolean contestado) {
		try {
			insert = conexion.prepareStatement("INSERT INTO JUEGAN VALUES (?,?,?,?,?,?)");
			insert.setInt(1, ronda);
			insert.setInt(2, idUltimaPartida);
			insert.setString(3, nombre);
			insert.setInt(4, idPrgunta);
			insert.setInt(5, puntos);
			insert.setBoolean(6, contestado);
			insert.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
