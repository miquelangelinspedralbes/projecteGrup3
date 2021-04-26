package SaberYGanar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import BDD.Inserts;
import BDD.Selects;
import Vistas.pantalla_preguntes_ingles;
import Vistas.pantalla_preguntes_lletres;
import Vistas.pantalla_preguntes_mates;
import Vistas.ranquing;
import Vistas.ranquingFinal;
import Vistas.selecRonda;

public class Partida {
	static int numRondas;
	static int rondaActual = 0;
	private ArrayList<String> numsJugadors = new ArrayList<String>();
	private static Scanner sc = new Scanner(System.in);
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
	public static Inserts inser = new Inserts();
	public static Selects selec = new Selects();
	
	public Partida(int numRondas, int numJugador, String[] nombreJugadores) {
		numeroDeJugadores = numJugador;
		numeroDeRondas = numRondas;
		
		inser.inserPartida();
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
			System.out.println("Puesto:" + j + " para: " + numsJugadors.get(j));
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
		cantIdIngles = selec.selecCountIngles();
		cantIdLetras = selec.selecCountLetras();
		cantIdMates = selec.selecCountMates();
		if (pregunta == 0) {				
			numRandom = (int) (Math.random()*(cantIdLetras-(cantIdIngles+1)+1)+(cantIdIngles+1));
			pantalla_preguntes_lletres pL = new pantalla_preguntes_lletres(selec.selecOcultaLetras(numRandom), nombre);
			pL.setVisible(true);
		}
		else if(pregunta == 1) {
			numRandom = (int) (Math.random()*cantIdMates);
			pantalla_preguntes_mates pM = new pantalla_preguntes_mates(selec.selecEcuacioMates(numRandom), nombre);
			pM.setVisible(true);
		}
		else{
			numRandom = (int) (Math.random()*(cantIdIngles-(cantIdMates+1)+1)+(cantIdMates+1));
			pantalla_preguntes_ingles pI = new pantalla_preguntes_ingles(selec.selecEnunciadoIngles(numRandom), selec.selecRespuestasIngles(numRandom), nombre);
			pI.setVisible(true);
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
		if (!aux) {
			inser.insertRondas(rondaActual+1, idUltimaPartida);
			aux = true;
		}
		inser.insertJuegan(rondaActual+1, idUltimaPartida, nombre, numRandom, punto, respuesta);
		
		if (jugadoresJugado == numeroDeJugadores) {
			jugadoresJugado = 0;
			rondaActual++;
			aux = false;
			if(rondaActual != numeroDeRondas) {
				ranquing r = new ranquing(numeroDeJugadores, idUltimaPartida, nombre1, nombre2, nombre3, nombre4, nombre5, nombre6);
				r.setVisible(true);
			}
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
