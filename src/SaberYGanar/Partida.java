package SaberYGanar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import BDD.Inserts;
import BDD.Selects;
import BDD.conexionBD;
import Vistas.pantalla_jugadors;
import Vistas.pantalla_preguntes_ingles;
import Vistas.pantalla_preguntes_lletres;
import Vistas.pantalla_preguntes_mates;
import Vistas.pregunta_correcte;
import Vistas.pregunta_incorrecte;
import Vistas.ranquing;
import Vistas.ranquingFinal;
import Vistas.selecRonda;

public class Partida {
	static int numRondas;
	static int rondaActual = 0;
	private ArrayList<String> numsJugadors = new ArrayList<String>();
	static ArrayList<Integer> alreadyUsedNumbers = new ArrayList<>();
	static Random random = new Random();
	static int idUltimaPartida = 0;
	public static Thread hilo1;
	public static int jugadoresJugado = 1;
	public static int numeroDeJugadores;
	public static int numeroDeRondas;
	public static int numRandom;
	public static String nombre1, nombre2, nombre3, nombre4, nombre5, nombre6, CPU1, CPU2, CPU3, CPU4, CPU5;
	public static boolean aux = false, esCPU = false;
	public static Inserts inser = new Inserts();
	public static Selects selec = new Selects();
	static int maxCPU = 0, contadorCPU = 0;
	static conexionBD bdd = new conexionBD();
	static Connection conexion = bdd.obtenerConexion();
	static ArrayList<Integer> puntos = new ArrayList<Integer>(), puntosCPU = new ArrayList<Integer>();
		
	public Partida(int numRondas, int numJugador, String[] nombreJugadores, int contadorCPU) {			
			numeroDeJugadores = numJugador - contadorCPU;
			numeroDeRondas = numRondas;
			maxCPU = contadorCPU;
			
			inser.inserPartida();
			inser.commit();
			idUltimaPartida = selec.selecMaxPartida();
			int i = 0;
			this.numRondas = numRondas;
			
			while (alreadyUsedNumbers.size()<nombreJugadores.length) {
				
				int randomNumber = random.nextInt(nombreJugadores.length);
				if (!alreadyUsedNumbers.contains(randomNumber)){
					alreadyUsedNumbers.add(randomNumber);
					inser.insertJugadors(nombreJugadores[i]);
					inser.insertParticipan(nombreJugadores[i], idUltimaPartida);
					
					numsJugadors.add(nombreJugadores[randomNumber]);
					i++;
				}
			}
			for (int j = 0; j < numsJugadors.size(); j++) {
				if (j == 0) {
					nombre1 = numsJugadors.get(j);
				}else if(j == 1) {
					nombre2 = numsJugadors.get(j);
				}else if(j == 2) {
					nombre3 = numsJugadors.get(j);
				}else if(j == 3) {
					nombre4 = numsJugadors.get(j);
				}else if(j == 4) {
					nombre5 = numsJugadors.get(j);
				}else if(j == 5) {
					nombre6 = numsJugadors.get(j);
				}
				puntos.add(0);
			}
			for (int j = 0; j < maxCPU; j++) {
				if (j == 0) {
					CPU1 = "CPU1";
				}else if(j == 1) {
					CPU2 = "CPU2";
				}else if(j == 2) {
					CPU3 = "CPU3";
				}else if(j == 3) {
					CPU4 = "CPU4";
				}else {
					CPU5 = "CPU5";
				}
				puntosCPU.add(0);
			}
			
				pasarRondas();
		}
		
		public Partida() {
		}
		
		
		public void ronda(int pregunta) {
			int cantIdMates, cantIdLetras, cantIdIngles;
			String nombre = null;
			if(esCPU) {
				if (contadorCPU == 1) {
					nombre = CPU1;
				}else if(contadorCPU == 2) {
					nombre = CPU2;
				}else if(contadorCPU == 3) {
					nombre = CPU3;
				}else if(contadorCPU == 4) {
					nombre = CPU4;
				}else {
					nombre = CPU5;
				}
			}else {		
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
			}
			cantIdIngles = selec.selecCountIngles();
			cantIdLetras = selec.selecCountLetras();
			cantIdMates = selec.selecCountMates();
			if (pregunta == 0) {
				if(esCPU) {
					String correcto = selec.selecPalabraCompleta("aa");
					pregunta_incorrecte pi = new pregunta_incorrecte(correcto, nombre);
					pi.setVisible(true);
					pi.setLocationRelativeTo(null);
				}else {
					numRandom = (int) (Math.random()*(cantIdLetras-(cantIdIngles+1)+1)+(cantIdIngles+1));
					pantalla_preguntes_lletres pL = new pantalla_preguntes_lletres(numRandom, nombre);
					pL.setVisible(true);
					pL.setLocationRelativeTo(null);
				}
			}
			else if(pregunta == 1) {
				if(esCPU) {
					pregunta_correcte pc = new pregunta_correcte(nombre);
					pc.setVisible(true);
					pc.setLocationRelativeTo(null);
				}else {
					numRandom = (int) (Math.random()*cantIdMates);
					pantalla_preguntes_mates pM = new pantalla_preguntes_mates(numRandom, nombre);
					pM.setVisible(true);
					pM.setLocationRelativeTo(null);
				}
			}
			else{
				if(esCPU) {
					int numRandom = (int) (Math.random()*2);
					if(numRandom == 0) {
						String correcto = selec.selecRespuestasCorrectaIngles("hola");
						pregunta_incorrecte pi = new pregunta_incorrecte(correcto, nombre);
						pi.setVisible(true);
						pi.setLocationRelativeTo(null);
					}else {
						pregunta_correcte pc = new pregunta_correcte(nombre);
						pc.setVisible(true);
						pc.setLocationRelativeTo(null);
					}
				}else {
					numRandom = (int) (Math.random()*(cantIdIngles-(cantIdMates+1)+1)+(cantIdMates+1));
					pantalla_preguntes_ingles pI = new pantalla_preguntes_ingles(numRandom, nombre);
					pI.setVisible(true);
					pI.setLocationRelativeTo(null);
				}
			}
		}
		
