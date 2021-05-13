package SaberYGanar;

import BDD.Selects;

public class Letras extends Preguntas {
	static Selects selec = new Selects();
	String palabraEntera;

	public Letras(int numRandom) {
		super(selec.selecOcultaLetras(numRandom));
		this.palabraEntera = selec.selecPalabraCompleta(selec.selecOcultaLetras(numRandom));;
	}

	public String getPalabraEntera() {
		return palabraEntera;
	};
	
	
	
	
}
