package SaberYGanar;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import Vistas.pantalla_preguntes_ingles;
import Vistas.pantalla_preguntes_lletres;
import Vistas.pantalla_preguntes_mates;
import Vistas.ranquing;
import Vistas.ranquingFinal;
import Vistas.selecRonda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Partida {
	private static int numRondas;
	static int dormir = 50000;
	static int rondaActual = 0;
	private String numsJugadors[];
	private static Scanner sc = new Scanner(System.in);
	static conexionBD bd = new conexionBD();
	static Connection conexion = bd.obtenerConexion();
	static ArrayList<Integer> alreadyUsedNumbers = new ArrayList<>();
	static Random random = new Random();
	static int idUltimaPartida = 0;
	public static Thread hilo1;
	public static int jugadoresJugado = 1;
	public static int numeroDeJugadores;
	public static int numeroDeRondas;
	public static int numRandom;
	public static String nombre1, nombre2, nombre3, nombre4, nombre5, nombre6;
	public static boolean aux = false;
	
	public Partida(int numRondas, int numJugador, String[] nombreJugadores) {
		System.out.println(numRondas);
		System.out.println(numJugador);
		PreparedStatement insert = null;
		numeroDeJugadores = numJugador;
		numeroDeRondas = numRondas;
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
		this.numsJugadors = nombreJugadores;
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
				numsJugadors[randomNumber] = nombreJugadores[i];
				i++;
			}
		}
		for (int j = 0; j < numsJugadors.length; j++) {
			System.out.println("Puesto:" + j + " para: " + numsJugadors[j]);
			if (j == 0) {
				nombre1 = numsJugadors[j];
			}else if(j == 1) {
				nombre2 = numsJugadors[j];
			}else if(j == 2) {
				nombre3 = numsJugadors[j];
			}else if(j == 3) {
				nombre4 = numsJugadors[j];
			}else if(j == 4) {
				nombre5 = numsJugadors[j];
			}else if(j == 5) {
				nombre6 = numsJugadors[j];
			}
		}
			pasarRondas();
	}
	
	public Partida() {
	}
	
	
	public void ronda(int pregunta) {
		int cantIdMates, cantIdLetras, cantIdIngles;
		String nombre = null;
		if (jugadoresJugado == 1) {
			nombre = nombre1;
		}else if(jugadoresJugado == 2) {
			nombre = nombre2;
		}else if(jugadoresJugado == 3) {
			nombre = nombre3;
		}else if(jugadoresJugado == 4) {
			nombre = nombre4;
		}else if(jugadoresJugado == 5) {
			nombre = nombre5;
		}else if(jugadoresJugado == 6) {
			nombre = nombre6;
		}
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
					pantalla_preguntes_lletres pL = new pantalla_preguntes_lletres(rs.getString(1), nombre);
					pL.setVisible(true);
				}
				else if(pregunta == 1) {
					numRandom = (int) (Math.random()*cantIdMates);
					rs = stmt.executeQuery("SELECT equacion FROM MATES WHERE idMates = " + numRandom);
					rs.next();
					pantalla_preguntes_mates pM = new pantalla_preguntes_mates(rs.getString(1), nombre);
					pM.setVisible(true);
				}
				else{
					numRandom = (int) (Math.random()*(cantIdIngles-(cantIdMates+1)+1)+(cantIdMates+1));
					rs = stmt.executeQuery("SELECT pregunta FROM INGLES WHERE idIngles = " + numRandom);
					rs.next();
					String enunciado = rs.getString(1);
					rs = stmt.executeQuery("SELECT respuestas FROM INGLES WHERE idIngles = " + numRandom);
					rs.next();
					pantalla_preguntes_ingles pI = new pantalla_preguntes_ingles(enunciado, rs.getString(1), nombre);
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
		selecRonda rondaElegir = new selecRonda();
		rondaElegir.setVisible(true);
		hilo1 = new Thread(rondaElegir);
		hilo1.start();
	}
	
	public void sumarPuntos(boolean respuesta) {
		int punto = 0;
		if (respuesta) {
			punto = 1;
		}else
			punto = 0;
		String nombre = null;
		if (jugadoresJugado == 1) {
			nombre = nombre1;
		}else if(jugadoresJugado == 2) {
			nombre = nombre2;
		}else if(jugadoresJugado == 3) {
			nombre = nombre3;
		}else if(jugadoresJugado == 4) {
			nombre = nombre4;
		}else if(jugadoresJugado == 5) {
			nombre = nombre5;
		}else if(jugadoresJugado == 6) {
			nombre = nombre6;
		}
		PreparedStatement stmt = null;
		if (!aux) {
			try {
				stmt = conexion.prepareStatement("INSERT INTO RONDAS VALUES (?,?)");
				stmt.setInt(1, rondaActual+1);
				stmt.setInt(2, idUltimaPartida);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			aux = true;
		}
		stmt = null;
		try {
			stmt = conexion.prepareStatement("INSERT INTO JUEGAN VALUES (?,?,?,?,?,?)");
			stmt.setInt(1, rondaActual+1);
			stmt.setInt(2, idUltimaPartida);
			stmt.setString(3, nombre);
			stmt.setInt(4, numRandom);
			stmt.setInt(5, punto);
			stmt.setBoolean(6, respuesta);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (jugadoresJugado == numeroDeJugadores) {
			jugadoresJugado = 0;
			rondaActual++;
			aux = false;
			ranquing r = new ranquing(numeroDeJugadores, idUltimaPartida, nombre1, nombre2, nombre3, nombre4, nombre5, nombre6);
			if(rondaActual != numeroDeRondas)
			r.setVisible(true);
		}
		else
			pasarRondas();
		
		if (rondaActual == numeroDeRondas) {
			System.out.println("Partida acabada");
			ranquingFinal rf = null;
			try {
				rf = new ranquingFinal();
				rf.setVisible(true);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		jugadoresJugado++;
	}
}
