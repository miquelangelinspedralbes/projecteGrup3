package SaberYGanar;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import projecteGrup3.pantalla_preguntes_ingles;
import projecteGrup3.pantalla_preguntes_lletres;
import projecteGrup3.pantalla_preguntes_mates;
import projecteGrup3.selecRonda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Partida {
	private static int numRondas;
	static int dormir = 50000;
	static int rondaActual = 1;
	private Jugador numsJugadors[];
	private static Scanner sc = new Scanner(System.in);
	static conexionBD bd = new conexionBD();
	static Connection conexion = bd.obtenerConexion();
	static ArrayList<Integer> alreadyUsedNumbers = new ArrayList<>();
	static Random random = new Random();
	static int idUltimaPartida = 0;
	public static Thread hilo1;
	static int jugadoresJugado;
	
	public Partida(int numRondas, int numJugador, String[] nombreJugadores) {
		PreparedStatement insert = null;
		try {
			insert = conexion.prepareStatement("INSERT INTO PARTIDA VALUES ()");
			insert.executeUpdate();
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM PARTIDA");
			rs.next();
			idUltimaPartida = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		this.numRondas = numRondas;
		this.numsJugadors = new Jugador[numJugador];
		while (alreadyUsedNumbers.size()<numsJugadors.length) {
			
			int randomNumber = random.nextInt(numsJugadors.length);
			if (!alreadyUsedNumbers.contains(randomNumber)){
				alreadyUsedNumbers.add(randomNumber);
				try {
					insert = conexion.prepareStatement("INSERT INTO JUGADORES VALUES (?)");
					insert.setString(1, nombreJugadores[i]);
					insert.executeUpdate();	
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					insert = conexion.prepareStatement("INSERT INTO PARTICIPAN VALUES (?, ?)");
					insert.setString(1, nombreJugadores[i]);
					insert.setInt(2, idUltimaPartida);
					insert.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				numsJugadors[randomNumber] = new Jugador(nombreJugadores[i]);
				i++;
			}
		}
		for (int j = 0; j < numsJugadors.length; j++) {
			System.out.println("Puesto:" + j + "para: " + numsJugadors[j].getNombre());
		}
			pasarRondas();
	}
	
	public Partida() {
	}
	
	
	public void ronda(int pregunta) {
		int cantIdMates, cantIdLetras, cantIdIngles, numRandom;
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT COUNT(idIngles) FROM INGLES");
				rs.next();
				cantIdIngles = rs.getInt(1);
				
				rs = stmt.executeQuery("SELECT COUNT(idLetras) FROM LETRAS");
				rs.next();
				cantIdLetras = rs.getInt(1);
				
				rs = stmt.executeQuery("SELECT COUNT(idMates) FROM MATES");
				rs.next();
				cantIdMates = rs.getInt(1);
				
				if (pregunta == 0) {				
					numRandom = (int) (Math.random()*(cantIdLetras-(cantIdIngles+1)+1)+(cantIdIngles+1));
					rs = stmt.executeQuery("SELECT palabraOculta FROM LETRAS WHERE idLetras = " + numRandom);
					rs.next();
					pantalla_preguntes_lletres pL = new pantalla_preguntes_lletres(rs.getString(1));
					pL.setVisible(true);
				}
				else if(pregunta == 1) {
					numRandom = (int) (Math.random()*cantIdMates);
					rs = stmt.executeQuery("SELECT equacion FROM MATES WHERE idMates = " + numRandom);
					rs.next();
					pantalla_preguntes_mates pM = new pantalla_preguntes_mates(rs.getString(1));
					pM.setVisible(true);
				}
				else{
					numRandom = (int) (Math.random()*(cantIdIngles-(cantIdMates+1)+1)+(cantIdMates+1));
					rs = stmt.executeQuery("SELECT pregunta FROM INGLES WHERE idIngles = " + numRandom);
					rs.next();
					String enunciado = rs.getString(1);
					rs = stmt.executeQuery("SELECT respuestas FROM INGLES WHERE idIngles = " + numRandom);
					rs.next();
					pantalla_preguntes_ingles pI = new pantalla_preguntes_ingles(enunciado, rs.getString(1));
					pI.setVisible(true);
				}
				
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void pasarRondas(){
				selecRonda rondaElegir = new selecRonda(rondaActual);
				rondaElegir.setVisible(true);
				hilo1 = new Thread(rondaElegir);
				hilo1.start();
				jugadoresJugado++;
				if (jugadoresJugado == numsJugadors.length) {
					jugadoresJugado = 0;
					rondaActual++;
				}
	}
}
