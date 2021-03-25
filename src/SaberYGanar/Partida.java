package SaberYGanar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Partida {
	private int numRondas;
	private Jugador numsJugadors[];
	private static Scanner sc = new Scanner(System.in);
	private static String nombre;
	conexionBD bd = new conexionBD();
	
	
	public Partida(int numRondas, int numJugador) {
		this.numRondas = numRondas;
		this.numsJugadors = new Jugador[numJugador];
	}
	
	public void ordenDeSalida() {
		ArrayList<Integer> alreadyUsedNumbers = new ArrayList<>();
		Random random = new Random();
				
		while (alreadyUsedNumbers.size()<numsJugadors.length) {

		   int randomNumber = random.nextInt(numsJugadors.length);
		   if (!alreadyUsedNumbers.contains(randomNumber)){
		      alreadyUsedNumbers.add(randomNumber);
		      System.out.println("Introduce el nombre del jugador");
		      nombre = sc.nextLine();
		      numsJugadors[randomNumber] = new Jugador(nombre);
		      
		   }
		}

		for (int i = 0; i < numsJugadors.length; i++) {
			System.out.println("Puesto " + (i+1) + " para:" + numsJugadors[i].getNombre());
		}
	}
	
	public void ronda() {
	}
}
