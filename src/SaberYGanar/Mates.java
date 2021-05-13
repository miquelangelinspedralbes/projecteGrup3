package SaberYGanar;

import BDD.Selects;

public class Mates extends Preguntas {
	static Selects selec = new Selects();
	int resultado;

	public Mates(int number) {
		super(selec.selecEcuacioMates(number));
		resultado = selec.respuestaMates(selec.selecEcuacioMates(number));
	}

	public int getResultado() {
		return resultado;
	}	
	
	
	
}
