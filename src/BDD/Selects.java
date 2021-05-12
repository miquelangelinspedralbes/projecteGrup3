package BDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Selects {
	static conexionBD bd = new conexionBD();
	static Connection conexion = bd.obtenerConexion();
	static Statement stmt = null;
	static ResultSet rs = null;
	
	public Selects() {
		
	}
	
	public int selecMaxPartida() {
		int idUltimaPartida = 0;
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT MAX(id) FROM PARTIDA");
			rs.next();
			idUltimaPartida = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idUltimaPartida;
	}
	
	public int selecCountIngles() {
		int cantIdIngles = 0;
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(idIngles) FROM INGLES");
			rs.next();
			cantIdIngles = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cantIdIngles;
	}
	
	public int selecCountLetras() {
		int cantIdLetras = 0;
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(idLetras) FROM LETRAS");
			rs.next();
			cantIdLetras = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cantIdLetras;
	}
	
	public int selecCountMates() {
		int cantIdMates = 0;
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(idMates) FROM MATES");
			rs.next();
			cantIdMates = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cantIdMates;
	}
	
	public String selecOcultaLetras(int numRand) {
		String oculta = null;
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT palabraOculta FROM LETRAS WHERE idLetras = " + numRand);
			rs.next();
			oculta = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oculta;
	}
	
	public String selecEcuacioMates(int numRand) {
		String ecuacio = null;
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT equacion FROM MATES WHERE idMates = " + numRand);
			rs.next();
			ecuacio = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ecuacio;
	}
	
	
	public String selecEnunciadoIngles(int numRand) {
		String enunciado = null;
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT pregunta FROM INGLES WHERE idIngles = " + numRand);
			rs.next();
			enunciado = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enunciado;
	}
	
	public String selecRespuestasIngles(int numRand) {
		String respuestas = null;
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT respuestas FROM INGLES WHERE idIngles = " + numRand);
			rs.next();
			respuestas = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuestas;
	}
	
	public ArrayList<String> selectNombresJugadors() {
		ArrayList<String> nombres = new ArrayList<String>();
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT nombre FROM JUGADORES");
			for(int i=0;rs.next();i++) {
				nombres.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombres;
	}
	
	public String selecRespuestasCorrectaIngles(String enunciado) {
		String correcta = null;
		try {
			stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT respuestaCorrecta FROM INGLES WHERE pregunta = '"+ enunciado + "'");
			rs.next();
			correcta = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcta;
	}
	
	public String selecPalabraCompleta(String palabra) {
		String completa = null;
		try {
			stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT palabraCompleta FROM LETRAS WHERE palabraOculta = '"+ palabra + "'");
			rs.next();
			completa = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return completa;
	}
	
	public int respuestaMates(String ecuacion) {
		int correcto = 0;
		try {
			stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT respuesta FROM MATES WHERE equacion = '"+ ecuacion + "'");
			rs.next();
			correcto = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;
	}
	
	public int sumPuntos(int idUltimaPartida, String nombre) {
		int puntos = 0;
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery("SELECT SUM(puntos) FROM JUEGAN WHERE idPartida = " + idUltimaPartida + " && nombreJugador = '" + nombre + "'");
			rs.next();
			puntos = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return puntos;
	}
	
	
	
	
	
}