		public void pasarRondas(){		
			selecRonda rondaElegir = new selecRonda();
			rondaElegir.setVisible(true);
			rondaElegir.setLocationRelativeTo(null);
			hilo1 = new Thread(rondaElegir);
			hilo1.start();
		}
		
		public void sumarPuntos(boolean respuesta) {
			if(!esCPU) {		
				int punto = 0;
				if (respuesta) {
					punto = 1;
					int puntoAnterior=puntos.get(jugadoresJugado-1);
					puntoAnterior++;
					puntos.set(jugadoresJugado-1, puntoAnterior);
				}
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
				if (!aux) {
					inser.insertRondas(rondaActual+1, idUltimaPartida);
					aux = true;
				}
				inser.insertJuegan(rondaActual+1, idUltimaPartida, nombre, numRandom, punto, respuesta);
			}else {
				int punto = 0;
				if (respuesta) {
					punto = 1;
					int puntoAnterior=puntosCPU.get(contadorCPU-1);
					puntoAnterior++;
					puntos.set(contadorCPU-1, puntoAnterior);
				}
			}
			
			if (jugadoresJugado == numeroDeJugadores) {
				if(jugadoresJugado == numeroDeJugadores && contadorCPU != maxCPU) {
					esCPU = true;
				}else {
					contadorCPU = 0;
					esCPU = false;
				}
				if(esCPU) {	
					jugarCPU();
				}
				else {					
					jugadoresJugado = 0;
					rondaActual++;
					aux = false;
					if(rondaActual != numeroDeRondas) {
						ranquing r = new ranquing(numeroDeJugadores, idUltimaPartida, nombre1, nombre2, nombre3, nombre4, nombre5, nombre6, puntos, puntosCPU, CPU1, CPU2, CPU3, CPU4, CPU5);
						r.setVisible(true);
						r.setLocationRelativeTo(null);
					}
				}
			}
			else
				pasarRondas();
			
			if (rondaActual == numeroDeRondas) {
				inser.commit();
				try {
					actualitzarHistoric();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ranquingFinal rf = null;
				rf = new ranquingFinal(numeroDeJugadores, idUltimaPartida);
				rf.setVisible(true);
				rf.setLocationRelativeTo(null);
			}
			if(!esCPU)
				jugadoresJugado++;
		}
	
		public void actualitzarHistoric() throws SQLException, IOException {
	        Map<String, Integer> unsortedMap = getPuntuacions();

	        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

	        unsortedMap.entrySet().stream()
	            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
	            .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
	        String puntuacionsstr = sortedMap.toString();
	        puntuacionsstr= puntuacionsstr.replace("{","");
	        puntuacionsstr= puntuacionsstr.replace("="," ");
	        puntuacionsstr= puntuacionsstr.replace(",","");
	        puntuacionsstr= puntuacionsstr.replace("}","");
	        File arxhistoric = new File("historic.txt");
	        if(!arxhistoric.exists()){
	            arxhistoric.createNewFile();
	        }
	        FileWriter fw = new FileWriter(arxhistoric,true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(puntuacionsstr);
	        bw.write("\n");
	        bw.close();
	        fw.close();
	    }

	    public static Map<String, Integer> getPuntuacions() throws SQLException{
	        String nom;
	        ArrayList<String> nombres = new ArrayList<String>();
	        int puntuacio;
	        Statement stmt = conexion.createStatement();
	        nombres = selec.selecNomsPartida(idUltimaPartida);
	       
	        Map<String, Integer> Puntuacions = new HashMap<String, Integer>();

	        for(int i=0;i<nombres.size();i++) {
	            nom =  nombres.get(i);
	            puntuacio = selec.sumPuntos(idUltimaPartida, nom);
	            Puntuacions.put(nom, puntuacio);
	        }
	        return Puntuacions;
	    }
    
    public void jugarCPU() {
   		
   		contadorCPU++;
    	pasarRondas();
    	   			
    }
    
    public void rollBack() {
    	inser.rollBack();
    }
}
